package hr.unipu.java.swing1.example1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class CloseableWindow extends JFrame {

  public CloseableWindow() {
    setSize(500, 200);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  //klik na x zatvara prozor i prekida grafičku dretvu
    setTitle("Closeable Window");
  }

  public static void main(String[] args) throws Exception {
    SwingUtilities.invokeAndWait(() -> {
      CloseableWindow window = new CloseableWindow();
      window.setLocation(20, 20);
      window.setVisible(true);
    });
  }
}
