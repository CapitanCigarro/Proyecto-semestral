package com.proyecto_semestral.Logic;

public class Asiento {
    private boolean reservado = false;
    private int numAsiento;

    public Asiento(int numAsiento) {
        this.numAsiento = numAsiento;

    }

    public void reservar() {
        this.reservado = true;

    }

    public int getNumAsiento() {
        return this.numAsiento;
    }

    public boolean getReservado() {
        return this.reservado;

    }

}
