package com.proyecto_semestral.Graphics;

import javax.swing.JPanel;

import com.proyecto_semestral.Logic.GestorDeReservas;
import com.proyecto_semestral.Logic.Piso;

public class PisoGui extends JPanel{
    Piso piso;
    AsientosDerecha asientosDerecha;
    AsientosIzquierda asientosIzquierda;

    public PisoGui(Piso piso, GestorDeReservas g) {
        super();
        this.piso = piso;

        this.asientosDerecha = new AsientosDerecha(piso.getFilaDerecha(), g);
        this.asientosIzquierda = new AsientosIzquierda(piso.getFilaIzquierda(), g);

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
