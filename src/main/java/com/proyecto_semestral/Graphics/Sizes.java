package com.proyecto_semestral.Graphics;

public enum Sizes {
    ASIENTO(60, 60),
    FILAASIENTOS(275, 1000),
    BUS(1100, 1000),
    MENSAJE(300, 20),
    PanelesBuses(600, 600),
    PISO(550, 1000),
    BOTONESPANELPRINCIPAL(100, 40),
    BUTTONBUS(200, 50);

    private final int xSize, ySize;

    private Sizes(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;

    }

    public int getXSize() {
        return this.xSize;

    }

    public int getYSize() {
        return this.ySize;

    }

}
