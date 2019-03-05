package edu.pooh.bird_view_shooter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    Controller controller;

    public KeyInput(Controller controller) {
        this.controller = controller;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < controller.object.size(); i++) {
            GameObject tempObject = controller.object.get(i);

            if (tempObject.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) {
                    controller.setUp(true);
                }
                if (key == KeyEvent.VK_S) {
                    controller.setDown(true);
                }
                if (key == KeyEvent.VK_A) {
                    controller.setLeft(true);
                }
                if (key == KeyEvent.VK_D) {
                    controller.setRight(true);
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < controller.object.size(); i++) {
            GameObject tempObject = controller.object.get(i);

            if (tempObject.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) {
                    controller.setUp(false);
                }
                if (key == KeyEvent.VK_S) {
                    controller.setDown(false);
                }
                if (key == KeyEvent.VK_A) {
                    controller.setLeft(false);
                }
                if (key == KeyEvent.VK_D) {
                    controller.setRight(false);
                }
            }
        }
    }

} // **** end KeyInput class ****