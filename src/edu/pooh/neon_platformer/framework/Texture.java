package edu.pooh.neon_platformer.framework;

import edu.pooh.neon_platformer.window.BufferedImageLoader;

import java.awt.image.BufferedImage;

public class Texture {

    SpriteSheet bs;
    SpriteSheet ps;
    private BufferedImage blockSheet = null;
    private BufferedImage playerSheet = null;

    public BufferedImage[] block = new BufferedImage[2];
    public BufferedImage[] player = new BufferedImage[1];

    public Texture() {

        BufferedImageLoader loader = new BufferedImageLoader();
        try {
            blockSheet = loader.loadImage("/NES - Super Mario Bros 3 - Battle Mini Game.png");
            playerSheet = loader.loadImage("/NES - Super Mario Bros 3 - Battle Mini Game.png");
        } catch (Exception e) {
            e.printStackTrace();
        }


        bs = new SpriteSheet(blockSheet);
        ps = new SpriteSheet(playerSheet);


        getTextures();

    } // **** end Texture() constructor ****

    private void getTextures() {
        block[0] = bs.grabImage(5, 8, 16, 16);  //dirt block
        block[1] = bs.grabImage(6, 2, 16, 16);  //grass block

        player[0] = ps.grabImage(2, 2, 16, 16); //idle frame for player
    }

} // **** end Texture class ****