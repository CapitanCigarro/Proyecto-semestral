package com.proyecto_semestral.Logic;

public enum ListaBuses {
    SALONCAMA1PISO(20),
    SALONCAMA2PISO(36), 
    MICROBUS(20),  
    BUS1PISO(30), 
    BUS2PISO(50);
    
    private final int numAsientos;

    ListaBuses(int numAsientos) {
        this.numAsientos = numAsientos;

    }

    public int getNumAsientos() {
        return this.numAsientos;

    }

}

