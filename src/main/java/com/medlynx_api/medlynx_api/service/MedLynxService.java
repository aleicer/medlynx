
package com.medlynx_api.medlynx_api.service;

import com.medlynx_api.medlynx_api.dto.CreateMedLynxDTO;
import com.medlynx_api.medlynx_api.external.ia.dto.ResponseGeminiDTO;
import com.medlynx_api.medlynx_api.model.MedicationClinicalModel;
import com.medlynx_api.medlynx_api.model.MedicationLegalModel;
import com.medlynx_api.medlynx_api.repository.MedicationClinicalRepository;
import com.medlynx_api.medlynx_api.repository.MedicationLegalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.mongodb.core.MongoTemplate;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedLynxService {
    @Autowired
    private MedicationLegalRepository medicationLegalRepository;

    @Autowired
    private MedicationClinicalRepository medicationClinicalRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    private MedicationClinicalModel.ContraindicacionesPrecauciones mapContraindicaciones(ResponseGeminiDTO.ContraindicacionesPrecaucionesDTO dto) {
        if (dto == null) return null;

        MedicationClinicalModel.ContraindicacionesPrecauciones model = new MedicationClinicalModel.ContraindicacionesPrecauciones();
        model.setContraindicaciones(dto.getContraindicaciones().stream()
                .map(c -> {
                    MedicationClinicalModel.Contraindicacion contraindicacion = new MedicationClinicalModel.Contraindicacion();
                    contraindicacion.setDescripcion(c.getDescripcion());
                    contraindicacion.setTipo(c.getTipo());
                    return contraindicacion;
                })
                .collect(Collectors.toList()));
        model.setEfectos_secundarios_comunes(dto.getEfectos_secundarios_comunes());
        model.setEfectos_secundarios_graves(dto.getEfectos_secundarios_graves());
        return model;
    }

    private MedicationClinicalModel.UsosTratamiento mapUsosTratamiento(ResponseGeminiDTO.UsosTratamientoDTO dto) {
        if (dto == null) return null;

        MedicationClinicalModel.UsosTratamiento model = new MedicationClinicalModel.UsosTratamiento();

        // Mapear mecanismo de acción
        model.setMecanismo_accion(dto.getMecanismo_accion());

        // Mapear formas de uso
        if (dto.getFormas_de_uso() != null) {
            MedicationClinicalModel.FormasUso formasUso = new MedicationClinicalModel.FormasUso();
            formasUso.setInstrucciones_especificas(dto.getFormas_de_uso().getInstrucciones_especificas());
            formasUso.setPresentaciones_comunes(dto.getFormas_de_uso().getPresentaciones_comunes());
            formasUso.setVia_administracion(dto.getFormas_de_uso().getVia_administracion());
            model.setFormas_de_uso(formasUso);
        }
        // Mapear indicaciones principales
        if (dto.getIndicaciones_principales() != null) {
            model.setIndicaciones_principales(dto.getIndicaciones_principales().stream()
                    .map(indicacion -> {
                        MedicationClinicalModel.IndicacionPrincipal indicacionModel =
                                new MedicationClinicalModel.IndicacionPrincipal();
                        indicacionModel.setDescripcion_uso(indicacion.getDescripcion_uso());
                        indicacionModel.setEnfermedad(indicacion.getEnfermedad());
                        return indicacionModel;
                    })
                    .collect(Collectors.toList()));
        }
        return model;
    }

    @Transactional
    public void saveMedicationInfo(CreateMedLynxDTO medication) {
        ResponseGeminiDTO responseGeminiDTO = medication.getResponseGemini();

        if (responseGeminiDTO != null) {
            Integer expediente = medication.getInvimaDatosGovResponse().getExpediente();
            Integer consecutivocum = medication.getInvimaDatosGovResponse().getConsecutivocum();
            Integer cantidadcum = medication.getInvimaDatosGovResponse().getCantidadcum();

            List<MedicationLegalModel> existingMedications = medicationLegalRepository
                    .findByExpedienteAndConsecutivocumAndCantidadcum(
                            expediente,
                            consecutivocum,
                            cantidadcum
                    );

            if (!existingMedications.isEmpty()) return;
            // 1. Crear y guardar MedicationClinicalModel
            MedicationClinicalModel medicationClinicalModel = new MedicationClinicalModel();

            // Mapear los datos del ResponseGeminiDTO al MedicationClinicalModel
            medicationClinicalModel.setContraindicaciones_y_precauciones(mapContraindicaciones(
                    responseGeminiDTO.getContraindicaciones_y_precauciones())
            );
            medicationClinicalModel.setInformacion_general(responseGeminiDTO.getInformacion_general());
            medicationClinicalModel.setInvima(responseGeminiDTO.getInvima());
            medicationClinicalModel.setNombre_medicamento(responseGeminiDTO.getNombre_medicamento());
            medicationClinicalModel.setNotas_adicionales(responseGeminiDTO.getNotas_adicionales());
            medicationClinicalModel.setPrincipio_activo(responseGeminiDTO.getPrincipio_activo());
            medicationClinicalModel.setUsos_y_tratamiento(
                    mapUsosTratamiento(responseGeminiDTO.getUsos_y_tratamiento())
            );


            // Guardar MedicationClinicalModel
            MedicationClinicalModel savedClinicalModel = medicationClinicalRepository.save(medicationClinicalModel);

            // 2. Crear y guardar MedicationLegalModel con la referencia
            MedicationLegalModel medicationLegalModel = new MedicationLegalModel(
                    medication.getInvimaDatosGovResponse().getExpediente(),
                    medication.getInvimaDatosGovResponse().getProducto(),
                    medication.getInvimaDatosGovResponse().getTitular(),
                    medication.getInvimaDatosGovResponse().getRegistrosanitario(),
                    medication.getInvimaDatosGovResponse().getFechaexpedicion(),
                    medication.getInvimaDatosGovResponse().getFechavencimiento(),
                    medication.getInvimaDatosGovResponse().getEstadoregistro(),
                    medication.getInvimaDatosGovResponse().getExpedientecum(),
                    medication.getInvimaDatosGovResponse().getConsecutivocum(),
                    medication.getInvimaDatosGovResponse().getCantidadcum(),
                    medication.getInvimaDatosGovResponse().getDescripcioncomercial(),
                    medication.getInvimaDatosGovResponse().getEstadocum(),
                    medication.getInvimaDatosGovResponse().getFechaactivo(),
                    medication.getInvimaDatosGovResponse().getFechainactivo(),
                    medication.getInvimaDatosGovResponse().getMuestramedica(),
                    medication.getInvimaDatosGovResponse().getUnidad(),
                    medication.getInvimaDatosGovResponse().getAtc(),
                    medication.getInvimaDatosGovResponse().getViaadministracion(),
                    medication.getInvimaDatosGovResponse().getDescripcionatc(),
                    medication.getInvimaDatosGovResponse().getConcentracion(),
                    medication.getInvimaDatosGovResponse().getPrincipioactivo(),
                    medication.getInvimaDatosGovResponse().getUnidadmedida(),
                    medication.getInvimaDatosGovResponse().getCantidad(),
                    medication.getInvimaDatosGovResponse().getUnidadreferencia(),
                    medication.getInvimaDatosGovResponse().getFormafarmaceutica(),
                    medication.getInvimaDatosGovResponse().getNombrerol(),
                    medication.getInvimaDatosGovResponse().getTiporol(),
                    medication.getInvimaDatosGovResponse().getModalidad(),
                    medication.getInvimaDatosGovResponse().getIum()
            );

            // Establecer la referencia al MedicationClinicalModel
            medicationLegalModel.setMedicationClinical(savedClinicalModel);

            // Guardar MedicationLegalModel
            medicationLegalRepository.save(medicationLegalModel);
        }
    }

    public List<MedicationLegalModel> findMedicationsByFilters(
            Integer expediente,
            Integer consecutivocum,
            Integer cantidadcum) {

        // Usar valores vacíos si los parámetros son null
        expediente = expediente != null ? expediente : 0;
        consecutivocum = consecutivocum != null ? consecutivocum : 0;
        cantidadcum = cantidadcum != null ? cantidadcum : 0;
        System.out.println("expediente: " + expediente);
        System.out.println("consecutivocum: " + consecutivocum);
        System.out.println("cantidadcum: " + cantidadcum);
        return medicationLegalRepository
                .findByExpedienteAndConsecutivocumAndCantidadcum(
                        expediente,
                        consecutivocum,
                        cantidadcum
                );
    }

}