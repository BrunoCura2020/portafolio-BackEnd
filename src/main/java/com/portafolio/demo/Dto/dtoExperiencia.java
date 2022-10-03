/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.demo.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {
    @NotBlank
    private String lugar;
    @NotBlank
    private String puesto;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String inicio;
    @NotBlank
    private String fin;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String lugar, String puesto, String descripcion, String inicio, String fin) {
        this.lugar = lugar;
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    
}
