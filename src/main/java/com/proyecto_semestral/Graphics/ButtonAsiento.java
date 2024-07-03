package com.proyecto_semestral.Graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import com.proyecto_semestral.Logic.*;

public class ButtonAsiento extends JButton {
    private GestorDeReservas g;
    private Asiento asiento;
    private int xSize = Sizes.ASIENTO.getXSize(), ySize = Sizes.ASIENTO.getYSize();
    private PanelPrincipal panelPrincipal;

    public ButtonAsiento(Asiento asiento, GestorDeReservas g) {
        super();
        this.asiento = asiento;
        this.g = g;
        if (asiento == null) {
            System.out.println("a");

        }
        this.setText(String.valueOf(asiento.getNumAsiento()));
        this.setSize(this.xSize, this.ySize);
        this.setAction();
        this.actualizarColor();
        this.panelPrincipal = ((PanelBus)(((PanelPiso)(((PanelAsientos)this.getParent()).getParent()).getParent())).getParent()).getButtonBus().getPanelPrincipal();

    }

    public Asiento getAsiento() {
        return this.asiento;

    }

    /**
     * Metodo privado que inicializa accion del boton, la cual pone el boton en naranja al ser seleccionado
     */

    private void setAction() {
        ActionListener aL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.cambiarSeleccion(asiento.getNumAsiento());
                panelPrincipal.cambiarMensaje2();
                if (getBackground() != Color.ORANGE) {          
                    setBackground(Color.ORANGE);

                    } else {
                        actualizarColor();
                    }

                

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
