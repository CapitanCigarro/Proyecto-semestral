package com.proyecto_semestral.Graphics;

import java.util.ArrayList;

import javax.swing.JPanel;

import com.proyecto_semestral.Logic.ListaHoras;


public class PanelBusesHora extends JPanel {
    private ArrayList<ArrayList<ButtonBus>> lista;
    public PanelBusesHora(ArrayList<ArrayList<ButtonBus>> lista) {
        super();
        this.lista = lista;
        this.setSize(Sizes.PanelesBuses.getXSize(), Sizes.PanelesBuses.getYSize());
        this.setVisible(false);

    }

    public void mostrarSelecciones(ListaHoras hora) {
        for (ButtonBus bus : lista.get(hora.getIndex())) {
            this.add(bus);

        }

    }

    public ArrayList<ArrayList<ButtonBus>> getLista() {
        return lista;
    }

}
