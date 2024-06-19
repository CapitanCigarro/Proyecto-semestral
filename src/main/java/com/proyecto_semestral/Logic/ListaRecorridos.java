package com.proyecto_semestral.Logic;

public enum ListaRecorridos {
    SANTIAGO("Santiago"),
    LOTA("Lota"),
    VALPARAISO("Valparaiso"),
    VIÑADELMAR("Viña del mar"),
    CORONEL("Coronel");



    private final String recorrido;

    ListaRecorridos(String recorrido) {
        this.recorrido = recorrido;

    }

    public String getRecorrido() {
        return recorrido;
    }
}
