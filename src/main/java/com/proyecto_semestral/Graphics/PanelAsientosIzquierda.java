package com.proyecto_semestral.Graphics;

import java.awt.Color;


import com.proyecto_semestral.Logic.FilaAsientos;
import com.proyecto_semestral.Logic.GestorDeReservas;

public class PanelAsientosIzquierda extends PanelAsientos implements ActualizarColoresAsientos {
    private FilaAsientosGui filaAsientos;

    private int xSize = EnumSizes.FILAASIENTOS.getXSize();
    private int ySize = EnumSizes.FILAASIENTOS.getYSize();

    public PanelAsientosIzquierda(FilaAsientos fila, GestorDeReservas g, PanelPrincipal panelPrincipal) {
        super();
        this.setLayout(null);
        this.filaAsientos = new FilaAsientosGui(fila, g, panelPrincipal);

        this.setSize(this.xSize, this.ySize);

        for (int i = 0; i < filaAsientos.size() / 2; i++) {
            for(int j = 0; j <= 1; j++) {
                int xSize = EnumSizes.ASIENTO.getXSize(), ySize =  EnumSizes.ASIENTO.getYSize();
                ButtonAsiento asiento = filaAsientos.get((i * 2) + j);
                asiento.setBounds((xSize * j) + (20 * j) + 10, (ySize * i) + (10 * i) + 10, xSize, ySize);
                asiento.setSize(xSize, ySize);
                this.add(asiento);

            }
            
        }

    }

    public FilaAsientosGui getFilaAsientos() {
        return this.filaAsientos;

    }

    @Override
    public void actualizarColoresAsientos() {
        for(ButtonAsiento asiento : this.filaAsientos) {
            asiento.actualizarColor();

        }

    }

    public void setColor (Color color) {
        this.setBackground(color);

    }

}