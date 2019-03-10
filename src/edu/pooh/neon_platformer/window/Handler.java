package edu.pooh.neon_platformer.window;

import edu.pooh.neon_platformer.framework.GameObject;
import edu.pooh.neon_platformer.framework.ObjectId;
import edu.pooh.neon_platformer.objects.Block;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    public LinkedList<GameObject> object = new LinkedList<GameObject>();

    private GameObject tempObject;

    public Handler() {

    } // **** end Handler() constructor ****

    // Call all GameObject instances' tick() method.
    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            tempObject = object.get(i);

            tempObject.tick(object); // Inside GameObject class, its tick() has parameter LinkedList<GameObject>.
        }
    }

    // Call all GameObject instances' render(Graphics) method.
    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        // Using "this" because our LinkedList is named the same as our parameter (local scope dominant).
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

    public void createLevel() {
        //Vertical left
        for (int yy = 0; yy < Game.HEIGHT+32; yy += 32) {
            addObject(new Block(0, yy, ObjectId.BLOCK));
        }

        //Horizontal bottom (full floor)
        for (int xx = 0; xx < Game.WIDTH*2; xx += 32) {
            addObject(new Block(xx, Game.HEIGHT-32, ObjectId.BLOCK));
        }
        //Horizontal middle
        for (int xx = 200; xx < 600; xx += 32) {
            addObject(new Block(xx, 400, ObjectId.BLOCK));
        }
    }

} // **** end Handler class ****