import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Pritišanac Tin
 * @version 1.0
 * DZ 10B - Jednostavni kalkulator sa Swingom i Look and Feel promjenom te korištenjem SwingWorkera
 * Kod svih zadaća dostupan je na git repozitoriju: <a href="https://github.com/AlphaActual/JavaVirtualMachine">MY REPO</a>
 *
 */
public class Calculator extends JFrame {
    // Deklaracija komponenti
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultLabel;
    private JLabel resultValue;

    JButton metalButton = new JButton("Metal");
    JButton windowsButton = new JButton("Windows");
    JButton cdeButton = new JButton("CDE/Motif");

    public Calculator() {

        num1Field = new JTextField(5);
        num2Field = new JTextField(5);
        resultLabel = new JLabel("Rezultat: ");
        resultValue = new JLabel();

        Color customColor = new Color(11, 115, 0);
        resultValue.setForeground(customColor);

        // Dodavanje component listenera na JFrame za promjenu fonta rezultata relativno o velicini prozora
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                JFrame source = (JFrame) e.getSource();
                Font font = resultLabel.getFont();
                float newSize = source.getWidth() * 0.05f; // 5% of the width
                resultLabel.setFont(font.deriveFont(newSize));
                resultValue.setFont(font.deriveFont(newSize));
            }
        });

        // Dodavanje component listenera na JTextField za promjenu fonta relativno o velicini prozora
        ComponentAdapter componentAdapter = new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                JTextField source = (JTextField) e.getSource();
                Font font = source.getFont();
                float newSize = source.getHeight() * 0.8f; // 80% of the height
                source.setFont(font.deriveFont(newSize));
            }
        };

        // Dodavanje component listenera na polja za unos za promjenu fonta relativno o velicini prozora
        num1Field.addComponentListener(componentAdapter);
        num2Field.addComponentListener(componentAdapter);


        // Dodavanje key listenera na polja za unos kako bi se dozvolili samo numericki unosi
        num1Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();  // Ignore non-digit characters
                }
            }
        });
        // Dodavanje key listenera na polja za unos kako bi se dozvolili samo numericki unosi
        num2Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();  // Ignore non-digit characters
                }
            }
        });


        // Kreiranje operacijskih gumbova i postavljanje listenera na njih
        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation('+');
            }
        });

        JButton subtractButton = new JButton("-");
        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation('-');
            }
        });

        JButton multiplyButton = new JButton("*");
        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation('*');
            }
        });

        JButton divideButton = new JButton("/");
        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation('/');
            }
        });

        // Dodavanje listenera na gumbe za promjenu Look and Feel-a
        metalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            }
        });

        windowsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            }
        });

        cdeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            }
        });


        // SETUP LAYOUTA
        // Postavljanje layouta za JFrame (glavni prozor)
        setLayout(new GridLayout(4, 1));

        // Kreiranje panela za input polja i dodavanje istih u panel
        JPanel inputPanel = new JPanel( new GridLayout(1, 2));
        inputPanel.add(num1Field);
        inputPanel.add(num2Field);

        // Kreiranje panela za rezultat i dodavanje istih u panel
        JPanel resultPanel = new JPanel(new GridLayout(1, 2));
        resultPanel.add(resultLabel);
        resultPanel.add(resultValue);

        // Kreiranje panela za operacijske gumbe i dodavanje istih u panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        // Kreiranje panela za Look and Feel gumbe i dodavanje istih u panel
        JPanel lookAndFeelPanel = new JPanel(new GridLayout(1, 3));
        lookAndFeelPanel.add(metalButton);
        lookAndFeelPanel.add(windowsButton);
        lookAndFeelPanel.add(cdeButton);

        // Dodavanje svih panela u JFrame
        add(inputPanel);
        add(resultPanel);
        add(buttonPanel);
        add(lookAndFeelPanel);


        // Postavljanje osnovnih postavki prozora
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);
    }

    // Metoda za promjenu Look and Feel-a
    private void changeLookAndFeel(String lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metoda za izvođenje racunskih operacija
    private void performOperation(char operation) {
        new SwingWorker<Double, Void>() {
            @Override
            protected Double doInBackground() throws Exception {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                double result = 0;

                switch (operation) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            JOptionPane.showMessageDialog(null, "Cannot divide by zero");
                            return null;
                        }
                        break;
                }

                return result;
            }

            @Override
            protected void done() {
                try {
                    double result = get();
                    resultValue.setText(String.valueOf(result));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.execute();
    }


    public static void main(String[] args) {
        new Calculator();
    }
}