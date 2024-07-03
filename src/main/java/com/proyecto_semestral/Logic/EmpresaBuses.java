package com.proyecto_semestral.Logic;

import java.util.ArrayList;
import java.util.Random;

public class EmpresaBuses {
    private ArrayList<Bus> tablaBuses;
    private GestorDeReservas gestor;

    /**
     * Tabla Recorrido Indices
     * 0 = Santiago
     * 1 = Lota
     * 2 = Valparaiso
     * 3 = Viña Del Mar
     * 4 = Coronel
     * 
     * Tabla Tipo Bus Indices
     * 
     * 0 = Salon Cama 1 piso
     * 1 = Salon Cama 2 Pisos
     * 2 = MicroBus
     * 3 = Bus 1 piso
     * 4 = Bus 2 pisos
     */

    /**
     * Inicializa Buses en la empresa de forma aleatoria 
     */
    
    private void inicializarBuses() {
        Random rng = new Random();
        int[] auxRecorridos = {9, 9, 9, 9, 9};
        int[] auxBus = {15, 15, 15};

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 3; j++) {
                EnumRecorridos recEleg;
                int choiceRec, choiceBus;
                while(true) {
                    choiceRec = rng.nextInt(5);
                    if(auxRecorridos[choiceRec] > 0) {
                        --auxRecorridos[choiceRec];
                        break;
                    
                    }

                }

                recEleg = EnumRecorridos.values()[choiceRec];     

                EnumBuses busElegido; 

                while (true) {
                    choiceBus = rng.nextInt(3);
                    if(auxBus[choiceBus] > 0) {
                        --auxBus[choiceBus];
                        break;

                    }

                }

                busElegido = EnumBuses.values()[choiceBus];
                Bus tempBus;
                switch (busElegido) {
                    case SalonCamaYSemiCama:
                        tempBus = new BusSalonCamaYSemiCama(EnumHoras.values()[i].getHora(), recEleg.getRecorrido());
                        break;

                    case MICROBUS:
                        tempBus = new BusMicrobus(EnumHoras.values()[i].getHora(), recEleg.getRecorrido());
                        break;

                    case BUSNORMAL:
                        tempBus = new BusNormal(EnumHoras.values()[i].getHora(), recEleg.getRecorrido());
                        break;

                    default:
                        tempBus = null;
                        break;

                }

                tablaBuses.add(tempBus);

            }

        }

        System.out.println("a");

    }

    

    public EmpresaBuses() {
        this.gestor = new GestorDeReservas();
        this.tablaBuses = new ArrayList<Bus>();
        this.inicializarBuses();
        
    }

    public GestorDeReservas getGestorDeReservas() {
        return this.gestor;

    }

    public ArrayList<Bus> getTablaBuses() {
        return tablaBuses;
    }

}
