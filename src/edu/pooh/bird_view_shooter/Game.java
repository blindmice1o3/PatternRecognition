package edu.pooh.bird_view_shooter;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

    private boolean isRunning = false;
    private Thread thread;
    private Controller controller;
    private Camera camera;

    private BufferedImage level = null;

    public Game() {
        new Window(1000, 563, "Wizard Game", this);
        start();

        controller = new Controller();
        camera = new Camera(0, 0);
        this.addKeyListener(new KeyInput(controller));
        this.addMouseListener(new MouseInput(controller, camera));

        BufferedImageLoader loader = new BufferedImageLoader();
        level = loader.loadImage("/wizard_level.png");

        //controller.addObject(new Wizard(100, 100, ID.Player, controller));
        loadLevel(level);
    } // **** end Game() constructor ****

    private void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    private void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                tick();                 // ****TICK****
                delta--;
            }

            render();                   // ****RENDER****
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    public void tick() {

        // Loop through all GameObject objects stored in controller's LinkedList<GameObject> to find the player.
        // Call the player's tick(GameObject) method, which uses the player's coordinate.
        for (int i = 0; i < controller.object.size(); i++) {
            if (controller.object.get(i).getId() == ID.Player) {
                camera.tick(controller.object.get(i));
            }
        }

        //////////////////////////////////

        controller.tick();

        //////////////////////////////////

    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D)g;
        /////////////////////////////////////////////

        g.setColor(Color.RED);
        g.fillRect(0, 0, 1000, 563);

        g2d.translate(-camera.getX(), -camera.getY());              // Everything between the g2d.translate()

        controller.render(g);

        g2d.translate(camera.getX(), camera.getY());                // Everything between the g2d.translate()

        /////////////////////////////////////////////
        g.dispose();

        bs.show();
    }

    // Loading the level.
    private void loadLevel(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();

        for (int xx = 0; xx < w; xx++) {
            for (int yy = 0; yy < h; yy++) {
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;     // & is the bit operator??? what's '>>'???
                int green = (pixel >> 8) & 0xff;    // looks like using hex-decimal???
                int blue = (pixel) & 0xff;          // 16, 8, 0... "goes down by this square here"???

                if (red == 255) {
                    controller.addObject(new Block(xx*32, yy*32, ID.Block));
                }
                if (blue == 255) {
                    controller.addObject(new Wizard(xx*32, yy*32, ID.Player, controller));
                }

                if (green == 255) {
                    controller.addObject(new Enemy(xx*32, yy*32, ID.Enemy, controller));
                }
            }
        }
    }

    public static void main(String[] args) {
        new Game();
    }

} // **** end Game class ****