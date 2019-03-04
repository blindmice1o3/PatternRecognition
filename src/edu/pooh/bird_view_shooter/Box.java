package edu.pooh.bird_view_shooter;

import java.awt.*;

public class Box extends GameObject {

    public Box(int x, int y) {
        super(x, y);

        velX = 1;
    } // **** end Box(int, int) constructor ****

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

} // **** end Box class ****