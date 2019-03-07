package edu.pooh.bird_view_shooter;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Block extends GameObject {

    private BufferedImage imageBlock;

    public Block(int x, int y, ID id, SpriteSheet spriteSheet) {
        super(x, y, id, spriteSheet);

        imageBlock = spriteSheet.grabImage(99, 146, 15, 16);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        //g.setColor(Color.BLACK);
        //g.fillRect(x, y, 32, 32);
        g.drawImage(imageBlock, x, y, 32, 32, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

} // **** end Block class ****