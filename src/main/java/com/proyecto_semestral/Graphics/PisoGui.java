package com.proyecto_semestral.Graphics;

import javax.swing.JPanel;

import com.proyecto_semestral.Logic.GestorDeReservas;
import com.proyecto_semestral.Logic.Piso;

public class PisoGui extends JPanel{
    Piso piso;
    AsientosDerecha asientosDerecha;
    AsientosIzquierda asientosIzquierda;
    private int xSize = Sizes.PISO.getXSize();
    private int ySize = Sizes.PISO.getYSize();

    public PisoGui(Piso piso, GestorDeReservas g) {
        super();
        this.setSize(xSize, ySize);
        this.piso = piso;

        this.asientosDerecha = new AsientosDerecha(piso.getFilaDerecha(), g);
        this.asientosIzquierda = new AsientosIzquierda(piso.getFilaIzquierda(), g);

        this.add(asientosDerecha);
        this.add(asientosIzquierda);

    }

    public Piso getPiso() {
        return piso;
    }

    public AsientosDerecha getAsientosDerecha() {
        return asientosDerecha;
    }

    public AsientosIzquierda getAsientosIzquierda() {
        return asientosIzquierda;
    }
    
}
