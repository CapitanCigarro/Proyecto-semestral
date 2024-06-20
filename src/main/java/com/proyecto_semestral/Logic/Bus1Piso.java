package com.proyecto_semestral.Logic;

public class Bus1Piso extends Bus {
    public static int cantidad = 0;

    public  Bus1Piso(String horaSalida,String recorrido) {
        super(horaSalida, recorrido, ListaBuses.BUS1PISO.getNumAsientos(), 1);
        ++cantidad;

    }

}
