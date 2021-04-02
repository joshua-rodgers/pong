package com.joshuarodgers;

public class Physics {
    Paddle left;
    Paddle right;
    Ball ball;

    int ball_speed_x;
    int ball_speed_y;

    int paddle_speed;



    public Physics(Paddle left, Paddle right, Ball ball){
        this.left = left;
        this.right = right;
        this.ball = ball;

        paddle_speed = 20;
        ball_speed_x = 20;
        ball_speed_y = 10;
    }

    public void update(){
        ball.position.x += ball_speed_x * ball.x_direction;
        ball.position.y += ball_speed_y * ball.y_direction;
        left.position.y += paddle_speed * left.direction;
        right.position.y += paddle_speed * right.direction;
    }
    
}