package com.company;

import javax.swing.*;
import java.awt.*;

public class Car {
    public static final int width = 150;
    public static final int height = 150;

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

    public void draw(Graphics g)
    {
        g.drawImage(image, x, y, width, height, null);
    }
}
