package edu.pooh.neon_platformer.objects;

import edu.pooh.neon_platformer.framework.GameObject;
import edu.pooh.neon_platformer.framework.ObjectId;

import java.awt.*;
import java.util.LinkedList;

public class Block extends GameObject {

    public Block(float x, float y, ObjectId id) {
        super(x, y, id);
    } // **** end Block(float, float, ObjectId) constructor

    @Override
    public void tick(LinkedList<GameObject> object) {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect((int)x, (int)y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32, 32);
    }

} // **** end Block class ****