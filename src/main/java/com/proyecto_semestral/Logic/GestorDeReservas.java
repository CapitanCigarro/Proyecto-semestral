package com.proyecto_semestral.Logic;

import java.util.ArrayList;

public class GestorDeReservas {
    Bus busSeleccionado;
    ArrayList<Integer> aL;

    public GestorDeReservas() {}

    private void añadirSeleccion(int i) {
        this.aL.add(i);

    }

    public void limpiarSelecciones() {
        this.aL.clear();

    }

    private void quitarSeleccion(int i) {
        if (this.aL.contains(Integer.valueOf(i))) {
            this.aL.remove(Integer.valueOf(i));

        }

    }

    public void cambiarSeleccion(int i) throws NoBusSeleccionadoException {
        NoBusSeleccionadoException();
        if(aL.contains(Integer.valueOf(i))) {
            this.añadirSeleccion(i);

        } else {
            this.quitarSeleccion(i);

        }

    }

    private void NoBusSeleccionadoException() throws NoBusSeleccionadoException {
        if(busSeleccionado == null) {
            throw new NoBusSeleccionadoException();

        }

    }

    public String reservar() throws NoBusSeleccionadoException {
        NoBusSeleccionadoException();
        ArrayList<Integer> reservados = new ArrayList<Integer>(), noReservados = new ArrayList<Integer>();
        while (true) {
            if (this.aL.isEmpty()) {break;}
            Integer asientoSeleccionado = aL.remove(0);
            Asiento as = busSeleccionado.getAsiento(asientoSeleccionado);
            
            if (as.getReservado()) {
                reservados.add(asientoSeleccionado);
                as.reservar();

            } else {
                noReservados.add(asientoSeleccionado);

            }

        }

        String mensaje = "", pt1 = null, pt2 = null;

        if (reservados.isEmpty() == false) {
            pt1 = "Asientos reservados = {" + String.valueOf(reservados.remove(0));
            
            while (true) {
                if (reservados.size() > 1) {
                    pt1 += ", " + String.valueOf(reservados.remove(0));

                } else {break;}

            }

            if (reservados.size() == 1) {
                pt1 += ", " + String.valueOf(reservados.remove(0));

            }

            pt1 += "}";

        }

        if (noReservados.isEmpty() == false) {
            pt2 = "Asientos no reservados = {" + String.valueOf(noReservados.remove(0));
            
            while (true) {
                if (noReservados.size() > 1) {
                    pt2 += ", " + String.valueOf(noReservados.remove(0));

                } else {break;}

            }

            if (noReservados.size() == 1) {
                pt2 += ", " + String.valueOf(noReservados.remove(0));

            }

            pt2 += "}";

        }

        if (pt1 != null && pt2 != null) {
            mensaje = pt1 + ", " + pt2;

        } else {
            if (pt1 != null) {
                mensaje = pt1;

            } else {
                mensaje = pt2;

            }

        }

        return mensaje;

    }

    public void setBusSeleccionado(Bus b) {
        this.busSeleccionado = b;

    }

}
