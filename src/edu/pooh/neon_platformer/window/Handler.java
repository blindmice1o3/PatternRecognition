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
        for (int xx = 0; xx < Game.WIDTH+32; xx += 32) {
            addObject(new Block(xx, Game.HEIGHT-64, ObjectId.BLOCK));
        }
    }

} // **** end Handler class ****