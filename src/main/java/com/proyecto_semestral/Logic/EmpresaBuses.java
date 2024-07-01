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
        int[] auxBus = {9, 9, 9, 9, 9};

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 3; j++) {
                ListaRecorridos recEleg;
                int choiceRec, choiceBus;
                while(true) {
                    choiceRec = rng.nextInt(5);
                    if(auxRecorridos[choiceRec] > 0) {
                        --auxRecorridos[choiceRec];
                        break;
                    
                    }

                }

                recEleg = ListaRecorridos.values()[choiceRec];     

                ListaBuses busElegido; 

                while (true) {
                    choiceBus = rng.nextInt(5);
                    if(auxBus[choiceBus] > 0) {
                        --auxBus[choiceBus];
                        break;

                    }

                }

                busElegido = ListaBuses.values()[choiceBus];
                Bus tempBus;
                switch (busElegido) {
                    case SALONCAMA1PISO:
                        tempBus = new SalonCama1Piso(ListaHoras.values()[i].getHora(), recEleg.getRecorrido());
                        break;

                    case SALONCAMA2PISOS:
                        tempBus = new SalonCama2Pisos(ListaHoras.values()[i].getHora(), recEleg.getRecorrido());
                        break;

                    case MICROBUS:
                        tempBus = new Microbus(ListaHoras.values()[i].getHora(), recEleg.getRecorrido());
                        break;

                    case BUS1PISO:
                        tempBus = new Bus1Piso(ListaHoras.values()[i].getHora(), recEleg.getRecorrido());
                        break;

                    case BUS2PISOS:
                        tempBus = new Bus2Pisos(ListaHoras.values()[i].getHora(), recEleg.getRecorrido());
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
