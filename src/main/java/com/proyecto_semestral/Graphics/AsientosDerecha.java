package com.proyecto_semestral.Graphics;

import javax.swing.JPanel;

import com.proyecto_semestral.Logic.FilaAsientos;
import com.proyecto_semestral.Logic.GestorDeReservas;

public class AsientosDerecha extends JPanel{
    private FilaAsientosGui filaAsientos;

    public AsientosDerecha(FilaAsientos fila, GestorDeReservas g) {
        super();
        this.filaAsientos = new FilaAsientosGui(fila, g);

        for (AsientoGui asiento : filaAsientos) {
            this.add(asiento);

        }

    }

    public FilaAsientosGui getFilaAsientos() {
        return this.filaAsientos;

    }

}