package com.proyecto_semestral.Graphics;

import javax.swing.JLabel;

public enum Mensaje {
    MENSAJE;

    private String mensaje = "Seleccionar bus";
    private final JLabel label;
    private final int xSize = 300;
    private final int ySize = 20;
    private Mensaje() {
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
