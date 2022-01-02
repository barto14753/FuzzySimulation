package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BotCar extends Car{
    public static Random random = new Random();
    public BotCar() {
        super(CarColor.randomColor(), random.nextInt(Board.rightBorder - Board.leftBorder) + Board.leftBorder, -Car.height);
    }

    public BotCar(int x)
    {
        super(CarColor.randomColor(), x, -Car.height);
    }

    public BotCar(ArrayList<BotCar> botCars)
    {
        super(CarColor.randomColor(), BotCar.getRandomX(botCars), -Car.height);
    }

    public static int getRandomX(ArrayList<BotCar> botCars)
    {
        System.out.println(botCars);
        int x = random.nextInt(Board.rightBorder - Board.leftBorder) + Board.leftBorder;
        for (int i=0; i<100; i++)
        {
            System.out.println(x);
            boolean isCollision = false;
            for (BotCar car: botCars)
            {
                if (car.isCollision(x, -Car.height))
                {
                    isCollision = true;
                    break;
                }
            }
            if (!isCollision) return x;
            else x = random.nextInt(Board.rightBorder - Board.leftBorder) + Board.leftBorder;

        }
        return 2000;
    }

    public boolean toDelete(int height)
    {
        return super.y >= height;
    }

    public void move()
    {
        super.y += Board.boardSpeed;
    }
    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
    }
}
