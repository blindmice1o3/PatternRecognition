package edu.pooh.bird_view_shooter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends GameObject {

    Controller controller;
    Random r = new Random();
    int choose = 0;
    int hp = 100;

    private BufferedImage imageEnemy;

    public Enemy(int x, int y, ID id, Controller controller, SpriteSheet spriteSheet) {
        super(x, y, id, spriteSheet);
        this.controller = controller;

        imageEnemy = spriteSheet.grabImage(123, 44, 16, 16);
    } // **** end Enemy(int, int, ID, Controller) constructor ****

    @Override
    public void tick() {
        x += velX;
        y += velY;

        // Every tick() will assign a random int between 0-9 to the choose variable.
        // We can do something like: if it's 0, we want to move in another direction.
        choose = r.nextInt(10);


        for (int i = 0; i < controller.object.size(); i++) {

            GameObject tempObject = controller.object.get(i);

            // COLLISION with blocks. If they collide with a block, choose another direction.
            if (tempObject.getId() == ID.Block) {
                // Course correct if collide with wall. Ricochet the enemy off the wall.
                if(getBoundsBig().intersects(tempObject.getBounds())) {
                    // Shoots the enemy back in OPPOSITE direction at DOUBLE THE SPEED.
                    x += (velX * 5) * -1;
                    y += (velX * 5) * -1;
                    velX *= -1;
                    velY *= -1;

                }
                // An algorithm for a number between -4 and 4. To change direction in normal manner
                else if (choose == 0) {
                    velX = (r.nextInt(4 - -4) + -4);    // Seems like it's actually -4 and 3... since r.nextInt(8)
                    velY = (r.nextInt(4 - -4) + -4);    // should return an int between 0-7... then minus 4 => -4 to 3
                    //System.out.println(velX + ", " + velY);   // To see the algorithm's output.
                }

            }

            // COLLISION with bullets.
            if (tempObject.getId() == ID.Bullet) {
                 if(getBounds().intersects(tempObject.getBounds())) {
                     hp -= 50;  // Will take 2 bullet hits to kill enemy.
                     controller.removeObject(tempObject);   // If bullet hits enemy, remove bullet from game.
                 }
            }

            // Check to remove this enemy if its hp is 0 or less.
            if (hp <= 0) { controller.removeObject(this); }
        }



    }

    @Override
    public void render(Graphics g) {
        //g.setColor(Color.YELLOW);
        //g.fillRect(x, y, 32, 32);

        g.drawImage(imageEnemy, x, y, 32, 32, null);

        // To see the larger bounding box (the getBoundsBig() method).
        //Graphics2D g2d = (Graphics2D)g;
        //g.setColor(Color.GREEN);
        //g2d.draw(getBoundsBig());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    /*
     * NOT overriding the getBounds() method because we still want that
     * for the collision with bullets (instead of wall).
     */
    // Starting 16 pixels BEFORE the top left corner of this Enemy object.
    // And 32 pixels LARGER than it's normal width and height (originally 32).
    public Rectangle getBoundsBig() {
        return new Rectangle(x-16, y-16, 64, 64);
    }

} // **** end Enemy class ****