package edu.pooh.bird_view_shooter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

    private Controller controller;
    private Camera camera;

    public MouseInput(Controller controller, Camera camera) {
        this.controller = controller;
        this.camera = camera;
    } // **** end MouseInput(Controller, Camera) constructor ****


    public void mousePressed(MouseEvent e) {
        // We're adding the camera because with mx and my, it doesn't translate the actual
        // x and y positioning of our mouse. So if we're all the way to the right (we're all
        // the way across the level/map) and we click the middle of the screen, it's still going
        // to show the coordinate of like 500 for x and like 250 for y, rather than like it
        // being 1500 for x and whatever the same y is. That's why we add the camera coordinate.
        int mx = (int)(e.getX() + camera.getX()); // Pass into Bullet's constructor.
        int my = (int)(e.getY() + camera.getY()); // Pass into Bullet's constructor.

        // Now we need to create the bullet on our actual player.
        for (int i = 0; i < controller.object.size(); i++) {
            GameObject tempObject = controller.object.get(i);

            if (tempObject.getId() == ID.Player) {
                // The +16 and +24 will position the new Bullet right in the center of our player object.
                // Without these, it will be shooting out of the top left corner of our player.
                controller.addObject(new Bullet(tempObject.getX()+16, tempObject.getY()+24,
                        ID.Bullet, controller, mx, my));
            }
        }
    }

} // **** end MouseInput class ****