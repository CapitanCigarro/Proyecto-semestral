package com.proyecto_semestral.Logic;

public class BusMicrobus extends Bus {
    public static int cantidad = 0;

    public  BusMicrobus(String horaSalida,String recorrido) {
        super(horaSalida, recorrido, EnumBuses.MICROBUS.getNumAsientos(), 1);
        ++cantidad;
        
    }

    
    public int getTipoBusIndex() {
        return EnumBuses.MICROBUS.getIndex();
    }

}
