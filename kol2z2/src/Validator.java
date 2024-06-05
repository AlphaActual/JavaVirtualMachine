import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit;

// valid iban example HR1723600001101234565
public class Validator extends JFrame {
    private JLabel label1 = new JLabel("IBAN");
    private JLabel label2 = new JLabel("Validan");
    private JLabel result = new JLabel("N/A");
    private JTextField iban = new JTextField();
    private JButton validate = new JButton("Validiraj");

    public Validator(){
        // ComponentListener za scaling fonta relativno o velicini prozora
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Izracunavanje velicine fonta relativno o velicini prozora
                int fontSize = getWidth() / 30;

                // Kreiranje novog font objekta
                Font newFont = new Font("Serif", Font.PLAIN, fontSize);

                // Postavljanje novog fonta na sve komponente
                label1.setFont(newFont);
                label2.setFont(newFont);
                result.setFont(newFont);
                iban.setFont(newFont);
                validate.setFont(newFont);

            }
        });
        // setup osnovnog layouta prozora
        setLayout(new GridLayout(3,2));

        // dodavanje komponenti u prozor
        add(label1);
        add(iban);
        add(label2);
        add(result);
        add(new JLabel());
        add(validate);

        // Postavljanje osnovnih postavki prozora
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);

        // postavljanje akcije na dugme
        validate.addActionListener(e -> {
            String ibanText = iban.getText();
            boolean isValid = IBANCheckDigit.IBAN_CHECK_DIGIT.isValid(ibanText);
            result.setText(isValid ? "DA" : "NE");
        });
    }

    // pokretanje aplikacije sa linux izgledom
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Validator();
        });
    }
}