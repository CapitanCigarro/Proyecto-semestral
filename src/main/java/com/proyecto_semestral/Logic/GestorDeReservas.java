package com.proyecto_semestral.Logic;

import java.util.ArrayList;

public class GestorDeReservas {
    private Bus busSeleccionado;
    private ArrayList<Integer> aL;
    private double costoTotal;
    private double modificador;

    /**
     * Clase que tiene la funcion de gestionar las reservas
     */

    public GestorDeReservas() {
        this.aL = new ArrayList<Integer>();
        this.costoTotal = 0;

    }

    /**
     * Metodo privado para añadir asiento de numero i a la seleccion 
     * @param i asiento a añadir a selecciones
     */

    private void añadirSeleccion(int i) {
        this.aL.add(i);

    } 

    /**
     * Metodo que quita todas las selecciones
     */

    public void limpiarSelecciones() {
        this.aL.clear();

    }

    /**
     * Metodo privado para quitar de seleccion asiento numero i
     * @param i numero de asiento a quitar de la seleccion
     */
    
    private void quitarSeleccion(int i) {
        if (this.aL.contains(Integer.valueOf(i))) {
            this.aL.remove(Integer.valueOf(i));

        }

    }

    /**
     * Metodo publico que cambia la seleccion, si numero elegido no existe lo añade a seleccion, si existe lo elimina de esta
     * @param i numero de asiento a añadir / quitar en la lista de selecciones
     */

    public void cambiarSeleccion(int i){
        if(aL.contains(Integer.valueOf(i))) {
            this.costoTotal -= busSeleccionado.getAsiento(i).getPrecio();
            this.quitarSeleccion(i);

        } else {
            this.costoTotal += busSeleccionado.getAsiento(i).getPrecio();
            this.añadirSeleccion(i);

        }

    }

    /**
     * Metodo para intentar reservar selecciones
     * @return String mensaje de cuantos asientos se pudieron reservar y cuantos no
     */

    public String reservar() {

        if (this.aL.isEmpty()) {
            return "Seleccionar asientos antes de intentar accion";

        }

        this.costoTotal = 0;

        ArrayList<Integer> reservados = new ArrayList<Integer>(), noReservados = new ArrayList<Integer>();
        while (true) {
            if (this.aL.isEmpty()) {break;}
            Integer asientoSeleccionado = aL.remove(0);
            Asiento as = busSeleccionado.getAsiento(asientoSeleccionado);
            
            if (as.getReservado() == false) {
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
            pt2 = "Asientos ocupados por otra reserva = {" + String.valueOf(noReservados.remove(0));
            
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

    /**
     * Metodo para quitar reservas de las selecciones
     * @return String mensaje de cuantos asientos se les quito la reserva y cuantos no tenian
     */

    public String quitarReservas() {   

        if (this.aL.isEmpty()) {
            return "Seleccionar asientos antes de intentar accion";

        }

        String mensaje, pt1 = null, pt2 = null;

        ArrayList<Integer> reservaQuitada = new ArrayList<Integer>(), sinReservaInicial = new ArrayList<Integer>();

        while (true) {
            if (aL.isEmpty()) {break;}

            Integer asientoSeleccionado = aL.remove(0);
            Asiento asiento = this.busSeleccionado.getAsiento(asientoSeleccionado);
            
            if (asiento.getReservado()) {
                asiento.quitarReserva();
                reservaQuitada.add(asientoSeleccionado);

            } else {
                sinReservaInicial.add(asientoSeleccionado);

            }

        }

        if (reservaQuitada.isEmpty() == false) {
            pt1 = "Reservas quitadas = {" + String.valueOf(reservaQuitada.remove(0));

            while (reservaQuitada.size() > 1) {
                pt1 += ", " + String.valueOf(reservaQuitada.remove(0));

            }

            if (reservaQuitada.size() == 1) {
                pt1 += ", " + String.valueOf(reservaQuitada.remove(0));

            }

            pt1 += "}";

        }

        if (sinReservaInicial.isEmpty() == false) {
            pt2 = "No tenian reserva = {" + String.valueOf(sinReservaInicial.remove(0));

            while (sinReservaInicial.size() > 1) {
                pt2 += ", " + String.valueOf(sinReservaInicial.remove(0));

            }

            if (sinReservaInicial.size() == 1) {
                pt2 += String.valueOf(sinReservaInicial.remove(0));

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

    public double getCostoTotal() {
        return costoTotal * this.modificador;
    }

    @Override
    public String toString() {
        String mensaje = "{";
        for(int i = 0; i < this.aL.size(); i++) {
            if (i == 0) {
                mensaje += String.valueOf(aL.get(i));

            } else {
                mensaje += ", " + String.valueOf(aL.get(i));

            }

        }

        mensaje += "}";

        return mensaje;       

    }

    public Bus getBusSeleccionado() {
        return busSeleccionado;
    }

    public void setModificador(String s) {
        double modificador;
        try {
            modificador = EnumTipoPasaje.Normal.getModificador(s);
        } catch (TipoPasajeIncorrectoException e) {
            // Por  como esta escrito el codigo la excepcion no puede ser lanzada.
            // Para que no tire error al compilar:
            modificador = 1;
        }
        this.modificador = modificador;
    }

    public double getModificador() {
        return modificador;
    }

}
