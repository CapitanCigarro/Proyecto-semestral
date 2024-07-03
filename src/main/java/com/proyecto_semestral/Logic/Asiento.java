package com.proyecto_semestral.Logic;

public abstract class Asiento {
    private boolean reservado = false;
    private int numAsiento, piso;

    /** 
     * Objeto tipo asiento
     * @param numAsiento Numero del asiento
     * @param piso Piso al cual corresponde este asientop
     */

    public Asiento(int numAsiento, int piso) {
        this.numAsiento = numAsiento;
        this.piso = piso;

    }

    /** 
     * Metodo para reservar, cambia estado de reseva a true
     */

    public void reservar() {
        this.reservado = true;

    }

    /** 
     * Metodo para quitar reserva, cambia estado de reserva a false
     */

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

    public abstract double getPrecio();

}
