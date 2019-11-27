/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.clima.service;

import com.example.clima.api.ClimaResponse;
import com.example.clima.dto.Clima;
import com.example.clima.integracion.ClimaIntegracion;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.json.XML;

/**
 *
 * @author davis
 */
@Service
public class ClimaService {
    Logger LOG = Logger.getLogger("MyLogger");
    /*
    * ClimaResponse getClima(int idCiudad)
    * Recibe el id de la ciudad a consultar
    * Devuelve ClimaResponse atraves del metodo generateJsonClima();
    */
    public ClimaResponse getClima(int idCiudad){
        
        ClimaResponse climaResp = new ClimaResponse();
        try{
            ClimaIntegracion climaInte = new ClimaIntegracion();
            climaResp = climaInte.generateJsonClima(idCiudad);
            
        }catch(Exception e){
             LOG.log(Level.SEVERE, "Error al obtener el clima : " + e.toString());
        }
        return climaResp;
    }
}
