package com.proyecto_semestral.Logic;

public class Bus2Pisos extends Bus {
    public static int cantidad = 0;

    public Bus2Pisos(String horaSalida,String recorrido, int numAsientos) {
        super(horaSalida, recorrido, numAsientos, 2);
        ++cantidad;
        
    }

}
