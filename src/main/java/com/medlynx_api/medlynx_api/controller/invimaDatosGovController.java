package com.medlynx_api.medlynx_api.controller;

import com.medlynx_api.medlynx_api.external.api.InvimaDatoGovClient;
import com.medlynx_api.medlynx_api.external.api.dto.InvimaDatosGovResponseDTO;
import com.medlynx_api.medlynx_api.external.api.dto.InvimaDatosGovSuggestionDTO;
import com.medlynx_api.medlynx_api.external.ia.ContentAIClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/datos-gov")
public class invimaDatosGovController {

    @Autowired
    private InvimaDatoGovClient invimaDatoGovClient;

    @Autowired
    private ContentAIClient contentAIClient;

    @GetMapping("/suggestions")
    public List<InvimaDatosGovSuggestionDTO> getMedicinesInvimaVigente(
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "type", required = false, defaultValue = "vigente") String type
    ) {
        return invimaDatoGovClient.getMedicinesInvimaDatosGov(search, type);
    }

    @GetMapping("/search")
    public InvimaDatosGovResponseDTO getMedicineByCriteria(
            @RequestParam(name = "expediente", required = false) String expediente,
            @RequestParam(name = "consecutivocum", required = false) String consecutivocum,
            @RequestParam(name = "nombrerol", required = false) String nombrerol,
            @RequestParam(name = "type", required = false, defaultValue = "vigente") String type
    ) {
        return invimaDatoGovClient.getMedicinesInvimaDatosGovById(expediente, consecutivocum, nombrerol, type);
    }
}
