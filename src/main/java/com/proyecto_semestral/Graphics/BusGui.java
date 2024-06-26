package com.proyecto_semestral.Graphics;

import java.util.ArrayList;

import javax.swing.JPanel;

import com.proyecto_semestral.Logic.Bus;
import com.proyecto_semestral.Logic.GestorDeReservas;

public class BusGui extends JPanel {
    private int xSize = Sizes.BUS.getXSize();
    private int ySize = Sizes.BUS.getYSize();

    private Bus bus;
    private ArrayList<PisoGui> pisos;
    
    public BusGui(Bus b, GestorDeReservas g) {
        super();
        this.setSize(xSize, ySize);
        this.bus = b;
        this.pisos = new ArrayList<PisoGui>();

        for (int i = 0; i < bus.getNumPisos(); i++) {
            PisoGui piso = new PisoGui(this.bus.getPisos().get(i), g);
            this.add(piso);
            this.pisos.add(piso);

        }

    }

    public Bus getBus() {
        return bus;
    }

    public ArrayList<PisoGui> getPisos() {
        return pisos;
    }

}