package com.proyecto_semestral.Graphics;

import java.awt.Color;

import javax.swing.JPanel;

import com.proyecto_semestral.Logic.GestorDeReservas;
import com.proyecto_semestral.Logic.Piso;

public class PanelPiso extends JPanel implements ActualizarColoresAsientos {
    Piso piso;
    PanelAsientosDerecha asientosDerecha;
    PanelAsientosIzquierda asientosIzquierda;
    private int xSize = Sizes.PISO.getXSize();
    private int ySize = Sizes.PISO.getYSize();

    public PanelPiso(Piso piso, GestorDeReservas g) {
        super();
        this.setSize(xSize, ySize);
        this.piso = piso;
        this.setBackground(Color.ORANGE);

        this.asientosDerecha = new PanelAsientosDerecha(piso.getFilaDerecha(), g);
        this.setLayout(null);
        this.asientosIzquierda = new PanelAsientosIzquierda(piso.getFilaIzquierda(), g);
        this.asientosDerecha.setLocation(Sizes.PISO.getXSize() / 2, 0);

        this.add(asientosIzquierda);
        this.add(asientosDerecha);

        System.out.println(asientosDerecha.getFilaAsientos().size() + ", " + asientosIzquierda.getFilaAsientos().size());

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
    
}
