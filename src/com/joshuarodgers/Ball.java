package com.joshuarodgers;

import java.awt.Point;
import java.awt.Color;

public class Ball {
    int width;
    int height;
    Point position;
    Color color;

    int x_direction;
    int y_direction;

    public Ball(int width, int height, Point position, Color color){
        this.width = width;
        this.height = height;
        this.position = position;
        this.color = color;
        x_direction = 1;
        y_direction = 1;
    }

}
