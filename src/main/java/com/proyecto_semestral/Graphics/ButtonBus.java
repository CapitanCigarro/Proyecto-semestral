package com.proyecto_semestral.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.proyecto_semestral.Logic.Bus;
import com.proyecto_semestral.Logic.GestorDeReservas;
import com.proyecto_semestral.Logic.ListaBuses;

public class ButtonBus extends JButton {
    private PanelBus panelBus;
    private Bus bus;
    private PanelPrincipal panelPrincipal;

    public ButtonBus(Bus bus, GestorDeReservas g, PanelPrincipal panelPrincipal) {
        super();
        this.bus = bus;
        this.panelPrincipal = panelPrincipal;
        this.panelBus = new PanelBus(bus, g);
        this.setText(this.bus.getRecorrido());
        this.setSize(Sizes.BUTTONBUS.getXSize(), Sizes.BUTTONBUS.getYSize());

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accion();
                
            }
        };

        this.addActionListener(actionListener);

    }

    public PanelBus getPanelBus() {
        return panelBus;
    }

    public Bus getBus() {
        return bus;
    }

    public void accion() {
        this.panelPrincipal.cambiarMensaje("Hora = " + this.bus.getHoraSalida() + ", Recorrido = " + this.bus.getRecorrido() + ", Tipo = " + ListaBuses.values()[this.bus.getTipoBusIndex()].getNombre());
        this.panelPrincipal.estadoInicial();
        this.panelPrincipal.getFiltros().add(panelBus);
        
    }
    
}