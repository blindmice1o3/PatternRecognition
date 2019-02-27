package view;

import javax.swing.*;
import java.awt.*;

public class Displayer {

    JFrame frame;
    JPanel panel;
    int widthFrame;
    int heightFrame;

    public Displayer() {

        widthFrame = 1080;
        heightFrame = 720;
        frame = new JFrame("Checkers!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(widthFrame, heightFrame);
        //frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new CheckersPanel();
        panel.setSize( new Dimension(1080, 720) );

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);

    } // **** end Displayer(int, int) constructor ****

    class CheckersPanel extends JPanel {
        String mainBackgroundImageAddress;
        Image mainBackground;

        public CheckersPanel() {
            mainBackgroundImageAddress = "resources/aaaRandomImages/cyberpunk_wallpapers(1920x1080).jpg";
            mainBackground = new ImageIcon(mainBackgroundImageAddress).getImage();
        } // **** end CheckersPanel() constructor ****

        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(mainBackground, 0, 0, this.getWidth(), this.getHeight(),
                    0, 0, 1920, 1080, null);
        }

    } // **** end CheckersPanel class ****

} // **** end Displayer class ****