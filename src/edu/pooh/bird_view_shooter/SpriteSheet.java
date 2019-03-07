package edu.pooh.bird_view_shooter;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage image;

    public SpriteSheet(BufferedImage image) {
        this.image = image;
    } // **** end SpriteSheet(BufferedImage) constructor ****

    public BufferedImage grabImage(int x, int y, int width, int height) {
        // RealTutsGML used parameters int col, int row, int width, in height.
        // His spritesheet image has 32 by 32 pixeled images.
        //return image.getSubimage((col*32)-32, (row*32)-32, width, height);
        return image.getSubimage(x, y, width, height);
    }

} // **** end SpriteSheet class ****