package com.proyecto_semestral;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.JLayeredPane;

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

    

}
