package com.medlynx_api.medlynx_api.external.ia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medlynx_api.medlynx_api.external.ia.dto.ResponseGeminiDTO;
import org.springframework.stereotype.Service;
import com.google.common.collect.ImmutableMap;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.Schema;
import com.google.genai.types.Type;

@Service
public class ContentAIClient {
    private final ContentAISchema contentAISchema = new ContentAISchema();
    private final ObjectMapper objectMapper = new ObjectMapper();


    public ResponseGeminiDTO generateContent(String medicineName, String invimaNumber, String activeIngredient) {
        System.out.println("Generating content for " + medicineName + " with INVIMA: " + invimaNumber +
                " and active ingredient: " + activeIngredient);
        try {
            Client client = new Client();

            Schema schema = contentAISchema.buildMedicamentoSchema();
            GenerateContentConfig config =
                    GenerateContentConfig.builder()
                            .responseMimeType("application/json")
                            .candidateCount(1)
                            .responseSchema(schema)
                            .build();

            GenerateContentResponse response =
                    client.models.generateContent(
//                            "gemini-1.5-flash-002",
                            "gemini-2.0-flash-lite",
                            "Eres un asistente médico experto en farmacología. Dado el medicamento " + medicineName +
                                    ", INVIMA: " + invimaNumber + ", principio activo: " + activeIngredient +
                                    ", por favor, proporciona información detallada sobre su uso, contraindicaciones, formas de uso, dosis sugerida y enfermedades en las que se utiliza. Estructura la respuesta exactamente con el schema que fue proporcionado.",
                            config);

            String jsonResponse = response.text();
            return objectMapper.readValue(jsonResponse, ResponseGeminiDTO.class);

        } catch (Exception e) {
            System.err.println("Error generating content: " + e.getMessage());
        }
        return null;
    }
}
