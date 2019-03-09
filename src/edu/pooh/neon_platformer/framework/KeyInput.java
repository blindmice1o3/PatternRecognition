package edu.pooh.neon_platformer.framework;

import edu.pooh.neon_platformer.window.Handler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    } // **** end KeyInput(Handler) constructor ****

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ObjectId.PLAYER) {
                if (key == KeyEvent.VK_D) { tempObject.setVelX(5); }
                if (key == KeyEvent.VK_A) { tempObject.setVelX(-5); }
            }
        }

        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ObjectId.PLAYER) {
                if (key == KeyEvent.VK_D) { tempObject.setVelX(0); }
                if (key == KeyEvent.VK_A) { tempObject.setVelX(0); }
            }
        }
    }

} // **** end KeyInput class ****