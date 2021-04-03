package com.joshuarodgers;

import java.awt.Panel;
import java.util.Random;

public class Collision {
    Panel game_window;
    Paddle left;
    Paddle right;
    Ball ball;
    Physics physics;
    Random random;

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
        random = new Random();
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
                    //physics.ball_speed_x = random.nextInt(20);
                    physics.ball_speed_y = random.nextInt(40);
                    return;
                }
            }
        }
        if(ball.position.x >= right.position.x){
            if(ball.position.y >= right.position.y){
                if(ball.position.y <= right.position.y + right.height){
                    ball.x_direction = -1;
                    //physics.ball_speed_x = random.nextInt(20);
                    physics.ball_speed_y = random.nextInt(40);
                    return;
                }
            }
        }
        if(ball.position.x <= west){
            ball.position.x = game_window.getWidth() / 2;
            ball.position.y = game_window.getHeight() /2;
            right.score++;
            return;
        }
        if(ball.position.x + ball.width >= east){
            ball.position.x = game_window.getWidth() / 2;
            ball.position.y = game_window.getHeight() /2;
            left.score++;
            return;
        }
        if(ball.position.y <= north){
            ball.y_direction = 1;
            return;
        }
        if(ball.position.y + ball.height >= south){
            ball.y_direction = -1;
            return;
        }
    }


}