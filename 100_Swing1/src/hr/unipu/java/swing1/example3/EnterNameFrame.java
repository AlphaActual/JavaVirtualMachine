package hr.unipu.java.swing1.example3;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class EnterNameFrame extends JFrame {

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      EnterNameFrame frame = new EnterNameFrame();
      frame.pack(); // slaganje komponenti na najmanje prostora
      frame.setVisible(true);
    });
  }

  /**
   * Create the frame.
   */
  public EnterNameFrame() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(10, 10, 500, 200); // postavljanje lokacije i veličine
    JPanel panel = new JPanel(); // ovo je potrebno zbog okvira

    panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    panel.setLayout(new BorderLayout());
    setContentPane(panel);

    JLabel lblTitle = new JLabel("Naslov");
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblTitle, BorderLayout.NORTH);

    JLabel lblName = new JLabel("Unesite ime i prezime:");
    panel.add(lblName, BorderLayout.WEST);

    JTextField tfInput = new JTextField();
    panel.add(tfInput, BorderLayout.CENTER);
    tfInput.setColumns(10);

    JPanel southPanel = new JPanel();
    panel.add(southPanel, BorderLayout.SOUTH);

    JButton btnOK = new JButton("OK");
    southPanel.add(btnOK);
  }
}
