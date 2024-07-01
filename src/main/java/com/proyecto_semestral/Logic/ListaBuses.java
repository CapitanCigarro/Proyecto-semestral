package com.proyecto_semestral.Logic;

/**
 * Clase que contiene los tipos de buses manejados por el codigo
 */

public enum ListaBuses {
    SALONCAMA1PISO(20, 0, "Salon Cama 1 piso"),
    SALONCAMA2PISOS(36, 1, "Salon cama 2 Pisos"), 
    MICROBUS(20, 2, "Microbus"),  
    BUS1PISO(24, 3, "Bus 1 piso"), 
    BUS2PISOS(40, 4, "Bus 2 pisos");
    
    private final int numAsientos;
    private final int index;
    private final String nombre;

    ListaBuses(int numAsientos, int index, String nombre) {
        this.numAsientos = numAsientos;
        this.nombre = nombre;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumAsientos() {
        return this.numAsientos;

    }

}

