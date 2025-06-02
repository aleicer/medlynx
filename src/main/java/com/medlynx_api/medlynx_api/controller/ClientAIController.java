package com.medlynx_api.medlynx_api.controller;

import com.medlynx_api.medlynx_api.external.ia.ContentAIClient;
import com.medlynx_api.medlynx_api.external.ia.dto.ResponseGeminiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client-ai")
public class ClientAIController {

    @Autowired
    private ContentAIClient contentAIClient;

    @GetMapping("/gemini")
    public ResponseGeminiDTO getDataFromGemini(
            @RequestParam(name = "medicineName", required = false) String medicineName,
            @RequestParam(name = "invimaNumber", required = false) String invimaNumber,
            @RequestParam(name = "activeIngredient", required = false) String activeIngredient
    ) {
        return contentAIClient.generateContent(medicineName, invimaNumber, activeIngredient);
    }
}
