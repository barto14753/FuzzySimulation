package com.company;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {
    private final Timer timer = new Timer(1000, this);
    private final static Random random = new Random();

    private Image road;
    public final static int leftBorder = 155;
    public final static int rightBorder = 895;
    private int boardPosition = 0;
    public final static int boardSpeed = 3;
    public MovingCar movingCar = null;

    private ArrayList<BotCar> botCars = new ArrayList<>();

    public Board() {
        this.movingCar = new MovingCar(CarColor.green, 500, 575);
        initBoard();
        timer.start();
    }

    private void initBoard() {

        loadImages();

        int w = road.getWidth(this);
        int h =  road.getHeight(this);
        setPreferredSize(new Dimension(w, h));
    }

    private void loadImages() {

        ImageIcon ii1 = new ImageIcon("src/resources/road.png");
        road = ii1.getImage();
        road = road.getScaledInstance(1200, 800, Image.SCALE_FAST);
    }

    private void update()
    {
        boardPosition = (boardPosition + boardSpeed) % getHeight();
    }

    public void addBot()
    {
        botCars.add(new BotCar());
    }

    private void removeBots()
    {
        botCars.removeIf(botCar -> botCar.toDelete(getHeight()));
    }

    @Override
    public void paintComponent(Graphics g) {

        this.update();
        g.drawImage(road, 0, boardPosition - getHeight(), null);
        g.drawImage(road, 0, boardPosition, null);

        for (BotCar botCar: botCars) botCar.draw(g);
        movingCar.draw(g);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addBot();
        removeBots();

        timer.setDelay(random.nextInt(750) + 500);
    }
}