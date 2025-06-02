package com.medlynx_api.medlynx_api;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.google.common.collect.ImmutableMap;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.Schema;
import com.google.genai.types.Type;

@SpringBootApplication
public class MedlynxApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedlynxApiApplication.class, args);
	}
//	@Bean
//	CommandLineRunner commandLineRunner(ChatClient.Builder builder) {
//		return args -> {
//			try {
//				var chatClient = builder.build();
//				String response = chatClient.prompt("Eres un asistente especializado en farmacología clínica y medicina basada en evidencia. Basado en la información proporcionada de un medicamento, responde exclusivamente con un JSON estructurado, sin explicaciones, sin texto adicional.\n" +
//								"\n" +
//								"Proporciona únicamente la siguiente información clínica y útil para profesionales de la salud y farmacias:\n" +
//								"\n" +
//								"- \"clinical_use\": uso clínico principal del medicamento en lenguaje médico estándar\n" +
//								"- \"suggested_dosage\": dosis comúnmente recomendada para adultos (y niños si aplica), incluyendo la vía de administración\n" +
//								"- \"contraindications\": lista de contraindicaciones médicas importantes\n" +
//								"- \"adverse_effects\": lista de los efectos adversos frecuentes\n" +
//								"- \"precautions\": precauciones generales o advertencias al usar el medicamento\n" +
//								"- \"common_interactions\": interacciones comunes con otros medicamentos\n" +
//								"\n" +
//								"Asegúrate de que el contenido sea confiable, claro y basado en datos médicos reconocidos.\n" +
//								"\n" +
//								"El medicamento a analizar es: SECNICHEN POLVO PARA RECONSTITUIR A SUSPENSIÓN ORAL, laboratorio: BIOCHEM FARMACEUTICA DE COLOMBIAS.A., invima: 2017M-005009-R2\n")
//						.call()
//						.content();
//				System.out.println(response);
//			} catch (Exception e) {
//				System.err.println("Error al obtener respuesta del chat: " + e.getMessage());
//			}
//		};
//	}

}
