package com.proyecto_semestral.Graphics;

import java.awt.Color;
import javax.swing.JPanel;

import com.proyecto_semestral.Logic.FilaAsientos;
import com.proyecto_semestral.Logic.GestorDeReservas;

public class PanelAsientosDerecha extends JPanel{
    private FilaAsientosGui filaAsientos;

    private int xSize = Sizes.FILAASIENTOS.getXSize();
    private int ySize = Sizes.FILAASIENTOS.getYSize();

    public PanelAsientosDerecha(FilaAsientos fila, GestorDeReservas g) {
        super();
        this.setBackground(Color.BLUE);
        // this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(null);
        this.filaAsientos = new FilaAsientosGui(fila, g);

        this.setSize(this.xSize, this.ySize);

        for (int i = 0; i < filaAsientos.size() / 2 - 1; i++) {
            for(int j = 0; j <= 1; j++) {
                int xSize = Sizes.ASIENTO.getXSize(), ySize =  Sizes.ASIENTO.getYSize();
                ButtonAsientoGui asiento = filaAsientos.get((i * 2) + j);
                asiento.setBounds((xSize * j) + 10,(ySize * i) + 10 ,xSize, ySize);
                asiento.setSize(xSize, ySize);
                this.add(asiento);

            }
            

        }

        // for(ButtonAsientoGui asiento : filaAsientos)  {
        //     this.add(asiento);

        // }

    }

    public FilaAsientosGui getFilaAsientos() {
        return this.filaAsientos;

    }

}
