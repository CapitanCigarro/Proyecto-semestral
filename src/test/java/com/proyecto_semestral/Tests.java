package com.proyecto_semestral;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.proyecto_semestral.Graphics.*;
import com.proyecto_semestral.Logic.*;

public class Tests {

    // Test para probar si funciona hacer que punteros sean null

    @Test
    public void testing() {
        assertTrue(new BusMicrobus(null, null) != new BusMicrobus(null, null));

    }

    @Test
    public void numeroAsientos() {
        Bus bus =  new  BusMicrobus(null, null);
        PanelBus panelBus  = new PanelBus(bus, null, null, null);
        int numAsientosBusLogico = bus.getNumAsientos()[0], numAsientosPanelBus = panelBus.getNumAsientos();

        assertEquals(numAsientosBusLogico, numAsientosPanelBus);

        bus =  new  BusNormal(null, null);
        panelBus  = new PanelBus(bus, null, null, null);
        numAsientosBusLogico = bus.getNumAsientos()[0];
        numAsientosPanelBus = panelBus.getNumAsientos();

        assertEquals(numAsientosBusLogico, numAsientosPanelBus);

        bus =  new  BusNormal(null, null);
        panelBus  = new PanelBus(bus, null, null, null);
        numAsientosBusLogico = bus.getNumAsientos()[0];
        numAsientosPanelBus = panelBus.getNumAsientos();

        assertEquals(numAsientosBusLogico, numAsientosPanelBus);

        bus =  new  BusSalonCamaYSemiCama(null, null);
        panelBus  = new PanelBus(bus, null, null, null);
        numAsientosBusLogico = bus.getNumAsientos()[0] + bus.getNumAsientos()[1];
        numAsientosPanelBus = panelBus.getNumAsientos();

        System.out.println(String.valueOf(numAsientosBusLogico) + " " + String.valueOf(numAsientosPanelBus));
        assertEquals(numAsientosBusLogico, numAsientosPanelBus);

    }

    @Test
    public void cantidadBuses() {
        EmpresaBuses empresaBuses = new EmpresaBuses();
        EmpresaBusesGui empresaBusesGui = new EmpresaBusesGui(empresaBuses.getTablaBuses(), null, null);

        assertEquals(45, empresaBuses.getTablaBuses().size());

        assertEquals(empresaBuses.getTablaBuses().size(), empresaBusesGui.getTablaBuses().size());

    }

    @Test
    public void tipoAsientos() {
        Bus bus = new BusMicrobus(null, null);
        assertTrue(AsientoMicrobus.class == bus.getAsiento(0).getClass());

        bus = new BusNormal(null, null);
        assertTrue(AsientoNormal.class == bus.getAsiento(0).getClass());

        bus = new BusSalonCamaYSemiCama(null, null);
        assertTrue(AsientoSalonCama.class == bus.getAsiento(0).getClass());
        assertTrue(AsientoSemiSalonCama.class  == bus.getAsiento(100).getClass());

    }

    @Test
    public void parametrosCorrectos() {
        Bus bus = new BusMicrobus(EnumHoras.HORA0600.getHora(), EnumRecorridos.IQUIQUE.getRecorrido());

        assertTrue(bus.getHoraSalida() == "06:00" && bus.getRecorrido() == "Iquique");

    }

    @Test
    public void seleccionCorrecta() {
        PanelPrincipal panelPrincipal = new PanelPrincipal();
        Bus bus = new BusNormal(EnumHoras.HORA0600.getHora(), EnumRecorridos.PUERTOMONTT.getRecorrido());
        ButtonBus buttonBus = new  ButtonBus(bus, new GestorDeReservas(), panelPrincipal);

        buttonBus.accion();

        assertEquals(bus, panelPrincipal.getBusElegido().getPanelBus().getBus());

    }

    @Test
    public void seleccionAsientos() {
        ArrayList<Integer> listaAsientos = new ArrayList<>();

        for (int i = 1; i <= EnumBuses.MICROBUS.getNumAsientos()[0]; i++) {
            if (i % 3 == 0) {
                listaAsientos.add(i);

            }

        }

        GestorDeReservas gestorDeReservas = new GestorDeReservas();
        PanelBus panelBus = new PanelBus(new BusMicrobus(null, null), gestorDeReservas, null, null);
        gestorDeReservas.setBusSeleccionado(panelBus.getBus());

        for (PanelPiso piso : panelBus.getPisos()) {
            for (ButtonAsiento asiento : piso.getAsientosDerecha().getFilaAsientos()) {
                if (listaAsientos.contains(asiento.getAsiento().getNumAsiento())) {
                    asiento.accion();

                }

            }

            for (ButtonAsiento asiento : piso.getAsientosIzquierda().getFilaAsientos()) {
                if (listaAsientos.contains(asiento.getAsiento().getNumAsiento())) {
                    asiento.accion();

                }

            }

        }

        for (Integer i : listaAsientos) {
            assertTrue(gestorDeReservas.getArrayList().contains(i));

        }

    }

}
