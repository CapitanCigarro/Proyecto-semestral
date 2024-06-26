package com.proyecto_semestral.Graphics;

import java.util.ArrayList;

import com.proyecto_semestral.Logic.*;

public class FilaAsientosGui extends ArrayList<AsientoGui>{
    private FilaAsientos fila;

    public FilaAsientosGui(FilaAsientos fila, GestorDeReservas g) {
        super();
        this.fila = fila;

        for(Asiento asiento : fila) {
            this.add(new AsientoGui(asiento, g));

        }

    }

    public FilaAsientos getFilaAsientos() {
        return this.fila;

    }

}