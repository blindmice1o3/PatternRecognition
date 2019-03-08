package edu.pooh.neon_platformer.objects;

import edu.pooh.neon_platformer.framework.GameObject;
import edu.pooh.neon_platformer.framework.ObjectId;

import java.awt.*;
import java.util.LinkedList;

public class Test extends GameObject {

    public Test(float x, float y, ObjectId id) {
        super(x, y, id);
    } // **** end Test(float, float, ObjectId) constructor

    @Override
    public void tick(LinkedList<GameObject> object) {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public float getVelX() {
        return velX;
    }

    @Override
    public float getVelY() {
        return velY;
    }

    @Override
    public void setVelX(float velX) {
        this.velX = velX;
    }

    @Override
    public void setVelY(float velY) {
        this.velY = velY;
    }

    @Override
    public ObjectId getId() {
        return id;
    }

} // **** end Test class ****