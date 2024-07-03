package com.proyecto_semestral.Logic;

public class BusNormal extends Bus {
    public static int cantidad = 0;

    public  BusNormal(String horaSalida,String recorrido) {
        super(horaSalida, recorrido, EnumBuses.BUSNORMAL.getNumAsientos(), 1);
        ++cantidad;

    }

    public int getTipoBusIndex() {
        return EnumBuses.BUSNORMAL.getIndex();
    }

}
