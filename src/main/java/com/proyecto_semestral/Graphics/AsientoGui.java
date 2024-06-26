package com.proyecto_semestral.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import com.proyecto_semestral.Logic.*;

public class AsientoGui extends JButton {
    private GestorDeReservas g;
    private Asiento asiento;
    private int xSize = 10, ySize = 10;

    public AsientoGui(Asiento asiento, GestorDeReservas g) {
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
                    Mensaje.MENSAJE.setText("Seleccionar un bus antes de intentar esta accion");

                }
                

            }
        };

        this.addActionListener(aL);

    }

}
