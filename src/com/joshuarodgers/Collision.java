package com.joshuarodgers;

import java.awt.Panel;

public class Collision {
    Panel game_window;
    Paddle left;
    Paddle right;
    Ball ball;
    Physics physics;

    int north;
    int south;
    int east;
    int west;

    public Collision(Panel game_window, Paddle left, Paddle right, Ball ball, Physics physics){
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
        if(ball.position.x <= left.position.x + left.width){
            if(ball.position.y >= left.position.y){
                if(ball.position.y <= left.position.y + left.height){
                    ball.x_direction = 1;
                }
            }
        }
        if(ball.position.x >= right.position.x){
            if(ball.position.y >= right.position.y){
                if(ball.position.y <= right.position.y + right.height){
                    ball.x_direction = -1;
                }
            }
        }
        if(ball.position.x <= west){
            ball.position.x = game_window.getWidth() / 2;
            ball.position.y = game_window.getHeight() /2;
        }
        if(ball.position.x + ball.width >= east){
            ball.position.x = game_window.getWidth() / 2;
            ball.position.y = game_window.getHeight() /2;
        }
        if(ball.position.y <= north){
            ball.y_direction = 1;
        }
        if(ball.position.y + ball.height >= south){
            ball.y_direction = -1;
        }
    }


}