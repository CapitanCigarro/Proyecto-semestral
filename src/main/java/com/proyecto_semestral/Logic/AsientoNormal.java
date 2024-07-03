package com.proyecto_semestral.Logic;

public class AsientoNormal extends Asiento{
    private double precio;

    public AsientoNormal(int numAsiento, int piso, double precio) {
        super(numAsiento, piso);
        this.precio = precio * EnumBuses.BUSNORMAL.getModificador();

    }

    public double getPrecio() {
        return precio;
    }
    
}
