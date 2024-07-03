package com.proyecto_semestral.Graphics;

import java.util.ArrayList;

import com.proyecto_semestral.Logic.*;

public class FilaAsientosGui extends ArrayList<ButtonAsiento>{
    private FilaAsientos fila;

    public FilaAsientosGui(FilaAsientos fila, GestorDeReservas g, PanelPrincipal panelPrincipal) {
        super();
        this.fila = fila;

        for(Asiento asiento : fila) {
            this.add(new ButtonAsiento(asiento, g, panelPrincipal));

        }

    }

    public FilaAsientos getFilaAsientos() {
        return this.fila;
        
    }

}