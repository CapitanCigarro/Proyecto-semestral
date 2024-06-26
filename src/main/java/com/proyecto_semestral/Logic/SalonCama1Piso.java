package com.proyecto_semestral.Logic;

public class SalonCama1Piso extends Bus{ 
    public static int cantidad = 0;

    public SalonCama1Piso(String horaSalida, String recorrido) {
        super(horaSalida, recorrido, ListaBuses.SALONCAMA1PISO.getNumAsientos(), 1);
        ++cantidad;

    }
    
    public int getTipoBusIndex() {
        return ListaBuses.SALONCAMA1PISO.getIndex();
    }

}
