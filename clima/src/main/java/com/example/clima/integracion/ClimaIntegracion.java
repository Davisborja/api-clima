/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.clima.integracion;

import com.example.clima.api.ClimaResponse;
import com.example.clima.conf.ConfigProperties;
import com.example.clima.dto.Clima;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

/**
 *
 * @author davis
 */
public class ClimaIntegracion {
    Logger LOG = Logger.getLogger("MyLogger");
    //Se obtienen los valores properties
     static ConfigProperties prop = ConfigProperties.getInstancia();
     static String urlBase = prop.getPropiedad("url_api_clima");
     static String affiliate_id = prop.getPropiedad("affiliate_id");
     static String api_lang = prop.getPropiedad("api_lang");
     static String localidad = prop.getPropiedad("localidad");
     //@Value("${url_api_clima}")
     
     /*
     * getXml(int idCiudad)
     * Metodo de conexión y rescate de los datos proporcionados por la  api externa
     */
    public String getXml(int idCiudad) {
       String line = "";
       try {
            //http://api.tiempo.com/index.php?api_lang=es&localidad=18578&affiliate_id=xvpckbhw8134
            String url =urlBase+api_lang+localidad+idCiudad+affiliate_id;
            System.out.println("url:: "+url);
            
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF8"));
            String temp = "";
            // se itera linea por lina obtenia y parseda a utf8 generando un cadena String con los datos obtenidos
            while ((temp = rd.readLine()) != null) {
                line += temp;
            }

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al obtener el clima : " + e.toString());
        }
        return line;
    }
   
    /*
    * ClimaResponse getClima(int idCiudad)
    * Recibe el id de la ciudad a consultar
    * Devuelve ClimaResponse con temperatura mínima y maixma ademas del día que corresponde de los proximos 7 días
    */
    public ClimaResponse generateJsonClima(int idCiudad){
        
        ClimaResponse climaResp = new ClimaResponse();
        try{
            //ClimaIntegracion climaIntegracion = new ClimaIntegracion();
            ArrayList<Clima> arrayClima = new ArrayList<>();

            String xmlResponClima = getXml(idCiudad);
            //se parsea los datos obtenidos de xml a json
            JSONObject xmlJSONObj = XML.toJSONObject(xmlResponClima);
            //se setena el nombre de la ciudad obtenida
            climaResp.setNombreCiudad(xmlJSONObj.getJSONObject("report").getJSONObject("location").getString("city"));
            //JSONArray con la temperatura mínima de los siguientes 7 días
            JSONObject jsoMinima = (JSONObject)xmlJSONObj.getJSONObject("report").getJSONObject("location").getJSONArray("var").get(0);
            JSONArray jsoAr = (JSONArray)jsoMinima.getJSONObject("data").getJSONArray("forecast");
            //JSONArray con la temperatura máxima de los siguientes 7 días
            JSONObject jsoMaxima = (JSONObject)xmlJSONObj.getJSONObject("report").getJSONObject("location").getJSONArray("var").get(1);
            JSONArray jsoAr2 = (JSONArray)jsoMaxima.getJSONObject("data").getJSONArray("forecast");
            //JSONArray con los días
            JSONObject jsoDia = (JSONObject)xmlJSONObj.getJSONObject("report").getJSONObject("location").getJSONArray("var").get(4);
            JSONArray jsoAr3 = (JSONArray)jsoDia.getJSONObject("data").getJSONArray("forecast");
            // itera los JSONArray y se genera el formato json que se usara y se agregan al objeto ClimaResponse
            for (int i = 0; i < jsoAr.length() ; i++) {
                Clima clima = new Clima();
                JSONObject json = (JSONObject)jsoAr.get(i);
                clima.setTempMinima(json.getInt("value"));
                json = (JSONObject)jsoAr2.get(i);
                clima.setTempMaxima(json.getInt("value"));
                json = (JSONObject)jsoAr3.get(i);
                clima.setDia(json.getString("value"));
                arrayClima.add(clima);
            }
            //setea ArrayList con las temperaturas obtenidas a ClimaResponse
            climaResp.setTemperaturas(arrayClima);
        }catch(Exception e){
             LOG.log(Level.SEVERE, "Error al obtener el clima : " + e.toString());
        }
        return climaResp;
    }
}
