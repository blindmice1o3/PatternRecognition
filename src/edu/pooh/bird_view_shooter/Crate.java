package edu.pooh.bird_view_shooter;

import java.awt.*;

public class Crate extends GameObject {

    public Crate(int x, int y, ID id) {
        super(x, y, id);
    } // **** end Crate(int, int, ID) constructor ****

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN); // Color.CYAN => GREEN == 255 && BLUE == 255
        g.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

} // **** end Crate class ****