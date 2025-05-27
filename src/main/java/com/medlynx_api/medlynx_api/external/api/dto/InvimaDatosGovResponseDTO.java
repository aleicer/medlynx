package com.medlynx_api.medlynx_api.external.api.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InvimaDatosGovResponseDTO {
    private Integer expediente;
    private String producto;
    private String titular;
    private String registrosanitario;
    private String fechaexpedicion;
    private String fechavencimiento;
    private String estadoregistro;
    private Integer expedientecum;
    private Integer consecutivocum;
    private Integer cantidadcum;
    private String descripcioncomercial;
    private String estadocum;
    private String fechaactivo;
    private String fechainactivo;
    private String muestramedica;
    private String unidad;
    private String atc;
    private String descripcionatc;
    private String viaadministracion;
    private String concentracion;
    private String principioactivo;
    private String unidadmedida;
    private Float cantidad;
    private String unidadreferencia;
    private String formafarmaceutica;
    private String nombrerol;
    private String tiporol;
    private String modalidad;
    private String ium;

    public InvimaDatosGovResponseDTO() {}

    public InvimaDatosGovResponseDTO(Integer expediente, String producto, String titular, String registrosanitario, String fechaexpedicion, String fechavencimiento, String estadoregistro, Integer expedientecum, Integer consecutivocum, Integer cantidadcum, String descripcioncomercial, String estadocum, String fechaactivo, String fechainactivo, String muestramedica, String unidad, String atc, String viaadministracion, String descripcionatc, String concentracion, String principioactivo, String unidadmedida, Float cantidad, String unidadreferencia, String formafarmaceutica, String nombrerol, String tiporol, String modalidad, String ium) {
        this.expediente = expediente;
        this.producto = producto;
        this.titular = titular;
        this.registrosanitario = registrosanitario;
        this.fechaexpedicion = fechaexpedicion;
        this.fechavencimiento = fechavencimiento;
        this.estadoregistro = estadoregistro;
        this.expedientecum = expedientecum;
        this.consecutivocum = consecutivocum;
        this.cantidadcum = cantidadcum;
        this.descripcioncomercial = descripcioncomercial;
        this.estadocum = estadocum;
        this.fechaactivo = fechaactivo;
        this.fechainactivo = fechainactivo;
        this.muestramedica = muestramedica;
        this.unidad = unidad;
        this.atc = atc;
        this.viaadministracion = viaadministracion;
        this.descripcionatc = descripcionatc;
        this.concentracion = concentracion;
        this.principioactivo = principioactivo;
        this.unidadmedida = unidadmedida;
        this.cantidad = cantidad;
        this.unidadreferencia = unidadreferencia;
        this.formafarmaceutica = formafarmaceutica;
        this.nombrerol = nombrerol;
        this.tiporol = tiporol;
        this.modalidad = modalidad;
        this.ium = ium;
    }

}
