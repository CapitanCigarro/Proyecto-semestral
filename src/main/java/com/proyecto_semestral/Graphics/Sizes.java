package com.proyecto_semestral.Graphics;

public enum Sizes {
    ASIENTO(10, 10),
    FILAASIENTOS(400, 400),
    BUS(800, 800),
    MENSAJE(300, 20),
    PISO(400, 400);

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
