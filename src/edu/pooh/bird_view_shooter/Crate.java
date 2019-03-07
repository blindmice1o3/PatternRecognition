package edu.pooh.bird_view_shooter;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Crate extends GameObject {

    private BufferedImage imageCrate;

    public Crate(int x, int y, ID id, SpriteSheet spriteSheet) {
        super(x, y, id, spriteSheet);

        imageCrate = spriteSheet.grabImage(70, 108, 14, 16);
    } // **** end Crate(int, int, ID) constructor ****

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        //g.setColor(Color.CYAN); // Color.CYAN => GREEN == 255 && BLUE == 255
        //g.fillRect(x, y, 32, 32);

        g.drawImage(imageCrate, x, y, 32, 32, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

} // **** end Crate class ****