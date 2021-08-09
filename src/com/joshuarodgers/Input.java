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
        
        switch(pressed){
            case 87: // p1 Up 'W'
                game.physics.left_moving_up = true;
                break;

            case 83: // p1 down 'S'
                game.physics.left_moving_down = true;
                break;

            case 38: // p2 up 'up arrow'
                game.physics.right_moving_up = true;
                break;

            case 40: // p2 down 'down arrow'
                game.physics.right_moving_down = true;
                break;
            case 32: // SPACEBAR - START
                game.is_started = true;
                break;
            case 80: // P - PAUSE
                game.is_paused = !game.is_paused;
                break;
            case 81: // Q - QUIT
                game.is_running = false;
                break;
            case 82: // R - RESET
                game.reset();
                break;

            default:
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int released = e.getKeyCode();
        //System.out.println("up");
        switch(released){
            case 87: // p1 Up 'W'
                game.physics.left_moving_up = false;
                break;

            case 83: // p1 down 'S'
                game.physics.left_moving_down = false;
                break;

            case 38: // p2 up 'up arrow'
                game.physics.right_moving_up = false;
                break;

            case 40: // p2 down 'down arrow'
                game.physics.right_moving_down = false;
                break;

            default:
        }
    }
}
