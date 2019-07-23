package edu.pooh.wave_arcade.main;

import java.awt.*;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    public Game() {
        new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);
    } // **** end Game() constructor ****

    public synchronized void start() {

    }

    public void run() {

    }

    public static void main(String[] args) {
        new Game();
    }

} // **** end Game class ****