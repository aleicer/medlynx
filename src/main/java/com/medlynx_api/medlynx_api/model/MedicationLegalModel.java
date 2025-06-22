package com.medlynx_api.medlynx_api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;


@Data
@Document(collection = "MedicationsLegal")
@CompoundIndexes({
        @CompoundIndex(
                name = "expediente_consecutivocum_cantidadcum_idx",
                def = "{'expediente': 1, 'consecutivocum': 1, 'cantidadcum': 1}",
                unique = true
        )
})

public class MedicationLegalModel {
    @Id
    private String _id;

    @DBRef
    private MedicationClinicalModel medicationClinical;


    @Indexed()
    private Integer expediente;

    private String producto;
    private String titular;
    private String registrosanitario;
    private String fechaexpedicion;
    private String fechavencimiento;
    private String estadoregistro;
    private Integer expedientecum;
    private Integer consecutivocum;
    private Integer cantidadcum;
    private String descripcioncomercial;
    private String estadocum;
    private String fechaactivo;
    private String fechainactivo;
    private String muestramedica;
    private String unidad;
    private String atc;
    private String descripcionatc;
    private String viaadministracion;
    private String concentracion;
    private String principioactivo;
    private String unidadmedida;
    private Float cantidad;
    private String unidadreferencia;
    private String formafarmaceutica;
    private String nombrerol;
    private String tiporol;
    private String modalidad;
    private String ium;

    public MedicationLegalModel() {}

    public MedicationLegalModel(Integer expediente, String producto, String titular, String registrosanitario, String fechaexpedicion, String fechavencimiento, String estadoregistro, Integer expedientecum, Integer consecutivocum, Integer cantidadcum, String descripcioncomercial, String estadocum, String fechaactivo, String fechainactivo, String muestramedica, String unidad, String atc, String viaadministracion, String descripcionatc, String concentracion, String principioactivo, String unidadmedida, Float cantidad, String unidadreferencia, String formafarmaceutica, String nombrerol, String tiporol, String modalidad, String ium) {
        super();
        this.expediente = expediente;
        this.producto = producto;
        this.titular = titular;
        this.registrosanitario = registrosanitario;
        this.fechaexpedicion = fechaexpedicion;
        this.fechavencimiento = fechavencimiento;
        this.estadoregistro = estadoregistro;
        this.expedientecum = expedientecum;
        this.consecutivocum = consecutivocum;
        this.cantidadcum = cantidadcum;
        this.descripcioncomercial = descripcioncomercial;
        this.estadocum = estadocum;
        this.fechaactivo = fechaactivo;
        this.fechainactivo = fechainactivo;
        this.muestramedica = muestramedica;
        this.unidad = unidad;
        this.atc = atc;
        this.viaadministracion = viaadministracion;
        this.descripcionatc = descripcionatc;
        this.concentracion = concentracion;
        this.principioactivo = principioactivo;
        this.unidadmedida = unidadmedida;
        this.cantidad = cantidad;
        this.unidadreferencia = unidadreferencia;
        this.formafarmaceutica = formafarmaceutica;
        this.nombrerol = nombrerol;
        this.tiporol = tiporol;
        this.modalidad = modalidad;
        this.ium = ium;
    }
}
