package com.proyecto_semestral.Graphics;

import javax.swing.JPanel;

import com.proyecto_semestral.Logic.FilaAsientos;
import com.proyecto_semestral.Logic.GestorDeReservas;

public class PanelAsientosDerecha extends JPanel{
    private FilaAsientosGui filaAsientos;

    private int xSize = Sizes.FILAASIENTOS.getXSize();
    private int ySize = Sizes.FILAASIENTOS.getYSize();

    public PanelAsientosDerecha(FilaAsientos fila, GestorDeReservas g) {
        super();
        this.filaAsientos = new FilaAsientosGui(fila, g);

        this.setSize(xSize, ySize);

        for (ButtonAsientoGui asiento : filaAsientos) {
            this.add(asiento);

        }

    }

    public FilaAsientosGui getFilaAsientos() {
        return this.filaAsientos;

    }

}