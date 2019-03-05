package edu.pooh.bird_view_shooter;

import java.awt.*;

public class Wizard extends GameObject {

    Controller controller;

    public Wizard(int x, int y, ID id, Controller controller) {
        super(x, y, id);
        this.controller = controller;
    } // **** end Wizard(int, int, ID) constructor ****

    @Override
    public void tick() {
        x += velX;
        y += velY;

        // MOVEMENT
        if (controller.isUp()) {
            velY = -5;
        } else if (!controller.isDown()) {
            velY = 0;
        }

        if (controller.isDown()) {
            velY = 5;
        } else if (!controller.isUp()) {
            velY = 0;
        }

        if (controller.isRight()) {
            velX = 5;
        } else if (!controller.isLeft()) {
            velX = 0;
        }

        if (controller.isLeft()) {
            velX = -5;
        } else if (!controller.isRight()) {
            velX = 0;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 32, 48);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 48);
    }

} // **** end Wizard class ****