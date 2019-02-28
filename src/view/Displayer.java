package view;

import controller.Game;
import model.board.Tile;

import javax.swing.*;
import java.awt.*;

public class Displayer {

    int widthFrame = 960;
    int heightFrame = 640;

    JFrame frame;
    JPanel panel;

    Tile[][] tiles;

    public Displayer(Game game) {

        frame = new JFrame("Checkers!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(widthFrame, heightFrame);
        //frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new CheckersPanel();

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);

        tiles = game.getBoard().getTiles();

    } // **** end Displayer(int, int) constructor ****

    class CheckersPanel extends JPanel {

        public CheckersPanel() {
        } // **** end CheckersPanel() constructor ****

        @Override
        public void paintComponent(Graphics g) {


            drawTileAndToken(g);


            //g.drawImage(imageBackground, 0, 0, this.getWidth(), this.getHeight(),
            //        0, 0, 1920, 1080, null);
        }

        private void drawTileAndToken(Graphics g) {
            int x = 64;
            int y = 32;

            for (Tile[] ti : tiles) {
                y += Tile.HEIGHT;

                for (Tile t : ti) {
                    g.setColor(t.getColor());
                    g.fillRect(x, y, Tile.WIDTH, Tile.HEIGHT);

                    if (t.getToken() != null) {
                        g.setColor(t.getToken().getColor());
                        g.fillOval(x+5, y+5, Tile.WIDTH-10, Tile.HEIGHT-10);
                    }

                    x += Tile.WIDTH;
                }

                x = 64;
            }
        }
    } // **** end CheckersPanel class ****

} // **** end Displayer class ****