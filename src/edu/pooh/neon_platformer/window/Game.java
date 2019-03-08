package edu.pooh.neon_platformer.window;

import java.awt.*;

public class Game extends Canvas implements Runnable {

    private boolean running = false;
    private Thread thread;

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
        System.out.println("Thread has begun.");
    }

    public static void main(String[] args) {
        new Window(800, 600, "Neon Platform Game Prototype", new Game());
    }

} // **** end Game class ****