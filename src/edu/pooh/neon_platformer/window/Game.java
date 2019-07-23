package edu.pooh.neon_platformer.window;

import edu.pooh.neon_platformer.framework.KeyInput;
import edu.pooh.neon_platformer.framework.ObjectId;
import edu.pooh.neon_platformer.framework.Texture;
import edu.pooh.neon_platformer.objects.Block;
import edu.pooh.neon_platformer.objects.Player;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    private boolean running = false;
    private Thread thread;

    public static int WIDTH, HEIGHT;

    private BufferedImage level = null;

    // Objects
    Handler handler;
    Camera camera;
    static Texture texture;

    Random rand = new Random();

    private void init() {
        WIDTH = getWidth();
        HEIGHT = getHeight();

        texture = new Texture();

        BufferedImageLoader loader = new BufferedImageLoader();
        level = loader.loadImage("/wizard_level.png"); //loading the level

        handler = new Handler();

        camera = new Camera(0, 0);

        loadImageLevel(level);
        //handler.addObject(new Player(100, 100, handler, ObjectId.PLAYER));
        //handler.createLevel();

        this.addKeyListener(new KeyInput(handler));
    }

    public synchronized void start() {
        if (running) {
            return;
        }

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {


        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;init();
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames + "   TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    private void tick() {
        handler.tick();

        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getId() == ObjectId.PLAYER) {
                camera.tick(handler.object.get(i));
            }
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D)g;
        ///////////////////////////////////////////////
        // Draw here.
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());


        g2d.translate(camera.getX(), camera.getY());    //Begin of camera.

        handler.render(g);

        g2d.translate(-camera.getX(), -camera.getY());  //End of camera.
        ///////////////////////////////////////////////
        g.dispose();
        bs.show();

    }

    private void loadImageLevel(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();

        System.out.println("width, height: " + w + " " + h);

        for (int xx = 0; xx < h; xx++) {
            for (int yy = 0; yy < w; yy++) {
                int pixel = image.getRGB(xx, yy);
                // Don't know how the following works, he doesn't want to confuse us, just copy and pasting code.
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;


                if (red == 255 && green == 0 && blue == 0) {
                    handler.addObject(new Block(xx*32, yy*32, 0, ObjectId.BLOCK));
                }
                if (red == 0 && green == 0 && blue == 255) {
                    handler.addObject(new Player(xx*32, yy*32, handler, ObjectId.PLAYER));
                }
           }
        }
    }

    public static Texture getInstance() {
        return texture;
    }

    public static void main(String[] args) {
        new Window(800, 600, "Neon Platform Game Prototype", new Game());
    }

} // **** end Game class ****