package edu.pooh.evo_side_scroller;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by jgov on 7/22/2019.
 */
public class Utils {

    public static BufferedImage loadImage(String path) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(Utils.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

}