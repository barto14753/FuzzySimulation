package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovingCar extends Car implements KeyListener {
    private float velocity = 0;

    private final float maxVelocity = 10;
    private final float velocityChange = 1.5F;
    private final float velocityDowngrade = 0.2F;


    public MovingCar(CarColor color, int x, int y) {
        super(color, x, y);
    }

    public void handleBorders()
    {
        super.x = Math.max(x, Board.leftBorder);
        super.x = Math.min(x, Board.rightBorder);
    }

    @Override
    public void draw(Graphics g)
    {
        if (velocity > velocityDowngrade) velocity -= velocityDowngrade;
        else if (velocity < -velocityDowngrade) velocity += velocityDowngrade;
        else velocity = 0;

        super.x += velocity;
        this.handleBorders();

        super.draw(g);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            velocity = Math.max(-maxVelocity, velocity - velocityChange);
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            velocity = Math.min(maxVelocity, velocity + velocityChange);
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
