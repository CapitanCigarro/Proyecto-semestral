package com.proyecto_semestral.Graphics;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
    private JComboBox filtroHora, filtroRecorrido, filtroTipoBus;
    private JLabel mensaje;

    public PanelPrincipal() {
        super();
        this.empresaBuses = new EmpresaBuses();
        this.mensaje = new JLabel();
        this.empresaBusesGui = new EmpresaBusesGui(this.empresaBuses.getTablaHoraria(), this.empresaBuses.getGestorDeReservas(), this);
        this.crearBotones();
        this.filtros = new JPanel();
        this.filtros.setBounds(0, 40, 1100, 700);
        this.mensaje.setBounds(0, 700, 500, 100);
        this.mensaje.setForeground(Color.BLACK);
        this.add(mensaje);
        this.filtros.setBackground(Color.BLACK);
        this.add(filtros);
        this.setLayout(null);
        this.setSize(1200, 800);
        this.estadoInicial();

    }

    public void estadoInicial() {
        this.mensaje.setText("Aqui se mostraran detalles de bus seleccionado");
        this.reservar.setVisible(false);
        this.quitarReserva.setVisible(false);
        this.hacerAccion.setVisible(false);
        this.reiniciar.setLocation(1080, 720);
        this.filtros.removeAll();
        this.repaint();

    }

    public void cambiarMensaje(String s) {
        this.mensaje.setText(s);

    }

    public void hacerAccion() {


    }

    public void reservar() {


    }

    public void quitarReserva() {


    }

    public void buscar() {
        this.estadoInicial();
        int loop = 0;
        for (ButtonBus bus : empresaBusesGui.getTablaHoraria().get(this.filtroHora.getSelectedIndex())) {
            boolean condRecorrido = bus.getBus().getRecorridoElegido() == this.filtroRecorrido.getSelectedItem() || this.filtroRecorrido.getSelectedItem() == null;
            boolean condTipoBus = bus.getBus().getTipoBusIndex() == this.filtroTipoBus.getSelectedIndex() || this.filtroTipoBus.getSelectedItem() == null;
            
            if (condRecorrido && condTipoBus) {
                bus.setLocation(Sizes.BUTTONBUS.getXSize() * loop + 10, 0);
                ++loop;
                this.filtros.add(bus);

            }
            
        }
        
        this.repaint();

    }

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
                hacerAccion();

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

        this.add(hacerAccion);
        this.add(reiniciar);
        this.add(quitarReserva);
        this.add(reservar);

        this.filtroHora = new JComboBox<>(ListaHoras.values());
        this.filtroRecorrido = new JComboBox<>(ListaRecorridos.values());
        this.filtroTipoBus = new JComboBox<>(ListaBuses.values());
        this.filtroRecorrido.addItem(null);
        this.filtroTipoBus.addItem(null);

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

    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        
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
