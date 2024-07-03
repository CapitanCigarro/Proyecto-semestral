package com.proyecto_semestral.Logic;

public class AsientoMicrobus extends Asiento {
    private double precio;

    public AsientoMicrobus(int numAsiento, int piso, double precio) {
        super(numAsiento, piso);
        this.precio = precio * ListaBuses.MICROBUS.getModificador();

    }

    public double getPrecio() {
        return precio;
    }
    
}
