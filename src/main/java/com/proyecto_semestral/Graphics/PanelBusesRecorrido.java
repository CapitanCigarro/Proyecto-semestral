package com.proyecto_semestral.Graphics;

import java.util.ArrayList;

import javax.swing.JPanel;

import com.proyecto_semestral.Logic.Bus;

public class PanelBusesRecorrido extends JPanel {
    private ArrayList<ArrayList<Bus>> tablaRecorridos;
    public PanelBusesRecorrido(ArrayList<ArrayList<Bus>> tablaRecorridos) {
        super();
        this.tablaRecorridos = tablaRecorridos;

    }

    public ArrayList<ArrayList<Bus>> getTablaRecorridos() {
        return tablaRecorridos;
    }

}