package com.proyecto_semestral.Logic;

public class SalonCama1Piso extends Bus{ 
    public static int cantidad = 0;

    public SalonCama1Piso(String horaSalida, String recorrido, int numAsientos) {
        super(horaSalida, recorrido, numAsientos, 1);
        ++cantidad;

    }

}
