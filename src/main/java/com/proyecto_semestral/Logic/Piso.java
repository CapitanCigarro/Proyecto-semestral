package com.proyecto_semestral.Logic;

public class Piso {
    private int numAsientos, numPrimerAsiento, numPiso;
    private FilaAsientos izquierda, derecha, general;

    public Piso(int numAsientos, int numPrimerAsiento) {
        this.numAsientos = numAsientos;
        this.numPrimerAsiento = numPrimerAsiento;
        this.crearFilasAsientos();

        if (numPrimerAsiento == 0) {
            numPiso = 1;

        } else {
            numPiso = 2;

        }

    }

    public int getnumPiso() {
        return this.numPiso;

    }

    /**
     * Metodo privado que inicializa las filas de asientos en el piso
     */

    private void crearFilasAsientos() {
        this.izquierda = new FilaAsientos();
        this.derecha = new FilaAsientos();
        this.general = new FilaAsientos();
        FilaAsientos chosen = this.izquierda;

        for (int i = 1; i <= numAsientos; i++) {
            ++numPrimerAsiento;
            Asiento temp = new Asiento(this.numPrimerAsiento, this.numPiso);
            general.add(temp);
            chosen.add(temp);
            if(i % 2 == 0) {
                if(chosen == this.izquierda) {
                    chosen = this.derecha;

                } else {
                    chosen = this.izquierda;

                }

            }                


        }

    }

    public FilaAsientos getFilaIzquierda() {
        return izquierda;

    }

    public FilaAsientos getFilaDerecha() {
        return derecha;

    }

    public int getNumAsientos() {
        return numAsientos;

    }


    /**
     * Retorna asiento con numero elegido
     * @param i Numero de asiento
     * @return Asiento i + 1
     */
    
    public Asiento getAsiento(int i) {
        return general.get(i);

    }

}
