package com.company;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Application extends JFrame implements ActionListener{
    private final Timer timer = new Timer(5, this);
    private Board board;


    public Application() {

        timer.start();
        initUI();
    }

    private void initUI() {

        board = new Board();
        add(board);
        addKeyListener(board.movingCar);
        addKeyListener(board);
        setSize(1200, 800);

        setTitle("Car Simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
    }
}
