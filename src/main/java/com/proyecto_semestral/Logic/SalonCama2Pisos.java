package com.proyecto_semestral.Logic;

public class SalonCama2Pisos extends Bus{ 
    public static int cantidad = 0;

    public SalonCama2Pisos(String horaSalida, String recorrido) {
        super(horaSalida, recorrido, ListaBuses.SALONCAMA2PISOS.getNumAsientos(), 2);
        ++cantidad;

    }
    
    public int getTipoBusIndex() {
        return ListaBuses.SALONCAMA2PISOS.getIndex();
    }
    
}