package com.proyecto_semestral.Graphics;

import javax.swing.JLabel;

public enum LabelMensaje {
    MENSAJE;

    private String mensaje = "Seleccionar bus";
    private final JLabel label;
    private final int xSize = Sizes.MENSAJE.getXSize();
    private final int ySize = Sizes.MENSAJE.getYSize();
    private LabelMensaje() {
        this.label = new JLabel();
        this.label.setText(this.mensaje);
        this.label.setSize(xSize, ySize);

    }

    public void setText(String s) {
        this.mensaje = s;
        this.label.setText(s);

    }

    public String getMensaje() {
        return this.mensaje;

    }

    public JLabel getLabel() {
        return this.label;

    }

}
