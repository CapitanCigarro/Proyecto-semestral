package com.proyecto_semestral.Graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import com.proyecto_semestral.Logic.*;

public class ButtonAsiento extends JButton {
    private GestorDeReservas g;
    private Asiento asiento;
    private int xSize = EnumSizes.ASIENTO.getXSize(), ySize = EnumSizes.ASIENTO.getYSize();
    private PanelPrincipal panelPrincipal;

    public ButtonAsiento(Asiento asiento, GestorDeReservas g, PanelPrincipal panelPrincipal) {
        super();
        this.asiento = asiento;
        this.g = g;
        this.setText(String.valueOf(asiento.getNumAsiento()));
        this.setSize(this.xSize, this.ySize);
        this.setAction();
        this.actualizarColor();
        this.panelPrincipal = panelPrincipal;

    }

    public Asiento getAsiento() {
        return this.asiento;

    }

    public void accion() {
        g.cambiarSeleccion(asiento.getNumAsiento());
        if (this.panelPrincipal != null) {
            panelPrincipal.cambiarMensaje2();

        }
        if (getBackground() != Color.ORANGE) {          
            setBackground(Color.ORANGE);

        } else {
            actualizarColor();
            
        }

    }

    /**
     * Metodo privado que inicializa accion del boton, la cual pone el boton en naranja al ser seleccionado
     */

    private void setAction() {
        ActionListener aL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               accion();

            }

        };

        this.addActionListener(aL);

    }

    /**
     * Metodo que cambia el color del boton, Rojo si esta reservado, Verde si no
     */

    public void actualizarColor() {
        if (asiento.getReservado()) {
            this.setBackground(Color.RED);

        } else {
            this.setBackground(Color.green);

        }


    }

}
