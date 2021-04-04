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
    int quarter;

    public Paddle(int width, int height, Point position, Color color){
        this.width = width;
        this.height = height; 
        this.quarter = height / 4;
        this.color = color;

        this.position = position;
        direction = 0;
        score = 0;
    }

    public int get_segment(int segment){
        int out = 0;
        switch(segment){
            case 1:
                out = position.y + quarter;
                break;
            case 2:
                out = position.y + (quarter * 2);
                break;
            case 3:
                out = position.y +  (quarter * 3);
                break;
            case 4:
                out = position.y + (quarter * 4);
                break;
        }
        return out;
    }

}
