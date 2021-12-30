package com.company;

import java.util.Random;

public enum CarColor {
    green("src/resources/green_car.png"),
    purple("src/resources/purple_car.png"),
    red("src/resources/red_car.png"),
    yellow("src/resources/yellow_car.png");

    private final String imagePath;
    public static Random random = new Random();
    CarColor(String path)
    {
        this.imagePath = path;
    }

    public String getImagePath() {
        return imagePath;
    }

    public static CarColor randomColor()
    {
        int r = random.nextInt(4);
        switch (r)
        {
            case 0: return green;
            case 1: return purple;
            case 2: return red;
            case 3: return yellow;
            default: return green;
        }

    }
}


