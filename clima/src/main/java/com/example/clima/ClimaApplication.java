package com.example.clima;

import com.example.clima.integracion.ClimaIntegracion;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ClimaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClimaApplication.class, args);
                //System.out.println("acaaa");
                //System.out.println(ClimaIntegracion.getXml(18578));
                /*ClimaIntegracion climaIntegracion = new ClimaIntegracion();
                String xmlResponClima = climaIntegracion.getXml(18578);
                JSONObject xmlJSONObj = XML.toJSONObject(xmlResponClima);
                System.out.println("json:: "+xmlJSONObj.toString());
                System.out.println("---");
                System.out.println(xmlJSONObj.getJSONObject("report").getJSONObject("location").getString("city"));
                JSONObject jso = (JSONObject)xmlJSONObj.getJSONObject("report").getJSONObject("location").getJSONArray("var").get(0);
                JSONArray jsoAr = (JSONArray)jso.getJSONObject("data").getJSONArray("forecast");
                System.out.println("N:: "+jsoAr);*/
	}
}

