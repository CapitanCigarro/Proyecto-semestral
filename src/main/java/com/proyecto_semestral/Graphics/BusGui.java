package com.proyecto_semestral.Graphics;

import java.util.ArrayList;

import com.proyecto_semestral.Logic.Bus;
import com.proyecto_semestral.Logic.GestorDeReservas;

public class BusGui {
    private Bus bus;
    private ArrayList<PisoGui> pisos;
    
    public BusGui(Bus b, GestorDeReservas g) {
        this.bus = b;
        this.pisos = new ArrayList<PisoGui>();

        for (int i = 0; i < bus.getNumPisos(); i++) {
            this.pisos.add(new PisoGui(this.bus.getPisos().get(i), g));

        }

    }
 
}