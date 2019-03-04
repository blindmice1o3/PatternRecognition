package edu.pooh.chess.view;

import edu.pooh.chess.controller.Game;
import edu.pooh.chess.model.board.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Displayer {

    int widthFrame = 960;
    int heightFrame = 640;

    JFrame frame;
    CheckersPanel panel;

    Game game;
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

        this.game = game;
        // @@@ refactor below so VIEW doesn't mutate MODEL (send request for CONTROLLER to change MODEL's state) @@@
        tiles = game.getBoard().getTiles();

    } // **** end Displayer(int, int) constructor ****

    class CheckersPanel extends JPanel implements MouseListener{
        private int x = 64;
        private int y = 64;

        private boolean firstBoundSet = true;

        public CheckersPanel() {
            addMouseListener(this);
        } // **** end CheckersPanel() constructor ****

        @Override
        public void paintComponent(Graphics g) {

            drawTilesAndTokens(g);

            //g.drawImage(imageBackground, 0, 0, this.getWidth(), this.getHeight(),
            //        0, 0, 1920, 1080, null);
        }

        private void drawTilesAndTokens(Graphics g) {
            for (Tile[] ti : tiles) {
                for (Tile t : ti) {
                    g.setColor(t.getColor());
                    g.fillRect(x, y, Tile.WIDTH, Tile.HEIGHT);

                    // Render border for this tile.
                    if (t.isBorder()) {
                        Graphics2D g2d = (Graphics2D)g;

                        g2d.setStroke( new BasicStroke(3) );

                        g2d.setColor(Color.RED);
                        g2d.drawRect(x, y, Tile.WIDTH-2, Tile.HEIGHT-2);
                    }

                    // @@@ Set the values for each Tile's BOUNDING RECTANGLE @@@
                    if (firstBoundSet) {
                        t.getBound().x = x;
                        t.getBound().y = y;
                        t.getBound().width = Tile.WIDTH;
                        t.getBound().height = Tile.HEIGHT;
                    }

                    if (t.getToken() != null) {
                        g.setColor(t.getToken().getColor());
                        g.fillOval(x+5, y+5, Tile.WIDTH-10, Tile.HEIGHT-10);
                    }

                    x += Tile.WIDTH;
                }

                x = 64;
                y += Tile.HEIGHT;
            }
            y = 64;
            if (firstBoundSet) {
                firstBoundSet = false;
            }
        }

        Tile currentSelected = null;
        Tile previousSelected = null;

        @Override
        public void mouseClicked(MouseEvent e) {


            for (Tile[] ti : tiles) {
                for (Tile t : ti) {
                    if ( t.getBound().contains(e.getX(), e.getY()) ) {
                        System.out.println(t.getId());

                        if (previousSelected != null) {
                            previousSelected.setBorder(false);
                        }

                        currentSelected = t;
                        currentSelected.setBorder(true);

                        previousSelected = currentSelected;
                    }
                }
            }
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    } // **** end CheckersPanel class ****

} // **** end Displayer class ****