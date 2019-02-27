package aaaRandomTinkering;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatternRecognition extends JFrame {

    JPanel mainPanel;
    JPanel secondaryPanel;
    JPanel consolePanel;
    String frameIconImageAddress;
    Image frameIcon;

    public PatternRecognition() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initPatternRecognition();

    } // **** end PatternRecognition() constructor ****

    public void initPatternRecognition() {

        frameIconImageAddress = "resources/aaaRandomImages/turbo_knight(557x749).png";
        frameIcon = new ImageIcon(frameIconImageAddress).getImage();
        setIconImage(frameIcon);
        setTitle("Pattern Recognition");
        setSize(1080, 720);
        setResizable(false);
        setLocationRelativeTo(null);

        mainPanel = new MainPanel();
        getContentPane().add(BorderLayout.CENTER, mainPanel);

        secondaryPanel = new SecondaryPanel();
        getContentPane().add(BorderLayout.EAST, secondaryPanel);

        consolePanel = new ConsolePanel();
        getContentPane().add(BorderLayout.SOUTH, consolePanel);

        setVisible(true);

    } // **** end initPatternRecognition() ****


    class MainPanel extends JPanel {

        String mainBackgroundImageAddress;
        Image mainBackground;

        public MainPanel() {

            mainBackgroundImageAddress = "resources/aaaRandomImages/cyberpunk_wallpapers(1920x1080).jpg";
            mainBackground = new ImageIcon(mainBackgroundImageAddress).getImage();

        } // **** end MainPanel() constructor ****

        @Override
        public void paintComponent(Graphics g) {

            g.drawImage(mainBackground, 0, 0, this.getWidth(), this.getHeight(),
                                        0, 0, 1920, 1080, null);

        } // **** end paintComponent(Graphics) ****

    } // **** end MainPanel inner-class ****

    class SecondaryPanel extends JPanel {

        JButton buttonA;
        JButton buttonB;

        JButton buttonBail;
        String buttonBailImageAddress;
        ImageIcon buttonBailImageIcon;

        public SecondaryPanel() {

            setSize(300, 600);
            setBorder( BorderFactory.createLineBorder(Color.YELLOW, 2) );
            setLayout( new BoxLayout(this, BoxLayout.Y_AXIS) );

            buttonA = new JButton("a");
            buttonA.setMargin( new Insets(0, 0, 0, 0) );

            buttonB = new JButton("b");
            buttonB.setMargin( new Insets(0, 0, 0, 0) );

            buttonBail = new JButton("JACK OUT!");
            buttonBailImageAddress = "resources/aaaRandomImages/pattern_recognition_icon(256x256).png";
            buttonBailImageIcon = new ImageIcon(buttonBailImageAddress);
            buttonBail.setIcon(buttonBailImageIcon);
            buttonBail.setToolTipText("bail!");
            buttonBail.setMargin( new Insets(0, 0, 0, 0) );

            add(buttonA);
            add(buttonB);
            add(buttonBail);

        } // **** end SecondaryPanel() constructor ****

    } // **** end SecondaryPanel inner-class ****

    class ConsolePanel extends JPanel {
        JTextArea consoleTextArea;
        JScrollPane consoleScrollPane;

        public ConsolePanel() {
            consoleTextArea = new JTextArea(15, 60);
            consoleTextArea.setEditable(false);
            consoleTextArea.setLineWrap(true);
            consoleTextArea.setWrapStyleWord(true);

            consoleScrollPane = new JScrollPane();
            consoleScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            consoleScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            consoleScrollPane.add(consoleTextArea);

            add(consoleScrollPane);
        }

        public JTextArea getConsoleTextArea() {
            return consoleTextArea;
        }
    }

    public static void main(String[] args) {
        new PatternRecognition();
    } // **** end main(String[]) ****

} // **** end PatternRecognition class ****
