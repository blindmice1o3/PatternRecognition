package edu.pooh.evo_side_scroller;

import java.awt.image.BufferedImage;

/**
 * Created by jgov on 7/22/2019.
 */
public class Assets {
    public static BufferedImage mapAndChapterSpriteSheet;

    public static void initAssets() {
        mapAndChapterSpriteSheet = Utils.loadImage("/sprite sheet - EVO Search for Eden/SNES - EVO Search for Eden - Maps & Chapter Images.png");
    }
}