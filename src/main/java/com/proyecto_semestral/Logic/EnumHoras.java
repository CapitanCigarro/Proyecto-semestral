package com.proyecto_semestral.Logic;

/**
 * Clase que contiene las lista de horas manejadas por el programa
 */

public enum EnumHoras {
    HORA0600("06:00", 0),
    HORA0700("07:00", 1),
    HORA0800("08:00", 2),
    HORA0900("09:00", 3),
    HORA1000("10:00", 4),
    HORA1100("11:00", 5),
    HORA1200("12:00", 6),
    HORA1300("13:00", 7),
    HORA1400("14:00", 8),
    HORA1500("15:00", 9),
    HORA1600("16:00", 10),
    HORA1700("17:00", 11),
    HORA1800("18:00", 12),
    HORA1900("19:00", 13),
    HORA2000("20:00", 14);

    private final String hora;
    private final int index;

    EnumHoras(String hora, int index) {
        this.hora = hora;
        this.index = index;

    }

    public int getIndex() {
        return this.index;

    }

    public String getHora() {
        return this.hora;

    }

}
