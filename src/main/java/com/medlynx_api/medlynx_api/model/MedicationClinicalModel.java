
package com.medlynx_api.medlynx_api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document(collection = "MedicationsClinical")
public class MedicationClinicalModel {
    @Id
    private String _id;
    private ContraindicacionesPrecauciones contraindicaciones_y_precauciones;
    private String informacion_general;
    private String invima;
    private String nombre_medicamento;
    private String notas_adicionales;
    private String principio_activo;
    private UsosTratamiento usos_y_tratamiento;

    @Data
    public static class ContraindicacionesPrecauciones {
        private List<Contraindicacion> contraindicaciones;
        private List<String> efectos_secundarios_comunes;
        private List<String> efectos_secundarios_graves;
    }

    @Data
    public static class Contraindicacion {
        private String descripcion;
        private String tipo;
    }

    @Data
    public static class UsosTratamiento {
        private FormasUso formas_de_uso;
        private List<IndicacionPrincipal> indicaciones_principales;
        private String mecanismo_accion;
    }

    @Data
    public static class FormasUso {
        private String instrucciones_especificas;
        private List<String> presentaciones_comunes;
        private String via_administracion;
    }

    @Data
    public static class IndicacionPrincipal {
        private String descripcion_uso;
        private String enfermedad;
    }
}