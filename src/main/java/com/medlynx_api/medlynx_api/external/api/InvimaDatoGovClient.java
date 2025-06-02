package com.medlynx_api.medlynx_api.external.api;

import com.medlynx_api.medlynx_api.external.api.dto.InvimaDatosGovResponseDTO;
import com.medlynx_api.medlynx_api.external.api.dto.InvimaDatosGovSuggestionDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class InvimaDatoGovClient {
    private final RestTemplate restTemplate;

    @Value("${MEDICINES_INVIMA_VIGENTE_API}")
    private String BASE_URL_VIGENTE;
    @Value("${MEDICINES_INVIMA_RENOVACION_API}")
    private String BASE_URL_RENOVACION;
    @Value("${MEDICINES_INVIMA_VENCIDO_API}")
    private String BASE_URL_VENCIDO;
    @Value("${MEDICINES_INVIMA_OTRO_API}")
    private String BASE_URL_OTRO;

    @Value("${TOKEN_API_DATOSGOV}")
    private String apiKey;

    private Map<String, String> urlMap;

    public InvimaDatoGovClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    private void initializeUrlMap() {
        urlMap = Map.of(
                "vigente", BASE_URL_VIGENTE,
                "renovacion", BASE_URL_RENOVACION,
                "vencido", BASE_URL_VENCIDO,
                "otro", BASE_URL_OTRO
        );
    }


    public List<InvimaDatosGovSuggestionDTO> getMedicinesInvimaDatosGov(String search, String type) {
        String baseUrl = urlMap.getOrDefault(type, BASE_URL_OTRO);
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-App-Token", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = baseUrl + "?$query=SELECT * ORDER BY `:id` ASC NULL LAST SEARCH \"" + search + "\" LIMIT 50 OFFSET 0&";
        System.out.println(url);
        ResponseEntity<InvimaDatosGovResponseDTO[]> response = this.restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                InvimaDatosGovResponseDTO[].class
        );
        assert response.getBody() != null;
        InvimaDatosGovSuggestionDTO[] invimaDatosGovSuggestionDTO = Arrays.stream(response.getBody())
                .map(InvimaDatosGovSuggestionDTO::new)
                .toArray(InvimaDatosGovSuggestionDTO[]::new);
        return Arrays.asList(invimaDatosGovSuggestionDTO);
    }

    public InvimaDatosGovResponseDTO getMedicinesInvimaDatosGovById(
            String expediente,
            String consecutivocum,
            String nombrerol,
            String type
    ) {
        String baseUrl = urlMap.getOrDefault(type, BASE_URL_OTRO);
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-App-Token", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = baseUrl + "?$query=SELECT * WHERE `expediente` = '" + expediente + "' AND `consecutivocum` = " +
                consecutivocum + " AND `nombrerol` = '" + nombrerol + "'&";
        System.out.println(url);
        ResponseEntity<InvimaDatosGovResponseDTO[]> response = this.restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                InvimaDatosGovResponseDTO[].class
        );
        if (response.getBody() != null && response.getBody().length > 0) {
            return response.getBody()[0];
        } else {
            return null;
        }
    }
}
