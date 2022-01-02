package com.company;

import javax.swing.*;
import java.awt.*;

public class Car {
    public static final int width = 120;
    public static final int height = 175;

    private final Image image;
    private final CarColor color;
    protected int x;
    protected int y;


    public Car(CarColor color, int x, int y)
    {
        this.color = color;
        this.x = x;
        this.y = y;
        ImageIcon img = new ImageIcon(this.color.getImagePath());
        this.image = img.getImage();

    }

    public boolean isCollision(int x1, int y1)
    {
        return Math.abs(x1-this.x) < Car.width*0.9 && Math.abs(y1-this.y) < Car.height*0.95;
    }

    public void draw(Graphics g)
    {
        g.drawImage(image, x, y, width, height, null);
    }
}
