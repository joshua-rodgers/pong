package com.joshuarodgers;

import java.util.Random;

public class Collision {
    Pong game;
    Paddle left;
    Paddle right;
    Ball ball;
    Physics physics;
    Random random;

    int north;
    int south;
    int east;
    int west;

    public Collision(Pong game, Paddle left, Paddle right, Ball ball, Physics physics){
        this.physics = physics;
        this.ball = ball;
        this.game = game;
        this.left = left;
        this.right = right;
        random = new Random();
        north = 0;
        south = this.game.game_window.getHeight();
        east = this.game.game_window.getWidth();
        west = 0;
    }

    public void check_collision(){
        // CHECK PADDLES FIRST SINCE THEY ARE IN FRONT OF E&W EDGES
        if(ball.position.x <= left.position.x + left.width){
            if(ball.position.y >= left.position.y){
                if(ball.position.y <= left.position.y + left.height){
                    ball.x_direction = 1;
                    physics.ball_speed_y = random.nextInt(10);
                    
                }
            }
        }else if(ball.position.x >= right.position.x){
            if(ball.position.y >= right.position.y){
                if(ball.position.y <= right.position.y + right.height){
                    ball.x_direction = -1;
                    physics.ball_speed_y = random.nextInt(10);
                    
                }
            }
        }
        // CHECK EDGES
        if(ball.position.x <= west){
            ball.position.x = game.game_window.getWidth() / 2;
            ball.position.y = game.game_window.getHeight() / 2;
            physics.ball_speed_y = 0;
            right.score++;
            if(right.score == 10){
                game.winner();
            }
        }else if(ball.position.x + ball.width >= east){
            ball.position.x = game.game_window.getWidth() / 2;
            ball.position.y = game.game_window.getHeight() / 2;
            physics.ball_speed_y = 0;
            left.score++;
            if(left.score == 10){
                game.winner();
            }
        }else if(ball.position.y <= north){
            ball.y_direction = 1;
        }else if(ball.position.y + ball.height >= south){
            ball.y_direction = -1;
        }
    }
}