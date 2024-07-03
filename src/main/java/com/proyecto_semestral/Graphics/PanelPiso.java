package com.proyecto_semestral.Graphics;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import com.proyecto_semestral.Logic.GestorDeReservas;
import com.proyecto_semestral.Logic.Piso;

public class PanelPiso extends JLayeredPane implements ActualizarColoresAsientos {
    private Piso piso;
    private PanelAsientosDerecha asientosDerecha;
    private PanelAsientosIzquierda asientosIzquierda;
    private int xSize = Sizes.PISO.getXSize();
    private int ySize = Sizes.PISO.getYSize();
    private JLabel numPiso;

    public PanelPiso(Piso piso, GestorDeReservas g) {
        super();
        this.setSize(xSize, ySize);
        this.piso = piso;

        this.numPiso = new JLabel();

        this.numPiso.setSize(100, 30);
        this.numPiso.setLocation(245, 650);
        this.numPiso.setText("Piso = " + String.valueOf(piso.getnumPiso()));
        this.numPiso.setBackground(Color.BLACK);
        this.numPiso.setForeground(Color.WHITE);

        this.asientosDerecha = new PanelAsientosDerecha(piso.getFilaDerecha(), g);
        this.setLayout(null);
        this.asientosIzquierda = new PanelAsientosIzquierda(piso.getFilaIzquierda(), g);
        this.asientosDerecha.setLocation(Sizes.PISO.getXSize() / 2, 0);    

        if (piso.getnumPiso() == 1) {
            this.setColor(Color.DARK_GRAY);

        } else {
            this.setColor(Color.LIGHT_GRAY);
            this.numPiso.setForeground(Color.BLACK);

        }

        this.add(asientosIzquierda, JLayeredPane.DEFAULT_LAYER);
        this.add(asientosDerecha, JLayeredPane.DEFAULT_LAYER);
        this.add(numPiso, JLayeredPane.DRAG_LAYER);

    }

    public Piso getPiso() {
        return piso;
    }

    public PanelAsientosDerecha getAsientosDerecha() {
        return asientosDerecha;
    }

    public PanelAsientosIzquierda getAsientosIzquierda() {
        return asientosIzquierda;
    }

    /**
     * Metodo para actualizar colores de asientos
     */

    public void actualizarColoresAsientos() {
        this.asientosDerecha.actualizarColoresAsientos();
        this.asientosIzquierda.actualizarColoresAsientos();

    }

    private void setColor(Color color) {
        this.asientosDerecha.setColor(color);
        this.asientosIzquierda.setColor(color);

    }
    
}
