package com.proyecto_semestral.Logic;

public class Bus { // TODO change class to floor
    private int numAsientos;
    private String horaSalida, recorrido;
    private FilaAsientos izquierda, derecha;

    public Bus(int numAsientos, String horaSalida, String recorrido) {
        this.horaSalida = horaSalida;
        this.recorrido = recorrido;
        this.numAsientos = numAsientos;
        this.crearFilasAsientos();
    }

    private void crearFilasAsientos() {
        this.izquierda = new FilaAsientos();
        this.derecha = new FilaAsientos();
        FilaAsientos chosen = this.izquierda;

        for (int i = 1; i <= numAsientos; i++) {
            chosen.add(new Asiento(i));
            if(i % 2 == 0) {
                if(chosen == this.izquierda) {
                    chosen = this.derecha;

                } else {
                    chosen = this.izquierda;

                }

            }                


        }

    }

    public String getHoraSalida() {
        return horaSalida;
    }
    
    public int getNumAsientos() {
        return numAsientos;
    }

    public String getRecorrido() {
        return recorrido;
    }

}
