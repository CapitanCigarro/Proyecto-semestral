package com.proyecto_semestral.Graphics;

import javax.swing.*;

public class MyFrame extends JFrame {
    PanelPrincipal principal;
    public MyFrame(){
        super();
        principal = new PanelPrincipal();
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setLocation(0, 0);
        this.setTitle("Reservador de asientos");
        this.setVisible(true);
        this.addMouseListener(principal);

        this.add(principal);

    }
}
