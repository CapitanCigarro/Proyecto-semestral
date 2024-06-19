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

    

    public Bus crearBus(String horaSalida, String recorrido) {
        switch (this) {
            case SALONCAMA1PISO:
                return new SalonCama1Piso(horaSalida, recorrido, this.numAsientos);
        
            case SALONCAMA2PISOS:
                return new SalonCama2Pisos(horaSalida, recorrido, this.numAsientos);

            case MICROBUS:
                return new Microbus(horaSalida, recorrido, this.numAsientos);

            case BUS1PISO:
                return new Bus1Piso(horaSalida, recorrido, this.numAsientos);

            case BUS2PISOS:
                return new Bus2Pisos(horaSalida, recorrido, this.numAsientos);

            default:
                return null;
        }   
    }

}

