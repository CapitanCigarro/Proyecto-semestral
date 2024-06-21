package com.proyecto_semestral.Logic;

import java.util.ArrayList;
import java.util.Random;

public class EmpresaBuses {
    private ArrayList<ArrayList<Bus>> tablaHoraria;
    private ArrayList<ArrayList<Bus>> tablaRecorrido;
    private ArrayList<ArrayList<Bus>> tablaTipoBus;

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
     * Inicializa arreglos
     */
    private void inicializarArrays() {
        this.tablaHoraria = new ArrayList<ArrayList<Bus>>();
        this.tablaRecorrido = new ArrayList<ArrayList<Bus>>();
        this.tablaTipoBus = new ArrayList<ArrayList<Bus>>();
        
        for (int i = 0; i < 5; i++) {
            this.tablaRecorrido.add(new ArrayList<Bus>());
            this.tablaTipoBus.add(new ArrayList<Bus>());

        }

        for (int i = 0; i < 15; i++) {
            this.tablaHoraria.add(new ArrayList<Bus>());

        }

    }


    /**
     * Inicializa Buses en la empresa de forma aleatoria 
     */
    
    private void inicializarBuses() {
        Random rng = new Random();
        int[] auxRecorridos = {9, 9, 9, 9, 9};
        int[] auxBus = {9, 9, 9, 9, 9};

        for (int i = 0; i < 15; i++) {
            boolean[] auxBusRep = {true, true, true, true, true};
            boolean[] auxRecRep = {true, true, true, true, true};
            for (int j = 0; j < 3; j++) {
                ListaRecorridos recEleg;
                int choiceRec, choiceBus;
                while(true) {
                    choiceRec = rng.nextInt(5);
                    if(auxRecorridos[choiceRec] > 0 && auxRecRep[choiceRec]) {
                        --auxRecorridos[choiceRec];
                        auxRecRep[choiceRec] = false;
                        break;
                    
                    }

                }

                recEleg = ListaRecorridos.values()[choiceRec];     

                ListaBuses busElegido; 

                while (true) {
                    choiceBus = rng.nextInt(5);
                    if(auxBus[choiceBus] > 0 && auxBusRep[choiceBus]) {
                        --auxBus[choiceBus];
                        auxBusRep[choiceBus] = false;
                        break;

                    }

                }

                busElegido = ListaBuses.values()[choiceBus];
                Bus tempBus;
                switch (busElegido) {
                    case SALONCAMA1PISO:
                        tempBus = new SalonCama1Piso(ListaHoras.values()[i].getHora(), recEleg.getRecorrido());
                        this.tablaTipoBus.get(0).add(tempBus);
                        break;

                    case SALONCAMA2PISOS:
                        tempBus = new SalonCama2Pisos(ListaHoras.values()[i].getHora(), recEleg.getRecorrido());
                        this.tablaTipoBus.get(1).add(tempBus);
                        break;

                    case MICROBUS:
                        tempBus = new Microbus(ListaHoras.values()[i].getHora(), recEleg.getRecorrido());
                        this.tablaTipoBus.get(2).add(tempBus);
                        break;

                    case BUS1PISO:
                        tempBus = new Bus1Piso(ListaHoras.values()[i].getHora(), recEleg.getRecorrido());
                        this.tablaTipoBus.get(3).add(tempBus);
                        break;

                    case BUS2PISOS:
                        tempBus = new Bus2Pisos(ListaHoras.values()[i].getHora(), recEleg.getRecorrido());
                        this.tablaTipoBus.get(4).add(tempBus);
                        break;

                    default:
                        tempBus = null;
                        break;

                }

                tablaHoraria.get(i).add(tempBus);

                switch (recEleg) {
                    case SANTIAGO:
                        this.tablaRecorrido.get(0).add(tempBus);
                        break;
                
                    case LOTA:
                        this.tablaRecorrido.get(1).add(tempBus);
                        break;

                    case VALPARAISO:
                        this.tablaRecorrido.get(2).add(tempBus);
                        break;

                    case VIÑADELMAR:
                        this.tablaRecorrido.get(3).add(tempBus);
                        break;

                    case CORONEL:
                        this.tablaRecorrido.get(4).add(tempBus);
                        break;

                    default:
                        break;

                }

            }

        }

    }

    public EmpresaBuses() {
        this.inicializarArrays();
        this.inicializarBuses();
        
    }

    public ArrayList<ArrayList<Bus>> getTablaHoraria() {
        return tablaHoraria;
    }

    public ArrayList<ArrayList<Bus>> getTablaRecorrido() {
        return tablaRecorrido;
    }

    public ArrayList<ArrayList<Bus>> getTablaTipoBus() {
        return tablaTipoBus;
    }

    

}
