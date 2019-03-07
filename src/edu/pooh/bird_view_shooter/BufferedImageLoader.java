package edu.pooh.bird_view_shooter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BufferedImageLoader {

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(BufferedImageLoader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

} // **** end BufferedImageLoader class ****