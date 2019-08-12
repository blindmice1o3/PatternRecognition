package edu.pooh.evo_side_scroller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jgov on 7/22/2019.
 */
public class TestClass {

    public static void main(String[] args) {
        Assets.initAssets();

        TestClass test = new TestClass();
        test.initGUI();
    }

    private void initGUI() {
        JFrame frame = new JFrame("EVO Side Scroller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(640, 480));
        frame.setMaximumSize(new Dimension(640, 480));
        frame.setMinimumSize(new Dimension(640, 480));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new MyPanel();
        frame.setContentPane(panel);

        frame.setVisible(true);
    }

    class MyPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(Assets.chapter2Intro, 0, 0, getWidth(), getHeight(), null);
        }
    }
}
