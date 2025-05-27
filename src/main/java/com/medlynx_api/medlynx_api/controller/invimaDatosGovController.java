package com.medlynx_api.medlynx_api.controller;

import com.medlynx_api.medlynx_api.external.api.InvimaDatoGovClient;
import com.medlynx_api.medlynx_api.external.api.dto.InvimaDatosGovSuggestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class invimaDatosGovController {

    @Autowired
    private InvimaDatoGovClient invimaDatoGovClient;

    @GetMapping("/invima-datos-gov")
    public List<InvimaDatosGovSuggestionDTO> getMedicinesInvimaVigente(
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "type", required = false, defaultValue = "vigente") String type
    ) {
        return invimaDatoGovClient.getMedicinesInvimaVigente(search, type);
    }
}
