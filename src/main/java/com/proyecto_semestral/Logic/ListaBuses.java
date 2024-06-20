package com.proyecto_semestral.Logic;

public enum ListaBuses {
    SALONCAMA1PISO(20),
    SALONCAMA2PISOS(36), 
    MICROBUS(20),  
    BUS1PISO(24), 
    BUS2PISOS(40);
    
    private final int numAsientos;

    ListaBuses(int numAsientos) {
        this.numAsientos = numAsientos;
    }

    public int getNumAsientos() {
        return this.numAsientos;

    }

}

