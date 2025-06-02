package com.medlynx_api.medlynx_api.external.ia.dto;

import lombok.Data;
import java.util.List;

@Data
public class ResponseGeminiDTO {
    private ContraindicacionesPrecaucionesDTO contraindicaciones_y_precauciones;
    private String informacion_general;
    private String invima;
    private String nombre_medicamento;
    private String notas_adicionales;
    private String principio_activo;
    private UsosTratamientoDTO usos_y_tratamiento;

    @Data
    public static class ContraindicacionesPrecaucionesDTO {
        private List<ContraindicacionDTO> contraindicaciones;
        private List<String> efectos_secundarios_comunes;
        private List<String> efectos_secundarios_graves;
    }

    @Data
    public static class ContraindicacionDTO {
        private String descripcion;
        private String tipo;
    }

    @Data
    public static class UsosTratamientoDTO {
        private FormasUsoDTO formas_de_uso;
        private List<IndicacionPrincipalDTO> indicaciones_principales;
        private String mecanismo_accion;
    }

    @Data
    public static class FormasUsoDTO {
        private String instrucciones_especificas;
        private List<String> presentaciones_comunes;
        private String via_administracion;
    }

    @Data
    public static class IndicacionPrincipalDTO {
        private String descripcion_uso;
        private String enfermedad;
    }
}
