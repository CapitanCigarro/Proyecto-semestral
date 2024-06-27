package com.proyecto_semestral.Graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import com.proyecto_semestral.Logic.*;

public class ButtonAsientoGui extends JButton {
    private GestorDeReservas g;
    private Asiento asiento;
    private int xSize = Sizes.ASIENTO.getXSize(), ySize = Sizes.ASIENTO.getYSize();

    public ButtonAsientoGui(Asiento asiento, GestorDeReservas g) {
        super();
        this.asiento = asiento;
        this.g = g;
        this.setText(String.valueOf(asiento.getNumAsiento()));
        this.setSize(this.xSize, this.ySize);
        this.setAction();
        this.actualizarColor();

    }

    public Asiento getAsiento() {
        return this.asiento;

    }

    private void setAction() {
        ActionListener aL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.cambiarSeleccion(asiento.getNumAsiento());
                if (getBackground() != Color.ORANGE) {          
                    setBackground(Color.ORANGE);

                    } else {
                        actualizarColor();
                    }

                

            }

        };

        this.addActionListener(aL);

    }

    public void actualizarColor() {
        if (asiento.getReservado()) {
            this.setBackground(Color.RED);

        } else {
            this.setBackground(Color.green);

        }


    }

}
