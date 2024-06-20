package com.proyecto_semestral.Logic;

public class Bus2Pisos extends Bus {
    public static int cantidad = 0;

    public Bus2Pisos(String horaSalida,String recorrido) {
        super(horaSalida, recorrido, ListaBuses.BUS2PISOS.getNumAsientos(), 2);
        ++cantidad;
        
    }

}
