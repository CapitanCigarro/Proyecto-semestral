package com.proyecto_semestral.Graphics;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.proyecto_semestral.Logic.Bus;
import com.proyecto_semestral.Logic.GestorDeReservas;

public class PanelBus extends JPanel implements ActualizarColoresAsientos {
    private int xSize = EnumSizes.BUS.getXSize();
    private int ySize = EnumSizes.BUS.getYSize();

    private Bus bus;
    private ArrayList<PanelPiso> pisos;
    private ButtonBus buttonBus;

    public PanelBus(Bus b, GestorDeReservas g, ButtonBus buttonBus, PanelPrincipal panelPrincipal) {
        super();
        this.setBackground(Color.BLACK);
        this.setSize(xSize, ySize);
        this.bus = b;
        this.buttonBus = buttonBus;
        this.pisos = new ArrayList<PanelPiso>();
        this.setLayout(null);
        System.out.println("Recorrido = " + b.getRecorrido() + ", Hora = " + b.getHoraSalida());

        for (int i = 0; i < bus.getNumPisos(); i++) {
            System.out.println("Piso = " + i);
            PanelPiso piso = new PanelPiso(this.bus.getPisos().get(i), g, panelPrincipal);
            if(bus.getNumPisos() == 2) {
                piso.setLocation(i * EnumSizes.PISO.getXSize(), 0);
                if (i == 1) {
                    piso.setBackground(Color.BLUE);

                }

            } else{
                piso.setLocation(EnumSizes.PISO.getXSize() / 2, 0);

            }
            this.add(piso);
            this.pisos.add(piso);

        }

    }

    public Bus getBus() {
        return bus;
    }

    public ArrayList<PanelPiso> getPisos() {
        return pisos;
    }

    /**
     * Metodo para actualizar colores de asientos
     */

    public void actualizarColoresAsientos() {
        for (PanelPiso piso : pisos) {
            piso.actualizarColoresAsientos();

        }

    }

    public ButtonBus getButtonBus() {
        return buttonBus;
    }

}