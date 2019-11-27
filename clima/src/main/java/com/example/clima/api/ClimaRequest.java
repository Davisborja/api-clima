/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.clima.api;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author davis
 */
public class ClimaRequest {
    @NotNull(message="El id de la ciudad es requerido")
    @Size(min=1, message="El id de la ciudad debe tener mínimo {min} caracteres")
    private int idCiudad;
    private int tempMinima;
    private int tempMaxima;
    private String dia;

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getTempMinima() {
        return tempMinima;
    }

    public void setTempMinima(int tempMinima) {
        this.tempMinima = tempMinima;
    }

    public int getTempMaxima() {
        return tempMaxima;
    }

    public void setTempMaxima(int tempMaxima) {
        this.tempMaxima = tempMaxima;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    
    
}
