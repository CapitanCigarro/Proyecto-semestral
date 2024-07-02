package com.proyecto_semestral.Graphics;

import java.awt.Color;

import javax.swing.JPanel;

import com.proyecto_semestral.Logic.GestorDeReservas;
import com.proyecto_semestral.Logic.Piso;

public class PanelPiso extends JPanel implements ActualizarColoresAsientos {
    private Piso piso;
    private PanelAsientosDerecha asientosDerecha;
    private PanelAsientosIzquierda asientosIzquierda;
    private int xSize = Sizes.PISO.getXSize();
    private int ySize = Sizes.PISO.getYSize();

    public PanelPiso(Piso piso, GestorDeReservas g) {
        super();
        this.setSize(xSize, ySize);
        this.piso = piso;

        this.asientosDerecha = new PanelAsientosDerecha(piso.getFilaDerecha(), g);
        this.setLayout(null);
        this.asientosIzquierda = new PanelAsientosIzquierda(piso.getFilaIzquierda(), g);
        this.asientosDerecha.setLocation(Sizes.PISO.getXSize() / 2, 0);

        this.add(asientosIzquierda);
        this.add(asientosDerecha);

        System.out.println(asientosDerecha.getFilaAsientos().size() + ", " + asientosIzquierda.getFilaAsientos().size());

        if (piso.getnumPiso() == 1) {
            this.setColor(Color.DARK_GRAY);

        } else {
            this.setColor(Color.LIGHT_GRAY);

        }

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
