package edu.pooh.bird_view_shooter;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

    private boolean isRunning = false;
    private Thread thread;
    private Controller controller;
    private Camera camera;
    private SpriteSheet spriteSheet;

    private BufferedImage level = null;
    private BufferedImage imageSpriteSheet = null;
    private BufferedImage imageFloor = null;             // Background use to be red, now it's a cropped BufferedImage.

    // Related to Ammo Crates. The player will now have a limited supply of bullets, starting at 100.
    public int ammo = 100; // Anytime we create a bullet object in MouseInput, this decrements.

    public Game() {
        new Window(1000, 563, "Wizard Game", this);
        start();

        controller = new Controller();
        camera = new Camera(0, 0);
        this.addKeyListener(new KeyInput(controller));

        level = BufferedImageLoader.loadImage("/wizard_level.png");
        imageSpriteSheet = BufferedImageLoader.loadImage("/NES - Super Mario Bros 3 - Battle Mini Game.png");

        // Only AFTER we load our image!!! Otherwise imageSpriteSheet is null.
        spriteSheet = new SpriteSheet(imageSpriteSheet);    // GameObject constructor will use SpriteSheet object.

        imageFloor = spriteSheet.grabImage(81, 146, 15, 15);

        // Since MouseInput constructor now takes a SpriteSheet, we moved this line to be after SpriteSheet instantiation.
        this.addMouseListener(new MouseInput(controller, camera, this, spriteSheet));

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

        // translate(int, int) changes the coordinate system to use the arguments as the g2d's new origin (0, 0).
        g2d.translate(-camera.getX(), -camera.getY());  // Everything between the g2d.translate()

        // Nested for-loop to draw the floor image.
        for (int xx = 0; xx < 30*72; xx += 32) { // +=32 because that's the size of floor's width
            for (int yy = 0; yy < 30*72; yy += 32) { // RealTutsGML said the 30*72 is "what worked before".
                g.drawImage(imageFloor, xx, yy, 32, 32, null);
            }
        }

        controller.render(g);

        g2d.translate(camera.getX(), camera.getY());    // Everything between the g2d.translate()

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
                    controller.addObject(new Block(xx*32, yy*32, ID.Block, spriteSheet));
                }
                if (blue == 255 && green == 0) {    // Added && green==0 because started using CYAN.
                    controller.addObject(new Wizard(xx*32, yy*32, ID.Player, controller, this, spriteSheet));
                }   // Passing Game game because player needs access to the int ammo from Game class.

                if (green == 255 && blue == 0) {    // Added && blue==0 because started using CYAN.
                    controller.addObject(new Enemy(xx*32, yy*32, ID.Enemy, controller, spriteSheet));
                }

                if (green == 255 && blue == 255) {  // If CYAN... instantiate a Crate for ammo.
                    controller.addObject(new Crate(xx*32, yy*32, ID.Crate, spriteSheet)); // Wizard class for picking up.
                }
            }
        }
    }

    public static void main(String[] args) {
        new Game();
    }

} // **** end Game class ****