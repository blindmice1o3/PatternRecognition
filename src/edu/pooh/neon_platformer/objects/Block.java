package edu.pooh.neon_platformer.objects;

import edu.pooh.neon_platformer.framework.GameObject;
import edu.pooh.neon_platformer.framework.ObjectId;
import edu.pooh.neon_platformer.framework.Texture;
import edu.pooh.neon_platformer.window.Game;

import java.awt.*;
import java.util.LinkedList;

public class Block extends GameObject {

    Texture texture = Game.getInstance();
    private int type;

    public Block(float x, float y, int type, ObjectId id) {
        super(x, y, id);
        this.type = type;
    } // **** end Block(float, float, ObjectId) constructor

    @Override
    public void tick(LinkedList<GameObject> object) {

    }

    @Override
    public void render(Graphics g) {
        if (type == 0) {    //dirt block
            g.drawImage(texture.block[0], (int)x, (int)y, null);
        }
        if (type == 1) {    //grass block
            g.drawImage(texture.block[1], (int)x, (int)y, null);
        }
        //g.setColor(Color.WHITE);
        //g.drawRect((int)x, (int)y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32, 32);
    }

} // **** end Block class ****