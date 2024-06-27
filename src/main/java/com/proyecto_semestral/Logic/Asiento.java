package com.proyecto_semestral.Logic;

public class Asiento {
    private boolean reservado = false;
    private int numAsiento, piso;

    public Asiento(int numAsiento, int piso) {
        this.numAsiento = numAsiento;
        this.piso = piso;

    }

    
    public void reservar() {
        this.reservado = true;
        System.out.println("Reservado " + String.valueOf(this.numAsiento));

    }

    public void quitarReserva() {
        this.reservado = false;

    }

    public int getNumAsiento() {
        return this.numAsiento;
    }

    public boolean getReservado() {
        return this.reservado;

    }

    public int getPiso() {
        return this.piso;
    }

}
