package com.proyecto_semestral.Graphics;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.proyecto_semestral.Logic.Asiento;
import com.proyecto_semestral.Logic.EmpresaBuses;
import com.proyecto_semestral.Logic.ListaBuses;
import com.proyecto_semestral.Logic.ListaHoras;
import com.proyecto_semestral.Logic.ListaRecorridos;

import java.awt.*;
import java.awt.event.*;

public class PanelPrincipal extends JPanel implements MouseListener{
    private JButton reiniciar, hacerAccion, reservar, quitarReserva, buscar;
    private EmpresaBusesGui empresaBusesGui;
    private EmpresaBuses empresaBuses;
    private JPanel filtros;
    @SuppressWarnings("rawtypes")
    private JComboBox filtroHora, filtroRecorrido, filtroTipoBus;
    private JLabel mensaje1, mensaje2;
    private String accionElegida;
    private ButtonBus busElegido;


    public PanelPrincipal() {
        super();
        this.setBackground(Color.BLACK);
        this.accionElegida = null;
        this.empresaBuses = new EmpresaBuses();
        this.mensaje1 = new JLabel();
        this.empresaBusesGui = new EmpresaBusesGui(this.empresaBuses.getTablaBuses(), this.empresaBuses.getGestorDeReservas(), this);
        this.crearBotones();
        this.filtros = new JPanel();
        this.filtros.setBounds(0, 40, 1100, 700);
        this.filtros.setLayout(null);
        this.mensaje1.setBounds(0, 700, 800, 100);
        this.mensaje1.setForeground(Color.WHITE);
        this.mensaje1.setBackground(Color.BLACK);
        this.add(mensaje1);
        this.filtros.setBackground(Color.BLACK);
        this.add(filtros);
        this.setLayout(null);
        this.setSize(1600, 800);
        this.estadoInicial();

    }

    public void estadoInicial() {
        this.mensaje1.setText("Aqui se mostraran detalles de bus seleccionado");
        this.mensaje2.setText("Aqui se mostrara detalles de asientos seleccionados");
        this.quitarReserva.setBackground(Color.white);
        this.reservar.setBackground(Color.white);
        this.busElegido = null;
        this.accionElegida = null;
        this.empresaBuses.getGestorDeReservas().quitarReservas();
        this.reservar.setVisible(false); 
        this.quitarReserva.setVisible(false);
        this.hacerAccion.setVisible(false);

        this.filtros.removeAll();
        this.repaint();

    }

    public void segundoEstado(ButtonBus bus) {
        reservar.setVisible(true);
        this.quitarReserva.setVisible(true);
        this.hacerAccion.setVisible(true);
        this.busElegido = bus;

    }

    public void cambiarMensaje1(String s) {
        this.mensaje1.setText(s);

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

        this.busElegido.getPanelBus().actualizarColoresAsientos();

        this.empresaBuses.getGestorDeReservas().limpiarSelecciones();

        this.repaint();

    }

    public void reservar() {
        if (this.accionElegida == "reservar") {
            this.accionElegida = null;
            this.reservar.setBackground(Color.white);

        } else{ 
            this.accionElegida = "reservar";
            this.reservar.setBackground(Color.green);
            this.quitarReserva.setBackground(Color.WHITE);

        }

    }

    public void quitarReserva() {
        if (this.accionElegida == "quitarReserva") {
            this.accionElegida = null;
            this.quitarReserva.setBackground(Color.white);

        } else {
            this.accionElegida = "quitarReserva";
            this.reservar.setBackground(Color.white);
            this.quitarReserva.setBackground(Color.green);
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
                bus.setLocation(Sizes.BUTTONBUS.getXSize() * (loop % 5) + 10, (loop / 5) * Sizes.BUTTONBUS.getYSize() + 10);
                ++loop;
                this.filtros.add(bus);

            }
            
        }
        
        this.repaint();

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

        this.reiniciar.setSize(Sizes.BOTONESPANELPRINCIPAL.getXSize(), Sizes.BOTONESPANELPRINCIPAL.getYSize());
        this.hacerAccion.setSize(Sizes.BOTONESPANELPRINCIPAL.getXSize(), Sizes.BOTONESPANELPRINCIPAL.getYSize());
        this.reservar.setSize(Sizes.BOTONESPANELPRINCIPAL.getXSize(), Sizes.BOTONESPANELPRINCIPAL.getYSize());
        this.quitarReserva.setSize(Sizes.BOTONESPANELPRINCIPAL.getXSize(), Sizes.BOTONESPANELPRINCIPAL.getYSize());
        
        this.reiniciar.setText("Reiniciar");
        this.hacerAccion.setText("Realizar accion");
        this.reservar.setText("Reservar");
        this.quitarReserva.setText("Quitar reservas");

        this.reiniciar.setLocation(1440, 720);
        this.quitarReserva.setLocation(990, 720);
        this.reservar.setLocation(1140, 720);
        this.hacerAccion.setLocation(1290, 720);

        this.add(hacerAccion);
        this.add(reiniciar);
        this.add(quitarReserva);
        this.add(reservar);

        this.filtroHora = new JComboBox<>(ListaHoras.values());
        this.filtroRecorrido = new JComboBox<>(ListaRecorridos.values());
        this.filtroTipoBus = new JComboBox<>(ListaBuses.values());
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

    public JPanel getFiltros() {
        return filtros;
    }

    public EmpresaBuses getEmpresaBuses() {
        return empresaBuses;
    }

    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        
    }

    public void cambiarMensaje2() {
        String mensaje = "Asientos seleccionados = " +  this.empresaBuses.getGestorDeReservas().toString();
        if (this.reservar.getBackground() == Color.green) {
            mensaje += "\n" + String.valueOf(this.empresaBuses.getGestorDeReservas().getCostoTotal());

        }

        this.mensaje2.setText(mensaje);

        // TODO mostrar precios

    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
