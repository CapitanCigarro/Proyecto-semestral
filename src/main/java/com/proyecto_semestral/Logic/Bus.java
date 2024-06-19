package com.proyecto_semestral.Logic;

import java.util.ArrayList;

public abstract class Bus {
    private String horaSalida, recorrido;
    private int numAsientos, numPisos;
    private ArrayList<Piso> pisos;
    
    public Bus(String horaSalida, String recorrido, int numAsientos, int numPisos) {
        this.horaSalida = horaSalida;
        this.recorrido = recorrido;
        this.numAsientos = numAsientos;
        this.numPisos = numPisos;
        crearPisos(numAsientos, numPisos);

    }

    public int getNumPisos() {
        return numPisos;
    }


    public String getHoraSalida() {
        return horaSalida;
    }



    public String getRecorrido() {
        return recorrido;
    }



    public int getNumAsientos() {
        return numAsientos;
    }


    /**
     * Crea un ArrayList con los pisos del bus
     * @param numAsientos Numero de asientos del bus
     * @param numPisos Numero de pisos del bus
     */

    public void crearPisos(int numAsientos, int numPisos) {
        if(numPisos == 1) {
            pisos.add(new Piso(numAsientos, 0));

        } else {
            pisos.add(new Piso(numAsientos / 2, 0));
            pisos.add(new Piso(numAsientos / 2, numAsientos / 2));

        }

    }

    public ArrayList<Piso> getPisos() {
        return this.pisos;

    }

    public Asiento getAsiento(int numAsiento) {
        --numAsiento;
        if(numPisos == 1) {
            return pisos.get(0).getAsiento(numAsiento);

        } else {
            if(numAsiento< this.numAsientos / 2) {
                return pisos.get(0).getAsiento(numAsiento);

            } else {
                return pisos.get(1).getAsiento(numAsiento - numAsientos / 2);

            }

        }

    } 
    
    
}
