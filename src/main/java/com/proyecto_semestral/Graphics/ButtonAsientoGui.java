package com.proyecto_semestral.Graphics;

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
        this.setToolTipText((String.valueOf(this.asiento.getNumAsiento())));
        this.setSize(this.xSize, this.ySize);
        this.setAction();

    }

    public Asiento getAsiento() {
        return this.asiento;

    }

    private void setAction() {
        ActionListener aL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    g.cambiarSeleccion(asiento.getNumAsiento());  

                } catch (NoBusSeleccionadoException ex) {
                    LabelMensaje.MENSAJE.setText("Seleccionar un bus antes de intentar esta accion");

                }
                

            }
        };

        this.addActionListener(aL);

    }

}
