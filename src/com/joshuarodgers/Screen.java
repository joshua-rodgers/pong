package com.joshuarodgers;

import java.awt.Panel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Screen {
    Panel game_surface;
    Graphics ctx;
    Color message_color;
    Font message_font;



    public Screen(Panel game_surface, Graphics ctx){
        this.game_surface = game_surface;
        this.ctx = ctx;
        message_color = Color.GREEN;
        message_font = new Font("SANS_SERIF", 0, 48);
    }

    public void display(String message){
        ctx.setColor(message_color);
        ctx.drawString(message, game_surface.getWidth() / (message.length() / 2), game_surface.getHeight() / 2);
    }
}