package com.proyecto_semestral.Graphics;

import java.util.ArrayList;

import com.proyecto_semestral.Logic.Bus;
import com.proyecto_semestral.Logic.GestorDeReservas;

public class EmpresaBusesGui {
    private ArrayList<ArrayList<ButtonBus>> tablaHoraria, tablaRecorrido, tablaTipoBus;
    private GestorDeReservas gestorDeReservas;
    private PanelPrincipal panelPrincipal;

    public EmpresaBusesGui(ArrayList<ArrayList<Bus>> tablaHoraria, GestorDeReservas gestor, PanelPrincipal panelPrincipal) {
        this.gestorDeReservas = gestor;
        this.panelPrincipal = panelPrincipal;
        this.tablaHoraria = new ArrayList<ArrayList<ButtonBus>>();
        this.tablaRecorrido = new ArrayList<ArrayList<ButtonBus>>();
        this.tablaTipoBus = new ArrayList<ArrayList<ButtonBus>>();

        for (int i = 0; i < 15; i++) {
            this.tablaHoraria.add(new ArrayList<ButtonBus>());
            if(i < 5) {
                this.tablaRecorrido.add(new ArrayList<ButtonBus>());
                this.tablaTipoBus.add(new ArrayList<ButtonBus>());

            }

        }

        this.crearBuses(tablaHoraria);
        
    }

    private void crearBuses(ArrayList<ArrayList<Bus>> tablaHoraria) {
        for (int i = 0; i < tablaHoraria.size(); i++) {
            ArrayList<Bus> conjuntoBuses = tablaHoraria.get(i);
            for (int j = 0; j < conjuntoBuses.size(); j++) {
                Bus bus = conjuntoBuses.get(j);
                ButtonBus buttonBus = new ButtonBus(bus, this.gestorDeReservas, this.panelPrincipal);
                this.tablaHoraria.get(i).add(buttonBus);
                this.tablaRecorrido.get(bus.getRecorridoIndex()).add(buttonBus);
                this.tablaTipoBus.get(bus.getTipoBusIndex()).add(buttonBus);

            }

        }

    }

    public ArrayList<ArrayList<ButtonBus>> getTablaHoraria() {
        return tablaHoraria;
    }

    public ArrayList<ArrayList<ButtonBus>> getTablaRecorrido() {
        return tablaRecorrido;
    }

    public ArrayList<ArrayList<ButtonBus>> getTablaTipoBus() {
        return tablaTipoBus;
    }

    public GestorDeReservas getGestorDeReservas() {
        return gestorDeReservas;
    }

}
