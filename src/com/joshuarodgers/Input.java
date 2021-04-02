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
        System.out.println("yo!");
    }
}
