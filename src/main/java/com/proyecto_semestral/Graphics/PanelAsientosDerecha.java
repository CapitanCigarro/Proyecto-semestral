package com.proyecto_semestral.Graphics;

import java.awt.Color;

import com.proyecto_semestral.Logic.FilaAsientos;
import com.proyecto_semestral.Logic.GestorDeReservas;

public class PanelAsientosDerecha extends PanelAsientos implements ActualizarColoresAsientos {
    private FilaAsientosGui filaAsientos;

    private int xSize = Sizes.FILAASIENTOS.getXSize();
    private int ySize = Sizes.FILAASIENTOS.getYSize();

    public PanelAsientosDerecha(FilaAsientos fila, GestorDeReservas g) {
        super();
        this.setLayout(null);
        this.filaAsientos = new FilaAsientosGui(fila, g);

        this.setSize(this.xSize, this.ySize);

        for (int i = 0; i < filaAsientos.size() / 2; i++) {
            for(int j = 0; j <= 1; j++) {
                int xSize = Sizes.ASIENTO.getXSize(), ySize =  Sizes.ASIENTO.getYSize();
                ButtonAsiento asiento = filaAsientos.get((i * 2) + j);
                asiento.setBounds((xSize * j) + (20 * j) + 65, (ySize * i) + (10 * i) + 10 ,xSize, ySize);
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

    public void setColor(Color color) {
        this.setBackground(color);

    }

}
