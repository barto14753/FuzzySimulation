package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MovingCar extends Car implements KeyListener {

    public MovingCar(CarColor color, int x, int y) {
        super(color, x, y);
    }

    public void handleBorders()
    {
        super.x = Math.max(x, Board.leftBorder);
        super.x = Math.min(x, Board.rightBorder);
    }

    private void fuzzyLogicMove(int firstCarPosition, int first_car_position)
    {
        super.x += FuzzyLogic.getMove(super.x, first_car_position - super.x, 0);
    }

    @Override
    public void draw(Graphics g)
    {
        this.handleBorders();
        super.draw(g);

    }

    public void draw(Graphics g, int first_car_position, int second_car_position)
    {
        this.fuzzyLogicMove(first_car_position, second_car_position);
        this.handleBorders();
        super.draw(g);
    }

    public boolean madeCollision(ArrayList<BotCar> botCars)
    {
        for (BotCar botCar: botCars)
        {
            if (this.isCollision(botCar.x, botCar.y)) return true;
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            //super.x -= 10;
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            //super.x += 10;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyTyped(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
