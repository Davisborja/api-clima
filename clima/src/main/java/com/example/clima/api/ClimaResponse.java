/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.clima.api;

import com.example.clima.dto.Clima;
import java.util.ArrayList;


/**
 *
 * @author davis
 */
public class ClimaResponse {
    
   private String nombreCiudad;
   private ArrayList<Clima> temperaturas;

    public ArrayList<Clima> getTemperaturas() {
        return temperaturas;
    }

    public void setTemperaturas(ArrayList<Clima> temperaturas) {
        this.temperaturas = temperaturas;
    }
   
    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
   
   
}
