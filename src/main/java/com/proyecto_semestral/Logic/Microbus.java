package com.proyecto_semestral.Logic;

public class Microbus extends Bus {
    public static int cantidad = 0;

    public  Microbus(String horaSalida,String recorrido) {
        super(horaSalida, recorrido, ListaBuses.MICROBUS.getNumAsientos(), 1);
        ++cantidad;
        
    }

    
    public int getTipoBusIndex() {
        return ListaBuses.MICROBUS.getIndex();
    }

}
