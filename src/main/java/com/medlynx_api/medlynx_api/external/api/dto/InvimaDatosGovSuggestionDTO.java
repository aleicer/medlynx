package com.medlynx_api.medlynx_api.external.api.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InvimaDatosGovSuggestionDTO {
    private final Integer expediente;
    private final String producto;
    private final String titular;
    private final String registrosanitario;
    private final Integer consecutivocum;
    private final String descripcioncomercial;
    private final String atc;
    private String nombrerol;

    public InvimaDatosGovSuggestionDTO(InvimaDatosGovResponseDTO invimaDatosGovResponseDTO) {
        this.atc = invimaDatosGovResponseDTO.getAtc();
        this.descripcioncomercial = invimaDatosGovResponseDTO.getDescripcioncomercial();
        this.consecutivocum = invimaDatosGovResponseDTO.getConsecutivocum();
        this.registrosanitario = invimaDatosGovResponseDTO.getRegistrosanitario();
        this.titular = invimaDatosGovResponseDTO.getTitular();
        this.producto = invimaDatosGovResponseDTO.getProducto();
        this.expediente = invimaDatosGovResponseDTO.getExpediente();
        this.nombrerol = invimaDatosGovResponseDTO.getNombrerol();
    }

}
