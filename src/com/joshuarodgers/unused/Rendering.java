package com.joshuarodgers;

import java.awt.Color;

public class Rendering implements Runnable{
    Pong game;

    public Rendering(Pong game){
        this.game = game;
    }

    public void render(){
        game.ctx_game_surface.clearRect(0, 0, game.game_surface.getWidth(), game.game_surface.getHeight());
        game.ctx_game_surface.setColor(Color.WHITE);
        game.ctx_game_surface.drawLine(game.game_surface.getWidth() / 2, 0, game.game_surface.getWidth() / 2, game.game_surface.getHeight());
        game.ctx_game_surface.setColor(game.game_ball.color); 
        game.ctx_game_surface.fillRect(game.game_ball.position.x, game.game_ball.position.y, game.game_ball.width, game.game_ball.height);
        game.ctx_game_surface.setColor(game.paddle_color);
        game.ctx_game_surface.fillRect(game.right_paddle.position.x, game.right_paddle.position.y, game.right_paddle.width, game.right_paddle.height);
        game.ctx_game_surface.fillRect(game.left_paddle.position.x, game.left_paddle.position.y, game.left_paddle.width, game.left_paddle.height);
        game.ctx_game_surface.drawString(String.valueOf(game.left_paddle.score), game.window_width / 4, game.window_height / 4);
        game.ctx_game_surface.drawString(String.valueOf(game.right_paddle.score), (game.window_width / 4) + (game.window_width / 2), game.window_height / 4);
    }

    @Override
    public void run() {
        while(true){
            try{
                render();
                Thread.sleep(1000/30);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}