package com.proyecto_semestral.Logic;

public enum ListaRecorridos {
    SANTIAGO("Santiago", 0),
    LOTA("Lota", 1),
    VALPARAISO("Valparaiso", 2),
    VIÑADELMAR("Viña del mar", 3),
    CORONEL("Coronel", 4);



    private final String recorrido;
    private final int index;

    ListaRecorridos(String recorrido, int index) {
        this.index = index;
        this.recorrido = recorrido;

    }

    public int getIndex() {
        return index;
    }

    public String getRecorrido() {
        return recorrido;
    }

}
