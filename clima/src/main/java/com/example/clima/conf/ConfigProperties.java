/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.clima.conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author davis
 */
public class ConfigProperties {
    private static ConfigProperties instancia = null;
    private Properties prop;

    private ConfigProperties() {

        prop = new Properties();
        try {
            prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\application.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigProperties getInstancia() {

        if (instancia == null) {

            instancia = new ConfigProperties();
        }
        return instancia;
    }

    public String getPropiedad(String clave) {

        return prop.getProperty(clave);
    }
}
