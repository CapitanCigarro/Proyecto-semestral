package com.proyecto_semestral.Graphics;

import javax.swing.*;

public class MyFrame extends JFrame {
    PanelPrincipal principal;
    public MyFrame(){
        super();
        principal = new PanelPrincipal();
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setTitle("Reservador de asientos");
        this.setVisible(true);
        this.addMouseListener(principal);

        this.add(principal);

    }
}
