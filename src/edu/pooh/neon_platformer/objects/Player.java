package edu.pooh.neon_platformer.objects;

import edu.pooh.neon_platformer.framework.GameObject;
import edu.pooh.neon_platformer.framework.ObjectId;

import java.awt.*;
import java.util.LinkedList;

public class Player extends GameObject {

    private float width = 48;
    private float height = 96;

    private float gravity = 0.5f;
    private final float MAX_SPEED = 10;

    public Player(float x, float y, ObjectId id) {
        super(x, y, id);
    } // **** end Player(float, float, ObjectId) constructor ****

    @Override
    public void tick(LinkedList<GameObject> object) {
        x += velX;
        //y += velY;

        if (falling || jumping) {
            velY += gravity;

            // Player falls faster the longer it's been falling.
            // something to control the velocity
            if (velY > MAX_SPEED) {
                velY = MAX_SPEED;
            }
        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect((int)x, (int)y, (int)width, (int)height);

        Graphics2D g2d = (Graphics2D)g;
        g.setColor(Color.RED);
        g2d.draw(getBounds());
        g2d.draw(getBoundsRight());
        g2d.draw(getBoundsLeft());
        g2d.draw(getBoundsTop());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)(x+(width/4)), (int)(y+(height/2)), (int)width/2, (int)height/2);
    }

    public Rectangle getBoundsTop() {
        return new Rectangle((int)(x+(width/4)), (int)y, (int)width/2, (int)height/2);
    }

    public Rectangle getBoundsRight() {
        return new Rectangle((int)(x+(width-5)), (int)y+5, (int)5, (int)height-10);
    }

    public Rectangle getBoundsLeft() {
        return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
    }

} // **** end Player class ****