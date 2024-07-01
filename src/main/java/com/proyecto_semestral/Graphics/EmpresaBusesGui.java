package com.proyecto_semestral.Graphics;

import java.util.ArrayList;

import com.proyecto_semestral.Logic.Bus;
import com.proyecto_semestral.Logic.GestorDeReservas;

public class EmpresaBusesGui {
    private ArrayList<ButtonBus> tablaBuses;
    private GestorDeReservas gestorDeReservas;
    private PanelPrincipal panelPrincipal;

    public EmpresaBusesGui(ArrayList<Bus> tablaBuses, GestorDeReservas gestor, PanelPrincipal panelPrincipal) {
        this.gestorDeReservas = gestor;
        this.panelPrincipal = panelPrincipal;
        this.tablaBuses = new ArrayList<ButtonBus>();

        this.crearBuses(tablaBuses);
        
    }

    /**
     * Metodo privado que crea objetos ButtonBus por cada objeto Bus que existe en el programa
     * @param tablaBuses tabla de buses existentes en el programa
     */

    private void crearBuses(ArrayList<Bus> tablaBuses) {
        for (Bus bus : tablaBuses) {
            ButtonBus buttonBus = new ButtonBus(bus, this.gestorDeReservas, this.panelPrincipal);
            this.tablaBuses.add(buttonBus);

        }

    }

    public ArrayList<ButtonBus> getTablaBuses() {
        return tablaBuses;
    }

    public GestorDeReservas getGestorDeReservas() {
        return gestorDeReservas;
    }

}
