import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class PhoneApp extends JFrame {
    private JLabel telNumberLabel = new JLabel(" ");
    private JButton callButton = new JButton("Call");
    private JButton endButton = new JButton("End");
    private JButton clearButton = new JButton("C");

    private int callDuration = 0;
    private Timer callTimer;

    public PhoneApp() {
        setTitle("Phone App");
        // deklaracija UI komponenti

        JButton num1Button = new JButton("1");
        JButton num2Button = new JButton("2");
        JButton num3Button = new JButton("3");
        JButton num4Button = new JButton("4");
        JButton num5Button = new JButton("5");
        JButton num6Button = new JButton("6");
        JButton num7Button = new JButton("7");
        JButton num8Button = new JButton("8");
        JButton num9Button = new JButton("9");
        JButton num0Button = new JButton("0");

        JLabel durationLabel = new JLabel("00");
        JLabel previousDurationLabel = new JLabel("00");

        // Pocetno stanje kontrolnih gumba
        callButton.setEnabled(false);
        endButton.setEnabled(false);

        // ComponentListener za scaling fonta relativno o velicini prozora
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Izracunavanje velicine fonta relativno o velicini prozora
                int fontSize = getWidth() / 30;

                // Kreiranje novog font objekta
                Font newFont = new Font("Serif", Font.PLAIN, fontSize);

                // Postavljanje novog fonta na sve komponente
                num1Button.setFont(newFont);
                num2Button.setFont(newFont);
                num3Button.setFont(newFont);
                num4Button.setFont(newFont);
                num5Button.setFont(newFont);
                num6Button.setFont(newFont);
                num7Button.setFont(newFont);
                num8Button.setFont(newFont);
                num9Button.setFont(newFont);
                num0Button.setFont(newFont);
                clearButton.setFont(newFont);
                callButton.setFont(newFont);
                endButton.setFont(newFont);
                telNumberLabel.setFont(newFont);
                durationLabel.setFont(newFont);
                previousDurationLabel.setFont(newFont);

            }
        });
        // setup osnovnog layouta prozora
        setLayout(new BorderLayout());

        // panel za prikaz broja telefona
        JPanel telPanel = new JPanel(new BorderLayout());
        telPanel.setBorder(new LineBorder(Color.BLACK, 1));
        telPanel.add(telNumberLabel, BorderLayout.CENTER);
        telPanel.setBackground(Color.WHITE);

        // panel sredisnjeg dijela aplikacije
        JPanel bodyPanel = new JPanel(new GridBagLayout());


        // Definiranje GridBagConstraints objekta za postavljanje komponenti
        GridBagConstraints gbc = new GridBagConstraints();
        // Postavljanje fill na BOTH kako bi se komponente popunile u oba smjera
        gbc.fill = GridBagConstraints.BOTH;
        // Postavljanje weighty na 1 kako bi srednji panel popunio vertikalni prostor izmedu telPanela i callPanela
        gbc.weighty = 1;

        // Postavljanje razmaka izmedu panela
        gbc.insets = new Insets(2, 2, 2, 2);
        // Postavljanje durationLabela na 2/7 sirine bodyPanela
        gbc.weightx = 2;

        Border border = new LineBorder(Color.BLACK, 1);
        JPanel firstColumnPanel = new JPanel(new BorderLayout());
        firstColumnPanel.setBorder(border);
        firstColumnPanel.setBackground(Color.WHITE);
        firstColumnPanel.add(durationLabel, BorderLayout.CENTER);
        bodyPanel.add(firstColumnPanel, gbc);

        // Postavljanje keyboardPanela na 3/7 sirine bodyPanela
        gbc.weightx = 3;

        // Kreiranje panela za tipkovnicu 4x3 grid
        JPanel keyboardPanel = new JPanel(new GridLayout(4, 3));
        JPanel dummyPanel = new JPanel();
        keyboardPanel.add(num1Button);
        keyboardPanel.add(num2Button);
        keyboardPanel.add(num3Button);
        keyboardPanel.add(num4Button);
        keyboardPanel.add(num5Button);
        keyboardPanel.add(num6Button);
        keyboardPanel.add(num7Button);
        keyboardPanel.add(num8Button);
        keyboardPanel.add(num9Button);
        keyboardPanel.add(dummyPanel);
        keyboardPanel.add(num0Button);
        keyboardPanel.add(clearButton);
        bodyPanel.add(keyboardPanel, gbc);

        // Postavljanje lastColumnPanela na 2/7 sirine bodyPanela
        gbc.weightx = 2;
        JPanel lastColumnPanel = new JPanel(new BorderLayout());
        lastColumnPanel.setBackground(Color.WHITE);
        lastColumnPanel.setBorder(border);
        lastColumnPanel.add(previousDurationLabel, BorderLayout.CENTER);
        bodyPanel.add(lastColumnPanel, gbc);

        // panel za kontrole poziva
        JPanel callPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        callPanel.add(callButton);
        callPanel.add(endButton);


        // dodavanje panela u glavni prozor
        add(telPanel, BorderLayout.NORTH);
        add(bodyPanel, BorderLayout.CENTER);
        add(callPanel, BorderLayout.SOUTH);

        // Postavljanje osnovnih postavki prozora
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);

        // postavljanje listenera na gumbe
        num1Button.addActionListener(e -> appendToTelNumberLabel("1"));
        num2Button.addActionListener(e -> appendToTelNumberLabel("2"));
        num3Button.addActionListener(e -> appendToTelNumberLabel("3"));
        num4Button.addActionListener(e -> appendToTelNumberLabel("4"));
        num5Button.addActionListener(e -> appendToTelNumberLabel("5"));
        num6Button.addActionListener(e -> appendToTelNumberLabel("6"));
        num7Button.addActionListener(e -> appendToTelNumberLabel("7"));
        num8Button.addActionListener(e -> appendToTelNumberLabel("8"));
        num9Button.addActionListener(e -> appendToTelNumberLabel("9"));
        num0Button.addActionListener(e -> appendToTelNumberLabel("0"));
        clearButton.addActionListener(e -> telNumberLabel.setText(" "));

        // Listener za telNumberLabel koji omogucava poziv ako je broj unesen
        telNumberLabel.addPropertyChangeListener("text", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String newText = (String) evt.getNewValue();
                // omogucava callButton ako je broj unesen
                callButton.setEnabled(!newText.equals(" "));
            }
        });

        // Listener za callButton koji pokrece timer i onemogucava call button
        callButton.addActionListener(e -> {
            callDuration = 0; // Reset the call duration
            callTimer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    callDuration++;
                    durationLabel.setText(String.format("%02d", callDuration));
                }
            });
            callTimer.start();
            // toggle stanja kontrolnih gumba
            callButton.setEnabled(false);
            endButton.setEnabled(true);

        });

        // Listener za endButton koji zaustavlja timer i onemogucava end button
        endButton.addActionListener(e -> {
            // zaustavljanje timera
            callTimer.stop();
            // postavljanje prethodnog trajanja poziva, pretvaranje sekundi u minute
            int durationInSeconds = Integer.parseInt(durationLabel.getText());
            double durationInMinutes = (double) durationInSeconds / 60;
            previousDurationLabel.setText(String.format("%.2f", durationInMinutes));
            // resetiranje trajanja poziva
            durationLabel.setText("00");
            // resetiranje broja telefona
            telNumberLabel.setText(" ");
            // onemogucavanje endButtona
            endButton.setEnabled(false);
        });
    }

    // metoda za dodavanje broja na telNumberLabel
    public void appendToTelNumberLabel(String value) {
        String currentText = telNumberLabel.getText();
        String newText;
        if (currentText.equals(" ")) {
            newText = value;
        } else {
            newText = currentText + value;
        }
        telNumberLabel.setText(newText);
    }

    // pokretanje aplikacije sa linux izgledom
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }
            new PhoneApp();
        });
    }
}