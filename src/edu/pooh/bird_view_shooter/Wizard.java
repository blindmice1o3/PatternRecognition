package edu.pooh.bird_view_shooter;

import java.awt.*;

public class Wizard extends GameObject {

    Controller controller;
    Game game;

    public Wizard(int x, int y, ID id, Controller controller, Game game) {
        super(x, y, id);
        this.controller = controller;
        this.game = game;
    } // **** end Wizard(int, int, ID, Controller) constructor ****

    @Override
    public void tick() {
        x += velX;
        y += velY;

        collision();

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

    private void collision() {
        for (int i = 0; i < controller.object.size(); i++) {

            GameObject tempObject = controller.object.get(i);

            if (tempObject.getId() == ID.Block) {   // COLLISION with Block/wall.
                // If the wizard's Rectangle bounds intersects with the current GameObject's Rectangle's bounds...
                if (getBounds().intersects(tempObject.getBounds())) {
                    x += velX * -1;
                    y += velY * -1;
                }
            }

            if (tempObject.getId() == ID.Crate) {   // COLLISION with Crate/ammo box.
                // If the wizard's Rectangle bounds intersects with the current GameObject's Rectangle's bounds...
                if (getBounds().intersects(tempObject.getBounds())) {
                    game.ammo += 10;    // Adds 10 ammo to the player's supply (started with 100 in Game class).
                    controller.removeObject(tempObject);    // Removes the Crate/ammo box from game world.
                }
            }

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