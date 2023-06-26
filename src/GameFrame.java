import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class GameFrame extends JFrame {
    /*
     * This class creates the frame for the game.
     * Using 2D graphics, it will display the game.
     */

    public void displayWindow() {
        /*
         * This method will display the window for the game.
         */

        // // Create the frame
        // JFrame frame = new JFrame();

        // name of the game
        this.setTitle("Tick Tack Toe");

        // Set the background color of the frame
        this.setBackground(Color.BLACK);

        // Set the size of the frame
        this.setSize(500, 500);

        // exit action
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // resizeable
        this.setResizable(true);

        // background color
        this.getContentPane().setBackground(new Color(30, 30, 30));

        // Set the frame to be visible
        this.setVisible(true);

        // mouse listener to determine where the user clicks
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println("X: " + x + " Y: " + y);
            }
        });

    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.WHITE);

        // Draw the grid
        int x = 200;
        int firstY = 100;
        int endY = 400;
        for (int i = 0; i < 2; i++) {
            g2D.drawLine(x, firstY, x, endY);
            x += 100;
        }
        int y = 200;
        int firstX = 100;
        int endX = 400;
        for (int i = 0; i < 2; i++) {
            g2D.drawLine(firstX, y, endX, y);
            y += 100;
        }
    }

    // function to draw a circle
    public void drawCircle(Graphics g, int x, int y) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.WHITE);
        g2D.drawOval(x, y, 100, 100);
    }

    // function to draw a cross
    public void drawCross(Graphics g, int x, int y) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.WHITE);
        g2D.drawLine(x, y, x + 100, y + 100);
        g2D.drawLine(x + 100, y, x, y + 100);
    }
}
