package com.proyecto_semestral.Logic;

import java.util.ArrayList;

public abstract class Bus {
    private String horaSalida, recorrido;
    private int numAsientos, numPisos;
    private ArrayList<Piso> pisos;
    private ListaRecorridos recorridoElegido;
    
    public Bus(String horaSalida, String recorrido, int numAsientos, int numPisos) {
        this.horaSalida = horaSalida;
        this.recorrido = recorrido;
        this.numAsientos = numAsientos;
        this.numPisos = numPisos;
        this.setRecorridoElegido(recorrido);
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

    private void crearPisos(int numAsientos, int numPisos) {
        this.pisos =  new ArrayList<>();
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
    

    private void setRecorridoElegido(String s) {
        switch (s) {
            case "Santiago" :
                this.recorridoElegido = ListaRecorridos.SANTIAGO;
                break;

            case "Lota" :
                this.recorridoElegido = ListaRecorridos.LOTA;
                break;

            case "Valparaiso" :
                this.recorridoElegido = ListaRecorridos.VALPARAISO;
                break;

            case "Viña del mar" :
                this.recorridoElegido = ListaRecorridos.VIÑADELMAR;
                break;

            case "Coronel" :
                this.recorridoElegido = ListaRecorridos.CORONEL;
                break;

            default:
                break;
        }

    }

    public int getRecorridoIndex() {
        return this.recorridoElegido.getIndex();

    }

    public ListaRecorridos getRecorridoElegido() {
        return this.recorridoElegido;

    }

    public abstract int getTipoBusIndex();

    @Override
    public String toString() {
        return "Bus : Tipo = " + ListaBuses.values()[(this.getTipoBusIndex())].getNombre() + ", Hora salida = "
         + this.horaSalida + ", Pisos = " + String.valueOf(numPisos) + ", Asientos = " + String.valueOf(this.numAsientos) + 
         ", Recorrido = " + this.recorrido;
    }
    
}
