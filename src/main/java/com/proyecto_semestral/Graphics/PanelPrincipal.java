package com.proyecto_semestral.Graphics;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.proyecto_semestral.Logic.EmpresaBuses;
import com.proyecto_semestral.Logic.GestorDeReservas;
import com.proyecto_semestral.Logic.EnumBuses;
import com.proyecto_semestral.Logic.EnumHoras;
import com.proyecto_semestral.Logic.EnumRecorridos;
import com.proyecto_semestral.Logic.EnumTipoPasaje;

import java.awt.*;
import java.awt.event.*;

public class PanelPrincipal extends JPanel {
    private JButton reiniciar, hacerAccion, reservar, quitarReserva, buscar;
    private EmpresaBusesGui empresaBusesGui;
    private EmpresaBuses empresaBuses;
    private JPanel filtros;
    @SuppressWarnings("rawtypes")
    private JComboBox filtroHora, filtroRecorrido, filtroTipoBus, tipoPasaje;
    private JLabel mensaje1, mensaje2, precios1, precios2, costoTotal;
    private String accionElegida;
    private ButtonBus busElegido;


    public PanelPrincipal() {
        super();
        this.initialize();
        this.crearBotones();
        this.setLayout(null);
        this.setSize(1600, 800);
        this.estadoInicial();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
        this.setBackground(Color.BLACK);
        this.accionElegida = null;
        this.empresaBuses = new EmpresaBuses();
        this.mensaje1 = new JLabel();
        this.mensaje2 = new JLabel();
        this.precios1 = new JLabel();
        this.precios2 = new JLabel();
        this.costoTotal = new JLabel();
        this.empresaBusesGui = new EmpresaBusesGui(this.empresaBuses.getTablaBuses(), this.empresaBuses.getGestorDeReservas(), this);
        this.add(precios1);
        this.add(precios2);
        this.add(costoTotal);
        this.add(mensaje1);
        this.add(mensaje2);
        

        this.tipoPasaje = new JComboBox<String>();
        for (EnumTipoPasaje precios : EnumTipoPasaje.values()) {
            this.tipoPasaje.addItem((String)precios.toString());

        }

        this.tipoPasaje.setBounds(1120, 200, 200, 30);
        this.tipoPasaje.setBackground(Color.lightGray);
        this.tipoPasaje.setForeground(Color.BLACK);
        this.filtros = new JPanel();
        this.filtros.setBounds(0, 40, 1100, 700);
        this.filtros.setLayout(null);
        this.mensaje1.setBounds(0, 700, 800, 100);
        this.mensaje2.setBounds(1120, -20, 400, 100);
        this.precios1.setBounds(1120, 60, 400, 20);
        this.precios2.setBounds(1120, 90, 400, 20);
        this.costoTotal.setBounds(1120, 120, 400, 20);
        this.mensaje1.setForeground(Color.WHITE);
        this.mensaje1.setBackground(Color.BLACK);
        this.mensaje2.setBackground(Color.DARK_GRAY);
        this.mensaje2.setForeground(Color.white);
        this.filtros.setBackground(Color.BLACK);
        this.costoTotal.setForeground(Color.white);

        this.tipoPasaje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarMensaje2();     

            }
        });


        this.add(filtros);
        this.add(this.tipoPasaje);

    }

    @SuppressWarnings("unchecked")
    private void crearBotones() {
        this.reiniciar = new JButton();
        this.hacerAccion = new JButton();
        this.reservar =  new JButton();
        this.quitarReserva = new JButton();
        this.buscar = new JButton();

        ActionListener reiniciaListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estadoInicial();
                
            }
            
        };

        ActionListener hacerAccionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    hacerAccion();
                
                } catch (NoAccionElegidaException exception) {
                    mensaje1.setText("Seleccionar accion");

                }

            }
            
        };

        ActionListener reservListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservar();

            }

        };

        ActionListener quitarReservaListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitarReserva();

            }

        };

        ActionListener buscarListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar();

            }

        };

        this.buscar.addActionListener(buscarListener);
        this.reservar.addActionListener(reservListener);
        this.quitarReserva.addActionListener(quitarReservaListener);
        this.hacerAccion.addActionListener(hacerAccionListener);
        this.reiniciar.addActionListener(reiniciaListener);

        this.reiniciar.setSize(EnumSizes.BOTONESPANELPRINCIPAL.getXSize(), EnumSizes.BOTONESPANELPRINCIPAL.getYSize());
        this.hacerAccion.setSize(EnumSizes.BOTONESPANELPRINCIPAL.getXSize(), EnumSizes.BOTONESPANELPRINCIPAL.getYSize());
        this.reservar.setSize(EnumSizes.BOTONESPANELPRINCIPAL.getXSize(), EnumSizes.BOTONESPANELPRINCIPAL.getYSize());
        this.quitarReserva.setSize(EnumSizes.BOTONESPANELPRINCIPAL.getXSize(), EnumSizes.BOTONESPANELPRINCIPAL.getYSize());

        this.reiniciar.setText("Reiniciar");
        this.hacerAccion.setText("Realizar accion");
        this.reservar.setText("Reservar");
        this.quitarReserva.setText("Quitar reservas");

        this.reiniciar.setLocation(1440, 720);
        this.quitarReserva.setLocation(1140, 720 - 10 - EnumSizes.BOTONESPANELPRINCIPAL.getYSize());
        this.reservar.setLocation(1140, 720);
        this.hacerAccion.setLocation(1290, 720);

        this.add(hacerAccion);
        this.add(reiniciar);
        this.add(quitarReserva);
        this.add(reservar);

        this.filtroHora = new JComboBox<>(EnumHoras.values());
        this.filtroRecorrido = new JComboBox<>(EnumRecorridos.values());
        this.filtroTipoBus = new JComboBox<>(EnumBuses.values());
        this.filtroRecorrido.addItem("Ignorar");
        this.filtroTipoBus.addItem("Ignorar");
        this.filtroHora.addItem("Ignorar");

        this.filtroHora.setBounds(300, 0, 100, 20);
        this.filtroRecorrido.setBounds(410, 0, 100, 20);
        this.filtroTipoBus.setBounds(520, 0, 120, 20);
        this.buscar.setBounds(650, 0 , 100, 20);
        this.buscar.setText("Filtrar");

        this.add(this.buscar);
        this.add(filtroHora);
        this.add(filtroRecorrido);
        this.add(filtroTipoBus);

    }

    public void estadoInicial() {
        this.mensaje1.setText("Aqui se mostraran detalles de bus seleccionado");
        this.mensaje2.setText("Aqui se mostrara detalles de asientos seleccionados");
        this.precios1.setVisible(false);
        this.precios2.setVisible(false);
        this.precios1.setBackground(Color.black);
        this.precios2.setBackground(Color.black);
        this.precios2.setForeground(Color.white);
        this.precios1.setForeground(Color.white);
        this.quitarReserva.setBackground(Color.white);
        this.reservar.setBackground(Color.white);
        this.busElegido = null;
        this.accionElegida = null;
        this.empresaBuses.getGestorDeReservas().quitarReservas();
        this.reservar.setVisible(false); 
        this.quitarReserva.setVisible(false);
        this.hacerAccion.setVisible(false);
        this.tipoPasaje.setVisible(false);

        this.filtros.removeAll();
        this.repaint();

    }

    public void segundoEstado(ButtonBus bus) {
        this.reservar();
        this.reservar.setVisible(true);
        this.quitarReserva.setVisible(true);
        this.hacerAccion.setVisible(true);
        this.tipoPasaje.setVisible(true);
        this.busElegido = bus;

    }

    public void cambiarMensaje1(String s) {
        this.mensaje1.setText(s);

    }

    public void cambiarMensaje2() {
        GestorDeReservas gestor = this.empresaBuses.getGestorDeReservas();
        this.mensaje2.setText("<html>" + "Asientos Seleccionados = " + gestor.toString() + "</html>");
        this.precios1.setVisible(true);
        gestor.setModificador((String)this.tipoPasaje.getSelectedItem());
        if (this.reservar.getBackground() == Color.GREEN) {
            if(gestor.getBusSeleccionado().getTipoBus() == EnumBuses.SalonCamaYSemiCama) {
                this.precios1.setText("Costo salon cama      = $" + String.valueOf(gestor.getBusSeleccionado().getAsiento(1).getPrecio() * gestor.getModificador()));
                this.precios2.setText("Costo semi salon cama = $" + String.valueOf(gestor.getBusSeleccionado().getAsiento(30).getPrecio() * gestor.getModificador()));
                this.precios2.setVisible(true);     

            } else {
                this.precios1.setText("Costo asiento = $" + String.valueOf(gestor.getBusSeleccionado().getAsiento(1).getPrecio() * gestor.getModificador()));

            }

            this.costoTotal.setText("Costo Total = $" + String.valueOf(gestor.getCostoTotal()));
            this.costoTotal.setVisible(true);
            
        }

    }

    public void hacerAccion() throws NoAccionElegidaException {
        if (this.accionElegida == null) {
            throw new NoAccionElegidaException("No se eligio accion");

        }

        if (accionElegida == "reservar") {
            this.cambiarMensaje1(this.empresaBuses.getGestorDeReservas().reservar());

        } else {
            this.cambiarMensaje1(this.empresaBuses.getGestorDeReservas().quitarReservas());

        }

        this.costoTotal.setVisible(false);
        this.precios1.setVisible(false);
        this.precios2.setVisible(false);

        this.busElegido.getPanelBus().actualizarColoresAsientos();

        this.empresaBuses.getGestorDeReservas().limpiarSelecciones();

        this.repaint();

    }

    public void reservar() {
        if (this.accionElegida == "reservar") {
            this.accionElegida = "quitarReserva";
            this.reservar.setBackground(Color.white);
            this.precios1.setVisible(false);
            this.precios2.setVisible(false);
            this.costoTotal.setVisible(false);

        } else{ 
            this.accionElegida = "reservar";
            this.reservar.setBackground(Color.green);
            this.quitarReserva.setBackground(Color.WHITE);
            this.cambiarMensaje2();

        }

    }

    public void quitarReserva() {
        if (this.accionElegida == "quitarReserva") {
            this.accionElegida = "reservar";
            this.quitarReserva.setBackground(Color.white);
            this.reservar.setBackground(Color.green);
            this.cambiarMensaje2();


        } else {
            this.accionElegida = "quitarReserva";
            this.reservar.setBackground(Color.white);
            this.quitarReserva.setBackground(Color.green);
            this.precios1.setVisible(false);
            this.precios2.setVisible(false);
            this.costoTotal.setVisible(false);
        }

        

    }

    public void buscar() {
        this.estadoInicial();
        int loop = 0;
        for (ButtonBus bus : empresaBusesGui.getTablaBuses()) {
            boolean condHora = bus.getBus().getHora() == filtroHora.getSelectedItem() || filtroHora.getSelectedItem() == "Ignorar";
            boolean condRecorrido = bus.getBus().getRecorridoElegido() == this.filtroRecorrido.getSelectedItem() || this.filtroRecorrido.getSelectedItem() == "Ignorar";
            boolean condTipoBus = bus.getBus().getTipoBusIndex() == this.filtroTipoBus.getSelectedIndex() || this.filtroTipoBus.getSelectedItem() == "Ignorar";
            
            if (condRecorrido && condTipoBus && condHora) {
                bus.setLocation(EnumSizes.BUTTONBUS.getXSize() * (loop % 5) + 10, (loop / 5) * EnumSizes.BUTTONBUS.getYSize() + 10);
                ++loop;
                this.filtros.add(bus);

            }
            
        }
        
        this.repaint();

    }

    public JPanel getFiltros() {
        return filtros;
    }

    public EmpresaBuses getEmpresaBuses() {
        return empresaBuses;
    }

    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        
    }

}
