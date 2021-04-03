package com.joshuarodgers; 

import java.awt.Frame;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Pong{
    final int window_width = 500;
    final int window_height = 500;

    Frame game_window;
    Panel game_surface;
    Input game_input;
    Physics physics;
    Collision collision;
    Color background_color;

    Paddle left_paddle;
    Paddle right_paddle;
    int paddle_width;
    int paddle_height;
    Point right_paddle_start_position;
    Point left_paddle_start_position;
    Color paddle_color;
    boolean is_running;
    boolean is_paused;

    Ball game_ball;
    int ball_width;
    int ball_height;
    Point ball_start_position;
    Color ball_color;

    int score_player_one;

    Graphics ctx_game_surface;

    public Pong(){
        init_window();
        init_game_objects();
        init_graphics();
    }

    private void init_window(){
        game_window = new Frame();
        game_window.setSize(window_width, window_height);
        game_surface = new Panel();
        game_surface.setPreferredSize(game_window.getSize());
        game_input = new Input(this);
        game_window.add(game_surface);
        game_window.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        game_window.addKeyListener(game_input);
        background_color = Color.BLACK;
        game_window.setBackground(background_color);
        game_window.pack();
        game_window.setVisible(true);
    }

    private void init_game_objects(){
        paddle_height = 100;
        paddle_width = 10;
        left_paddle_start_position = new Point(paddle_width / 2, game_surface.getHeight() / 2 - (paddle_height /2));
        right_paddle_start_position = new Point(game_surface.getWidth() - (paddle_width + (paddle_width / 2)), game_surface.getHeight() / 2 - (paddle_height /2 ));
        paddle_color = Color.WHITE;
        right_paddle = new Paddle(paddle_width, paddle_height, right_paddle_start_position, paddle_color);
        left_paddle = new Paddle(paddle_width, paddle_height, left_paddle_start_position, paddle_color);
        ball_width = 5;
        ball_height = 10;
        ball_color = Color.GREEN;
        ball_start_position = new Point((game_surface.getWidth() / 2) - (ball_width / 2), (game_surface.getHeight() / 2) - (ball_height / 2));
        game_ball = new Ball(ball_width, ball_height, ball_start_position, ball_color);

        physics = new Physics(left_paddle, right_paddle, game_ball, game_surface);
        collision = new Collision(game_surface, left_paddle, right_paddle, game_ball, physics);

    }

    public void init_graphics(){
        ctx_game_surface = game_surface.getGraphics();
        ctx_game_surface.setFont(new Font("SANS_SERIF", 0, 36));
    }

    public void render(){
        ctx_game_surface.clearRect(0, 0, game_surface.getWidth(), game_surface.getHeight());
        ctx_game_surface.setColor(Color.WHITE);
        ctx_game_surface.drawLine(game_surface.getWidth() / 2, 0, game_surface.getWidth() / 2, game_surface.getHeight());
        ctx_game_surface.setColor(game_ball.color); 
        ctx_game_surface.fillRect(game_ball.position.x, game_ball.position.y, game_ball.width, game_ball.height);
        ctx_game_surface.setColor(paddle_color);
        ctx_game_surface.fillRect(right_paddle.position.x, right_paddle.position.y, right_paddle.width, right_paddle.height);
        ctx_game_surface.fillRect(left_paddle.position.x, left_paddle.position.y, left_paddle.width, left_paddle.height);
        ctx_game_surface.drawString(String.valueOf(left_paddle.score), window_width / 4, window_height / 4);
        ctx_game_surface.drawString(String.valueOf(right_paddle.score), (window_width / 4) + (window_width / 2), window_height / 4);
    }

    public void run(){
        is_running = true;
        while(is_running){
            if(!is_paused){
                try{
                    physics.update();
                    collision.check_collision();
                    render();
                    Thread.sleep(1000/30);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                try{
                    render();
                    Thread.sleep(500);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        Pong game = new Pong();
        game.run();
    }
}

