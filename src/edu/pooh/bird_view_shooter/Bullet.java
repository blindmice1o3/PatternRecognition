package edu.pooh.bird_view_shooter;

import java.awt.*;

public class Bullet extends GameObject {

    private Controller controller;

    public Bullet(int x, int y, ID id, Controller controller, int mx, int my) {
        super(x, y, id);
        this.controller = controller;

        // mx and my come from MouseInput's mousePressed(MouseEvent). The direction the Bullet should travel.
        velX = (mx - x) / 10; // The divide 10 is like the total travel time... the speed from which it's going.
        velY = (my - y) / 10;
    } // **** end Bullet(int, int, ID, Controller) constructor ****

    @Override
    public void tick() {
        x += velX;
        y += velY;

        // COLLISION so the bullets won't shoot through walls.
        for (int i = 0; i < controller.object.size(); i++) {
            GameObject tempObject = controller.object.get(i);

            if (tempObject.getId() == ID.Block) {
                if (getBounds().intersects(tempObject.getBounds())) {   // If this bullet collides with wall (Block),
                    controller.removeObject(this);           // simply remove it from the game.
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(x, y, 8, 8);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 8, 8);
    }

} // **** end Bullet class ****