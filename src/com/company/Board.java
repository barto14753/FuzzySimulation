package com.company;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Board extends JPanel implements ActionListener, KeyListener {
    private final Timer timer = new Timer(1000, this);
    private final static Random random = new Random();

    private Image road;
    public final static int leftBorder = 155;
    public final static int rightBorder = 895;
    private int boardPosition = 0;
    public final static int boardSpeed = 3;
    public MovingCar movingCar = null;
    private boolean isRunning = true;

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

    public void addBots()
    {
        botCars.add(new BotCar(this.botCars));

    }

    private void removeBots()
    {
        botCars.removeIf(botCar -> botCar.toDelete(getHeight()));
    }

    private void handleCollision()
    {
        if (movingCar.madeCollision(botCars))
        {
            this.isRunning = false;

        }
    }


    @Override
    public void paintComponent(Graphics g) {
        if (isRunning)
        {
            removeBots();
            this.update();
            handleCollision();
        }

        g.drawImage(road, 0, boardPosition - getHeight(), null);
        g.drawImage(road, 0, boardPosition, null);

        for (BotCar botCar: botCars)
        {
            if (isRunning) botCar.move();
            botCar.draw(g);
        }
        if (botCars.isEmpty() || !isRunning) movingCar.draw(g);
        else if (botCars.size() < 2) movingCar.draw(g, botCars.get(0).x, botCars.get(0).x);
        else movingCar.draw(g, botCars.get(1).x, botCars.get(0).x);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isRunning)
        {
            addBots();

            timer.setDelay(random.nextInt(500) + 1000);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

        if (!isRunning)
        {

            this.isRunning = true;
            botCars = new ArrayList<>();
            movingCar = new MovingCar(CarColor.green, 500, 575);
            timer.setDelay(random.nextInt(500) + 250);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}