package com.joshuarodgers;

import java.awt.Point;
import java.awt.Color;

public class Paddle {
    int width;
    int height;
    Color color;

    int score;

    Point position;
    int speed;
    int direction;

    public Paddle(int width, int height, Point position, Color color){
        this.width = width;
        this.height = height; 
        this.color = color;

        this.position = position;
        direction = 0;
        score = 0;
    }
}
