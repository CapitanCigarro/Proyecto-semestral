package com.proyecto_semestral.Logic;

public class Piso {
    private int numAsientos, numPrimerAsiento, numPiso;
    private FilaAsientos izquierda, derecha, general;

    public Piso(int numAsientos, int numPrimerAsiento, Bus bus) {
        this.numAsientos = numAsientos;
        this.numPrimerAsiento = numPrimerAsiento;
    
        if (numPrimerAsiento == 0) {
            this.numPiso = 1;

        } else {
            this.numPiso = 2;

        }

        this.crearFilasAsientos(bus);

    }

    public int getnumPiso() {
        return this.numPiso;

    }

    /**
     * Metodo privado que inicializa las filas de asientos en el piso
     */

    private void crearFilasAsientos(Bus bus) {
        this.izquierda = new FilaAsientos();
        this.derecha = new FilaAsientos();
        this.general = new FilaAsientos();
        FilaAsientos chosen = this.izquierda;

        for (int i = 1; i <= numAsientos; i++) {
            ++numPrimerAsiento;

            Asiento temp;

            double precio;
                    try {
                        precio = bus.getRecorridoElegido().getPrecio();
                    } catch (Exception e) {
                        precio = 1;    
                        // En caso de no tener recorrido, precio sera 1
                    }

            switch (bus.getTipoBus()) {
                case BUSNORMAL:
                    temp = new AsientoNormal(this.numPrimerAsiento, this.numPiso, precio);
                    break;

                case MICROBUS:
                    temp = new AsientoMicrobus(this.numPrimerAsiento, this.numPiso, precio);
                    break;

                case SalonCamaYSemiCama:
                    switch (this.numPiso) {
                        case 1:
                            temp = new AsientoSalonCama(this.numPrimerAsiento, this.numPiso, precio);
                            break;
                    
                        case 2: 
                            temp = new AsientoSemiSalonCama(this.numPrimerAsiento, this.numPiso, precio);
                            break;

                        default:
                            temp = null;
                            break;

                    }

                    break;

                default:
                    temp = null;
                    break;

            }

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
     * Retorna asiento con numero elegido, si i < 0 retorna primer asiento,
     * si i >= numero ultimo asiento, retorna ultimo asiento
     * @param i Numero de asiento
     * @return Asiento i + 1
     */

    public Asiento getAsiento(int i) {
        if (i < 0) {
            return general.get(0);

        }

        if (i >= general.size()) {
            return general.get(general.size() - 1);

        }

        return general.get(i);

    }

}
