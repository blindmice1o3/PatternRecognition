package edu.pooh.neon_platformer.framework;

import java.awt.*;
import java.util.LinkedList;

public abstract class GameObject {

    protected float x;
    protected float y;
    protected ObjectId id;
    protected float velX = 0;
    protected float velY = 0;

    public GameObject(float x, float y, ObjectId id) {
        this.x = x;
        this.y = y;
        this.id = id;
    } // **** end GameObject(float, float, ObjectId) constructor ****

    public abstract void tick(LinkedList<GameObject> object);
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
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

    public ObjectId getId() {
        return id;
    }

} // **** end GameObject class ****