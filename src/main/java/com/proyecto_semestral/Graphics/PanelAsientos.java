package com.proyecto_semestral.Graphics;

import javax.swing.JPanel;

/**
 * Clase para poliformismo entre filas de asientos
 */

public abstract class PanelAsientos extends JPanel{
    public  PanelAsientos() {
        super();

    }

    public abstract int getNumAsientos();

}
