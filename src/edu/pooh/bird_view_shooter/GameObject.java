package edu.pooh.bird_view_shooter;

import java.awt.*;

public abstract class GameObject {

    // Each GameObject-subclass instance will have a position (x, y).
    protected int x;
    protected int y;

    // Speed at which GameObject-subclass instances are going.
    protected float velX = 0;
    protected float velY = 0;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    } // **** end GameObject(int, int) constructor ****

    // All GameObject-subclass will need to update and draw itself.
    // Every GameObject-subclass will also need a Rectangle so we can do collision detection.
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    // GETTERS & SETTERS
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

} // **** end GameObject class ****