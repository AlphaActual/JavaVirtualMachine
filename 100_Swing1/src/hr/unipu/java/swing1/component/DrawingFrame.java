package hr.unipu.java.swing1.component;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class DrawingFrame extends JFrame {
  private Drawing drawing;

  public DrawingFrame() {
    Drawing drawing = new Drawing(100);
    add(drawing, BorderLayout.NORTH);

    JButton buttonLarger = new JButton("Povečaj");
    add(buttonLarger, BorderLayout.SOUTH);
    buttonLarger.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        drawing.setRadius(drawing.getRadius() + 10);
      }
    });
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      DrawingFrame frame = new DrawingFrame();
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.setSize(300, 300);
      frame.setVisible(true);
    });
  }

}
