package edu.pooh.neon_platformer.window;

import edu.pooh.neon_platformer.framework.GameObject;

public class Camera {

    private float x;
    private float y;

    public Camera(float x, float y) {
        this.x = x;
        this.y = y;
    } // **** end Camera(float, float) constructor ****

    public void tick(GameObject player) {
    // "tweaning" algorithm to go here instead of x--.
    //x--;
    x = -player.getX() + Game.WIDTH/2;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

} // **** end Camera class ****