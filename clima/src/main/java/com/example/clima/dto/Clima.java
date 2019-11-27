/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.clima.dto;

/**
 *
 * @author davis
 */
public class Clima {
    
    //private int idCiudad;
    private int tempMinima;
    private int tempMaxima;
    private String dia;

    public Clima() {
    }

    public Clima(int tempMinima, int tempMaxima, String dia) {
        this.tempMinima = tempMinima;
        this.tempMaxima = tempMaxima;
        this.dia = dia;
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

    @Override
    public String toString() {
        return "Clima{" + "tempMinima=" + tempMinima + ", tempMaxima=" + tempMaxima + ", dia=" + dia + '}';
    }

   
}
