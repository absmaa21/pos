package demo02_paint;

import javax.swing.*;
import java.awt.*;

public class PaintLabel extends JLabel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Better way of drawing
        Graphics2D g2 = (Graphics2D) g;

        // Get the size of the canvas
        int width = getWidth();
        int height = getHeight();

        // Draw a line
        g2.drawLine(0,0,width,height);

        // Change color
        g2.setColor(Color.BLUE);

        // Draw ellipse
        g2.drawOval(30,30,width-60,height-60);

        // Set color RGB
        g2.setColor(new Color(255,0,0));

        // Draw rectangle
        g2.drawRect(15,15,width-30,height-30);

        // Set line width
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.YELLOW);
        int[] xCoords = {40, width-40, width/2};
        int[] yCoords = {40, 40, height-40};

        //g2.drawPolyline(xCoords, yCoords, xCoords.length);
        //g2.drawPolygon(xCoords, yCoords, xCoords.length);
        g2.fillPolygon(xCoords, yCoords, xCoords.length);
        g2.setColor(Color.BLACK);
        g2.drawPolygon(xCoords, yCoords, xCoords.length);

        // Scale the canvas to 30 x 20
        g2.scale(this.getWidth()/30. , this.getHeight()/20.);
        g2.setColor(Color.MAGENTA);
        g2.setStroke(new BasicStroke(.2f));
        g2.drawLine(0,20,30,0);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("My Image");
        frame.setLayout(new BorderLayout());
        PaintLabel lbPaint = new PaintLabel();
        frame.getContentPane().add(lbPaint, BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
