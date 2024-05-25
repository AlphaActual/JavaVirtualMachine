import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Pritišanac Tin
 * @version 1.0
 * DZ 10A - Jednostavni kalkulator sa Swingom
 * Kod svih zadaća dostupan je na git repozitoriju: <a href="https://github.com/AlphaActual/JavaVirtualMachine">MY REPO</a>
 *
 */
public class Calculator extends JFrame {
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultLabel;

    public Calculator() {
        setLayout(new GridLayout(4, 1));

        num1Field = new JTextField(5);
        num2Field = new JTextField(5);
        resultLabel = new JLabel("Rezultat: ");

        // Add component listener to JFrame to adjust font size of result label on resize
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                JFrame source = (JFrame) e.getSource();
                Font font = resultLabel.getFont();
                float newSize = source.getWidth() * 0.05f; // 5% of the width
                resultLabel.setFont(font.deriveFont(newSize));
            }
        });

        // Creating component listener to adjust font size of the inputs relative to the height of the text field as it resizes
        ComponentAdapter componentAdapter = new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                JTextField source = (JTextField) e.getSource();
                Font font = source.getFont();
                float newSize = source.getHeight() * 0.8f; // 80% of the height
                source.setFont(font.deriveFont(newSize));
            }
        };

        // Add component listener to both text fields to adjust font size on resize
        num1Field.addComponentListener(componentAdapter);
        num2Field.addComponentListener(componentAdapter);


        // Add key listener to both text fields to allow only digits
        num1Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();  // Ignore non-digit characters
                }
            }
        });
        // Add key listener to both text fields to allow only digits
        num2Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();  // Ignore non-digit characters
                }
            }
        });

        // Kreiranje panela za gumbe i dodavanje funkcionalnosti
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2));

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

        // Dodavanje gumba u panel za gumbe
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        // Dodavanje komponenti u JFrame
        add(num1Field);
        add(num2Field);
        add(resultLabel);
        add(buttonPanel);

        // Postavljanje osnovnih postavki prozora
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }
    // Metoda za izvođenje racunskih operacija
    private void performOperation(char operation) {
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
                    return;
                }
                break;
        }

        resultLabel.setText("Result: " + result);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}