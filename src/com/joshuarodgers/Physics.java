package com.joshuarodgers;

import java.awt.Panel;

public class Physics {
    Paddle left;
    Paddle right;
    Ball ball;
    Panel game_surface;

    int ball_speed_x;
    int ball_speed_y;

    int paddle_speed;
    boolean left_moving_up;
    boolean left_moving_down;
    boolean right_moving_up;
    boolean right_moving_down;

    public Physics(Paddle left, Paddle right, Ball ball, Panel game_surface){
        this.left = left;
        this.right = right;
        this.ball = ball;
        this.game_surface = game_surface;

        paddle_speed = 10;
        ball_speed_x = 7;
        
    }

    public void move_paddle(int direction){
        switch(direction){
            case 0: //UP
                if(left.position.y >= 0){
                    left.direction = -1;
                }else{
                    left.direction = 0;
                }
                break;
            case 1: //down
                if(left.position.y + left.height <= game_surface.getHeight()){
                    left.direction = 1;
                }else{
                    left.direction = 0;
                }
                break;
            case 2:
                if(right.position.y >= 0){
                    right.direction = -1;
                }else{
                    right.direction = 0;
                }
                break;
            case 3:
                if(right.position.y + right.height <= game_surface.getHeight()){
                    right.direction = 1;
                }else{
                    right.direction = 0;
                }
                break;
        }
        
    }

    public void update(){
        ball.position.x += ball_speed_x * ball.x_direction;
        ball.position.y += ball_speed_y * ball.y_direction;
        if(left_moving_up){
            move_paddle(0);
            left.position.y += paddle_speed * left.direction;
        }
        if(left_moving_down){
            move_paddle(1);
            left.position.y += paddle_speed * left.direction;
        }
        if(right_moving_up){
            move_paddle(2);
            right.position.y += paddle_speed * right.direction;
        }
        if(right_moving_down){
            move_paddle(3);
            right.position.y += paddle_speed * right.direction;
        }
    }
}