package edu.pooh.neon_platformer.window;

import edu.pooh.neon_platformer.framework.ObjectId;
import edu.pooh.neon_platformer.objects.Block;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    private boolean running = false;
    private Thread thread;

    public static int WIDTH, HEIGHT;

    // Objects
    Handler handler;

    Random rand = new Random();

    private void init() {
        WIDTH = getWidth();
        HEIGHT = getHeight();

        handler = new Handler();

        handler.createLevel();
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
        init();

        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
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
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        ///////////////////////////////////////////////
        // Draw here.
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        handler.render(g);
        ///////////////////////////////////////////////
        g.dispose();
        bs.show();

    }

    public static void main(String[] args) {
        new Window(800, 600, "Neon Platform Game Prototype", new Game());
    }

} // **** end Game class ****