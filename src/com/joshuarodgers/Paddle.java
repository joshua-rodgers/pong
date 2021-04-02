package com.joshuarodgers;

import java.awt.Point;
import java.awt.Color;

public class Paddle {
    int width;
    int height;

    Point position;
    Color color;

    public Paddle(int width, int height, Point position, Color color){
        this.width = width;
        this.height = height; 
        this.color = color;

        this.position = position;
    }

    

}
