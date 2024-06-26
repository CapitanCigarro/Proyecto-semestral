package com.proyecto_semestral.Graphics;

import java.util.ArrayList;

import javax.swing.JPanel;

import com.proyecto_semestral.Logic.Bus;

public class PanelBusesTipo extends JPanel {
    private ArrayList<ArrayList<Bus>> tablaTipoBus;
    public PanelBusesTipo(ArrayList<ArrayList<Bus>> tablaTipoBus) {
        super();
        this.tablaTipoBus = tablaTipoBus;

    }

    public ArrayList<ArrayList<Bus>> getTablaTipoBus() {
        return tablaTipoBus;
    }

}
