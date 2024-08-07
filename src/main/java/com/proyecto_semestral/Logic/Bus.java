package com.proyecto_semestral.Logic;

import java.util.ArrayList;

public abstract class Bus {
    private String horaSalida, recorrido;
    private int[] numAsientos; 
    private int numPisos;
    private ArrayList<Piso> pisos;
    private EnumRecorridos recorridoElegido;

    /**
     * Objeto tipo Bus
     * @param horaSalida String hora a la que saldra el bus
     * @param recorrido String recorrido que tomara el bus
     * @param numAsientos int numero de asientos en el bus
     * @param numPisos int numero de pisos en el bus
     */
    
    public Bus(String horaSalida, String recorrido, int[] numAsientos, int numPisos) {
        this.horaSalida = horaSalida;
        this.recorrido = recorrido;
        this.numAsientos = numAsientos;
        this.numPisos = numPisos;
        try {
            this.setRecorridoElegido(recorrido);
        } catch (RecorridoElegidoNullException e) {
            this.recorrido = null;


        }
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



    public int[] getNumAsientos() {
        return numAsientos;
    }


    /**
     * Crea un ArrayList con los pisos del bus
     * @param numAsientos Numero de asientos del bus
     * @param numPisos Numero de pisos del bus
     */

    private void crearPisos(int[] numAsientos, int numPisos) {
        this.pisos =  new ArrayList<>();
        if(numPisos == 1) {
            pisos.add(new Piso(numAsientos[0], 0, this));

        } else {
            pisos.add(new Piso(numAsientos[0], 0, this));
            pisos.add(new Piso(numAsientos[1], numAsientos[0], this));

        }

    }

    public ArrayList<Piso> getPisos() {
        return this.pisos;

    }

    /**
     * Retorna objeto tipo asiento con el numero correspondiente
     * @param numAsiento numero del asiento deseado
     * @return asiento del numero que se entrego al metodo
     */

    /**
     * Metodo para obtener asiento numero i, en caso de que parametro sea < 1 retorna primer asiento, si es mayor que la cantidad
     * de asientos retorna el ultimo asiento
     * @param numAsiento int numero de asiento deseado
     * @return Asiento numero i, o null si i no esta dentro de limites
     */

    public Asiento getAsiento (int numAsiento) {
        --numAsiento;
        if(numPisos == 1) {
            return pisos.get(0).getAsiento(numAsiento);

        } else {
            if(numAsiento < this.numAsientos[0]) {
                return pisos.get(0).getAsiento(numAsiento);

            } else {
                return pisos.get(1).getAsiento(numAsiento - numAsientos[0]);

            }

        }

    } 
    
    /**
     * Metodo para inicializar variable privada recorrido elegido como una de tipo ListaRecorridos
     * @param s Recorrido elegido en string
     */

    private void setRecorridoElegido(String s) throws RecorridoElegidoNullException {
        if (s == null) {
            throw new RecorridoElegidoNullException();

        }

        switch (s) {
            case "Santiago" :
                this.recorridoElegido = EnumRecorridos.SANTIAGO;
                break;

            case "Iquique" :
                this.recorridoElegido = EnumRecorridos.IQUIQUE;
                break;

            case "Valparaiso" :
                this.recorridoElegido = EnumRecorridos.VALPARAISO;
                break;

            case "Viña del mar" :
                this.recorridoElegido = EnumRecorridos.VIÑADELMAR;
                break;

            case "Puerto Montt" :
                this.recorridoElegido = EnumRecorridos.PUERTOMONTT;
                break;

            default:
                this.recorridoElegido = null;
                break;
        }

    }

    /**
     * Metodo que retorna el indice correspondiente en ListaRecorridos del recorrido elegido
     * @return int Indice correspondiente
     */

    public int getRecorridoIndex() {
        return this.recorridoElegido.getIndex();

    }

    public EnumRecorridos getRecorridoElegido() {
        return this.recorridoElegido;

    }

    public EnumBuses getTipoBus() {
        return EnumBuses.values()[this.getTipoBusIndex()];

    }

    /**
     * Metodo abstracto que retorna indice del tipo de bus, indice corresponde a enum ListaBuses
     * @return int indice del tipo de bus en enum ListaBuses
     */

    public abstract int getTipoBusIndex();

    @Override
    public String toString() {
        return "Bus : Tipo = " + EnumBuses.values()[(this.getTipoBusIndex())].getNombre() + ", Hora salida = "
         + this.horaSalida + ", Pisos = " + String.valueOf(numPisos) + ", Asientos = " + String.valueOf(this.numAsientos[0] + this.numAsientos[1]) + 
         ", Recorrido = " + this.recorrido;
    }

    public EnumHoras getHora() {
        for (EnumHoras hora : EnumHoras.values()) {
            if (hora.getHora() == this.horaSalida) {
                return hora;

            }

        }

        return null;

    }
    
}
