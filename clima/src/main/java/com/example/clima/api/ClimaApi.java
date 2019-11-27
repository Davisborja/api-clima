/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.clima.api;

import com.example.clima.service.ClimaService;
import com.example.clima.utils.BusinessServiceException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author davis
 */
@RestController
//@RequestMapping("/V1")
public class ClimaApi {
    @Autowired
    ClimaService climaService;
    @Autowired
    Mapper mapper;
    @Autowired
    BusinessServiceException businessServiceException;
    
    Logger LOG = Logger.getLogger("MyLogger");
    
    @RequestMapping(value="/apiClima/{id}", method=RequestMethod.GET)
    //@GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<?> getById(@PathVariable("id") @RequestBody @Valid String idCiudad){
        if (idCiudad == null || idCiudad.equalsIgnoreCase("")) {
                //validación de parametro de entrada con retorno de error parametrizado en errors.xml
                return businessServiceException.getError("mandatoryParametersMissingExplicit", "id");
        }
        if (idCiudad.length() <= 0){
                //validación de parametro de entrada con retorno de error parametrizado en errors.xml
                return businessServiceException.getError("parameterNotRequiredLength", "id");
        }
        ClimaResponse climaResponse;
        try{
            // Invoca lógica de negocio
            ClimaResponse miClima = climaService.getClima(Integer.parseInt(idCiudad));
            // Mapeo
            climaResponse = mapper.map(miClima, ClimaResponse.class); 
        }catch(Exception e){
            LOG.log(Level.SEVERE, "Error al obtener el clima : " + e.toString());
            return businessServiceException.getError("wrongParameters", e.toString());
        }
        return new ResponseEntity<>(climaResponse, HttpStatus.OK);
    }
}
