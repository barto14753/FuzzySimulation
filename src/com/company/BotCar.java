package com.company;

import java.awt.*;
import java.util.Random;

public class BotCar extends Car{
    public static Random random = new Random();
    public BotCar() {
        super(CarColor.randomColor(), random.nextInt(Board.rightBorder - Board.leftBorder) + Board.leftBorder, -Car.height);
    }

    public boolean toDelete(int height)
    {
        return super.y >= height;
    }

    @Override
    public void draw(Graphics g)
    {
        super.y += Board.boardSpeed;

        super.draw(g);
    }
}
