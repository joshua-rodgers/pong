package com.joshuarodgers;


import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Screen {
    
    Graphics ctx;
    int width;
    int height;
    Color message_color;
    Font message_font;



    public Screen(int width, int height, Graphics ctx){
        this.width = width;
        this.height = height;
        this.ctx = ctx;
        message_color = Color.GREEN;
        message_font = new Font("SANS_SERIF", 0, 36);
    }

    public void display(String message){
        ctx.setColor(message_color);
        ctx.setFont(message_font);
        ctx.drawString(message, (width / 2) - (message.length() * 10), height / 2);
    }
}