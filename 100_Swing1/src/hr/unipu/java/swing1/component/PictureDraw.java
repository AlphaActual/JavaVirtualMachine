package hr.unipu.java.swing1.component;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PictureDraw extends JComponent {
    private ImageIcon image = new ImageIcon("resources/unipu.png");

  public void paint(Graphics g) {
    int w = image.getIconWidth();
    int h = image.getIconWidth();
    g.drawImage(image.getImage(), 0, 0, w, h, this);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      PictureDraw drawing = new PictureDraw();
      JFrame frame = new JFrame("Drawing");
      frame.add(drawing);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.pack();
      frame.setSize(300, 300);
      frame.setVisible(true);

    });
  }
}
