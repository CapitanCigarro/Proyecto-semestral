package com.proyecto_semestral.Logic;

public class AsientoSemiSalonCama extends Asiento{
    private double precio;

    public AsientoSemiSalonCama(int numAsiento, int piso, double precio) {
        super(numAsiento, piso);
        this.precio = precio * ListaBuses.MICROBUS.getModificador();

    }

    public double getPrecio() {
        return precio;
    }
    
    
}
