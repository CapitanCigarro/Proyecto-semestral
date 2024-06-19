package com.proyecto_semestral.Logic;

public class SalonCama2Pisos extends Bus{ 
    public static int cantidad = 0;

    public SalonCama2Pisos(String horaSalida, String recorrido, int numAsientos) {
        super(horaSalida, recorrido, numAsientos, 2);
        ++cantidad;

    }
    
}