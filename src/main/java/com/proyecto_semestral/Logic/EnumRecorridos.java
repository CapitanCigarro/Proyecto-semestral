package com.proyecto_semestral.Logic;

/**
 * Clase que contiene los recorridos manejados por el programa
 */

public enum EnumRecorridos {
    SANTIAGO("Santiago", 0, 10500),
    IQUIQUE("Iquique", 1, 30000),
    VALPARAISO("Valparaiso", 2, 14000),
    VIÑADELMAR("Viña del mar", 3, 15000),
    PUERTOMONTT("Puerto Montt", 4, 20000);



    private final String recorrido;
    private final int index;
    private final double precio;

    EnumRecorridos(String recorrido, int index, double precio) {
        this.index = index;
        this.recorrido = recorrido;
        this.precio = precio;

    }

    public int getIndex() {
        return index;
    }

    public String getRecorrido() {
        return recorrido;
    }

    public double getPrecio() {
        return precio;
    }

}
