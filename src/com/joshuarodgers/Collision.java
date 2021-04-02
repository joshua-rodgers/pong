package com.joshuarodgers;

import java.awt.Frame;

public class Collision {
    Frame game_window;
    Paddle left;
    Paddle right;
    Ball ball;
    Physics physics;

    int north;
    int south;
    int east;
    int west;

    public Collision(Frame game_window, Paddle left, Paddle right, Ball ball, Physics physics){
        this.physics = physics;
        this.ball = ball;
        this.game_window = game_window;
        this.left = left;
        this.right = right;
        north = 0;
        south = this.game_window.getHeight();
        east = this.game_window.getWidth();
        west = 0;
    }

    public void check_collision(){
        if(ball.position.x <= west){
            ball.x_direction = 1;
        }
        if(ball.position.x >= east){
            ball.x_direction = -1;
        }
        if(ball.position.y <= north){
            ball.y_direction = 1;
        }
        if(ball.position.y >= south){
            ball.y_direction = -1;
        }
    }


}