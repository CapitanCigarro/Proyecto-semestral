package com.proyecto_semestral.Logic;

/**
 * Clase que contiene los tipos de buses manejados por el codigo
 */

public enum ListaBuses {
    SalonCamaYSemiCama(16, 20, 0, "Salon Cama / Semi Salon Cama", 1.3, 1.5), 
    MICROBUS(20, 0, 1, "Microbus", 0.8, 0.8),  
    BUSNORMAL(24, 0, 2, "Bus", 1, 1);
    
    private final int asientos1erPiso;
    private final int asientos2doPiso;
    private final int index;
    private final String nombre;
    private final double modificador; 
    private final double modificador2do;

    ListaBuses(int asientos1erPiso, int asientos2doPiso, int index, String nombre, double modificador, double modificador2do) {
        this.asientos1erPiso = asientos1erPiso;
        this.asientos2doPiso = asientos2doPiso;
        this.nombre = nombre;
        this.index = index;
        this.modificador = modificador;
        this.modificador2do = modificador2do;

    }

    public int getIndex() {
        return index;
    }

    public String getNombre() {
        return nombre;
    }

    public int [] getNumAsientos() {
        int[] ret = {this.asientos1erPiso, this.asientos2doPiso};
        return ret;

    }

    public double getModificador() {
        return modificador;

    }

    public double getModificador2do() {
        return modificador2do;
    }

}

