package com.medlynx_api.medlynx_api.external.ia;

import com.google.genai.types.Schema;
import com.google.genai.types.Type;
import com.google.common.collect.ImmutableMap;

public class ContentAISchema {

    public Schema buildMedicamentoSchema() {
        return Schema.builder()
                .type(Type.Known.OBJECT)
                .properties(
                        ImmutableMap.of(
                                "nombre_medicamento", Schema.builder().type(Type.Known.STRING).description("Nombre del Medicamento (viene escrito en el promp)").build(),
                                "invima", Schema.builder().type(Type.Known.STRING).description("Número de Registro INVIMA (viene escrito en el promp)").build(),
                                "principio_activo", Schema.builder().type(Type.Known.STRING).description("Principio Activo del Medicamento (viene escrito en el promp)").build(),
                                "informacion_general", Schema.builder().type(Type.Known.STRING).description("Descripción concisa del medicamento y su uso principal.").build(),
                                "usos_y_tratamiento", buildUsosYTratamientoSchema(),
                                "contraindicaciones_y_precauciones", buildContraindicacionesYPrecaucionesSchema(),
                                "notas_adicionales", Schema.builder().type(Type.Known.STRING).description("Cualquier otra información relevante").build()
                        )
                )
                .build();
    }

    private Schema buildUsosYTratamientoSchema() {
        return Schema.builder()
                .type(Type.Known.OBJECT)
                .properties(
                        ImmutableMap.of(
                                "indicaciones_principales", Schema.builder()
                                        .type(Type.Known.ARRAY)
                                        .items(
                                                Schema.builder()
                                                        .type(Type.Known.OBJECT)
                                                        .properties(
                                                                ImmutableMap.of(
                                                                        "enfermedad", Schema.builder().type(Type.Known.STRING).description("Nombre de la enfermedad o condición").build(),
                                                                        "descripcion_uso", Schema.builder().type(Type.Known.STRING).description("Breve descripción de cómo se utiliza el medicamento para esta condición.").build()
                                                                )
                                                        )
                                                        .build()
                                        )
                                        .build(),
                                "mecanismo_accion", Schema.builder().type(Type.Known.STRING).description("Breve explicación de cómo funciona el medicamento en el cuerpo").build(),
                                "formas_de_uso", buildFormasDeUsoSchema()
                        )
                )
                .build();
    }

    private Schema buildFormasDeUsoSchema() {
        return Schema.builder()
                .type(Type.Known.OBJECT)
                .properties(
                        ImmutableMap.of(
                                "presentaciones_comunes", Schema.builder()
                                        .type(Type.Known.ARRAY)
                                        .items(Schema.builder().type(Type.Known.STRING).build())
                                        .description("Lista de presentaciones comunes del medicamento").build(),
                                "via_administracion", Schema.builder().type(Type.Known.STRING).description("Vía de administración (Oral, Tópica, Intravenosa, etc.)").build(),
                                "instrucciones_especificas", Schema.builder().type(Type.Known.STRING).description("Cualquier instrucción especial sobre cómo tomar o aplicar el medicamento").build()
                        )
                )
                .build();
    }

    private Schema buildContraindicacionesYPrecaucionesSchema() {
        return Schema.builder()
                .type(Type.Known.OBJECT)
                .properties(
                        ImmutableMap.of(
                                "contraindicaciones", Schema.builder()
                                        .type(Type.Known.ARRAY)
                                        .items(
                                                Schema.builder()
                                                        .type(Type.Known.OBJECT)
                                                        .properties(
                                                                ImmutableMap.of(
                                                                        "tipo", Schema.builder().type(Type.Known.STRING).description("Absoluta / Relativa").build(),
                                                                        "descripcion", Schema.builder().type(Type.Known.STRING).description("Condición o situación en la que el medicamento no debe usarse.").build()
                                                                )
                                                        )
                                                        .build()
                                        )
                                        .build(),
                                "efectos_secundarios_comunes", Schema.builder()
                                        .type(Type.Known.ARRAY)
                                        .items(Schema.builder().type(Type.Known.STRING).build())
                                        .description("Efectos secundarios comunes").build(),
                                "efectos_secundarios_graves", Schema.builder()
                                        .type(Type.Known.ARRAY)
                                        .items(Schema.builder().type(Type.Known.STRING).build())
                                        .description("Efectos secundarios graves").build()
                        )
                )
                .build();
    }
}
