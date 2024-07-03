package com.proyecto_semestral.Logic;

public enum Precios {
    Estudiante(0.5),
    AdultoMayor(0.6),
    Normal(1);


    

    private final double modificador;

    Precios(double modificador) {
        this.modificador = modificador;

    }

    public double getModificador() {
        return modificador;
    }

}
