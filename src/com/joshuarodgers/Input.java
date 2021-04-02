package com.joshuarodgers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Input extends KeyAdapter {
    Pong game;
    public Input(Pong game){
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int pressed = e.getKeyCode();
        System.out.println("down");
        switch(pressed){
            case 87: // p1 Up 'W'
                game.left_paddle.direction = -1;
                break;

            case 83: // p1 down 'S'
                game.left_paddle.direction = 1;
                break;

            case 38: // p2 up 'up arrow'
                game.right_paddle.direction = -1;
                break;

            case 40: // p2 down 'down arrow'
                game.right_paddle.direction = -1;
                break;

            default:
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int released = e.getKeyCode();
        System.out.println("up");
        switch(released){
            case 87: // p1 Up 'W'
                game.left_paddle.direction = 0;
                break;

            case 83: // p1 down 'S'
                game.left_paddle.direction = 0;
                break;

            case 38: // p2 up 'up arrow'
                game.right_paddle.direction = 0;
                break;

            case 40: // p2 down 'down arrow'
                game.right_paddle.direction = 0;
                break;

            default:
        }
    }
}
