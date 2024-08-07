package com.proyecto_semestral.Logic;

public class AsientoSalonCama extends Asiento{
    private double precio;

    public AsientoSalonCama(int numAsiento, int piso, double precio) {
        super(numAsiento, piso);
        this.precio = precio * EnumBuses.SalonCamaYSemiCama.getModificador2do();

    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Asiento Salon Cama";
    }
    
}
