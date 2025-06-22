package com.medlynx_api.medlynx_api.dto;

import com.medlynx_api.medlynx_api.external.api.dto.InvimaDatosGovResponseDTO;
import com.medlynx_api.medlynx_api.external.ia.dto.ResponseGeminiDTO;
import lombok.Data;

@Data
public class CreateMedLynxDTO {
    private InvimaDatosGovResponseDTO invimaDatosGovResponse;
    private ResponseGeminiDTO responseGemini;
}
