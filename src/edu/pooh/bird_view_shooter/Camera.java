package edu.pooh.bird_view_shooter;

public class Camera {

    private float x;
    private float y;

    public Camera(float x, float y) {
        this.x = x;
        this.y = y;
    } // **** end Camera(float, float) constructor

    public void tick(GameObject object) {
        // Player's x minus GameCamera's x minus half the screen (so player will be centered).
        // This is used in Game's render() method's g2d's translate(int, int) call.
        x += ((object.getX() - x) - 1000/2) * 0.05f;    // Game's render() uses Camera's x and y for its
        y += ((object.getY() - y) - 563/2) * 0.05f;     // g2d's translate(int, int) method call.

        if (x <= 0) { x = 0; }
        if (x >= 1000 + 32) { x = 1032; }
        if (y <= 0) { y = 0; }
        if (y >= 563 + 48) { y = 563 + 48; }

    }

    // GETTER & SETTERS
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

} // **** end Camera class ****