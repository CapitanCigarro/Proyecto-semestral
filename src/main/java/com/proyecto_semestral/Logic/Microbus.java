package com.proyecto_semestral.Logic;

public class Microbus extends Bus {
    public static int cantidad = 0;

    public  Microbus(String horaSalida,String recorrido, int numAsientos) {
        super(horaSalida, recorrido, numAsientos, 1);
        ++cantidad;
        
    }

}
