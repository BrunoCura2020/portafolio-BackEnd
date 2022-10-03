/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.demo.Dto;

import javax.validation.constraints.NotBlank;

public class dtoAcercaDe {
    @NotBlank
    private String descripcion;

    public dtoAcercaDe() {
    }

    public dtoAcercaDe(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
