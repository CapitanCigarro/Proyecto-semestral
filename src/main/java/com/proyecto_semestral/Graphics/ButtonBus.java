package com.proyecto_semestral.Graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.proyecto_semestral.Logic.Bus;
import com.proyecto_semestral.Logic.GestorDeReservas;
import com.proyecto_semestral.Logic.EnumBuses;

public class ButtonBus extends JButton {
    private PanelBus panelBus;
    private Bus bus;
    private PanelPrincipal panelPrincipal;

    public ButtonBus(Bus bus, GestorDeReservas g, PanelPrincipal panelPrincipal) {
        super();
        this.bus = bus;
        this.panelPrincipal = panelPrincipal;
        this.panelBus = new PanelBus(bus, g, this, panelPrincipal);
        this.setText(this.bus.getRecorrido());
        this.setSize(EnumSizes.BUTTONBUS.getXSize(), EnumSizes.BUTTONBUS.getYSize());
        this.setBackground(Color.DARK_GRAY);
        this.setForeground(Color.white);

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

    /**
     * Accion realizada al activar el boton
     */

    public void accion() {
        this.panelPrincipal.cambiarMensaje1("Hora = " + this.bus.getHoraSalida() + ", Recorrido = " + this.bus.getRecorrido() + ", Tipo = " + EnumBuses.values()[this.bus.getTipoBusIndex()].getNombre());
        this.panelPrincipal.estadoInicial();
        this.panelPrincipal.getFiltros().add(this.panelBus);
        this.panelPrincipal.cambiarMensaje1(this.bus.toString());
        this.panelPrincipal.getEmpresaBuses().getGestorDeReservas().setBusSeleccionado(this.bus);
        this.panelPrincipal.segundoEstado(this);
        
    }

    public PanelPrincipal getPanelPrincipal() {
        return panelPrincipal;
    }
    
}