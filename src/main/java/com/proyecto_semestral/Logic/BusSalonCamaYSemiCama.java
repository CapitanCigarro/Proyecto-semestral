package com.proyecto_semestral.Logic;

public class BusSalonCamaYSemiCama extends Bus{ 
    public static int cantidad = 0;

    public BusSalonCamaYSemiCama(String horaSalida, String recorrido) {
        super(horaSalida, recorrido, ListaBuses.SalonCamaYSemiCama.getNumAsientos(), 2);
        ++cantidad;

    }
    
    public int getTipoBusIndex() {
        return ListaBuses.SalonCamaYSemiCama.getIndex();
    }

}
