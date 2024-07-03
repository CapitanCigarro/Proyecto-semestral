package com.proyecto_semestral.Logic;

public enum EnumTipoPasaje {
    Estudiante(0.5, "Estudiante"),
    AdultoMayor(0.6, "Adulto Mayor"),
    Normal(1, "Pasaje Normal");


    

    private final double modificador;
    private final String string;

    EnumTipoPasaje(double modificador, String string) {
        this.modificador = modificador;
        this.string = string;

    }

    public double getModificador(String s) throws TipoPasajeIncorrectoException {
        
        for (EnumTipoPasaje p : EnumTipoPasaje.values()) {
            if (p.toString() == s) {
                return p.getMod();

            }

        }

        throw new TipoPasajeIncorrectoException();

    }

    private double getMod() {
        return this.modificador;

    }

    @Override
    public String toString() {
        return string;
    }


}
