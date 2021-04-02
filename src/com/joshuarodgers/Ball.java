package com.joshuarodgers;

import java.awt.Point;
import java.awt.Color;

public class Ball {
    int width;
    int height;
    Point position;
    Color color;

    public Ball(int width, int height, Point position, Color color){
        this.width = width;
        this.height = height;
        this.position = position;
        this.color = color;
    }

}
