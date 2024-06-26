package com.proyecto_semestral.Graphics;

import javax.swing.JPanel;

import com.proyecto_semestral.Logic.GestorDeReservas;
import com.proyecto_semestral.Logic.Piso;

public class PanelPiso extends JPanel{
    Piso piso;
    PanelAsientosDerecha asientosDerecha;
    PanelAsientosIzquierda asientosIzquierda;
    private int xSize = Sizes.PISO.getXSize();
    private int ySize = Sizes.PISO.getYSize();

    public PanelPiso(Piso piso, GestorDeReservas g) {
        super();
        this.setSize(xSize, ySize);
        this.piso = piso;

        this.asientosDerecha = new PanelAsientosDerecha(piso.getFilaDerecha(), g);
        this.asientosIzquierda = new PanelAsientosIzquierda(piso.getFilaIzquierda(), g);

        this.add(asientosDerecha);
        this.add(asientosIzquierda);

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
    
}
