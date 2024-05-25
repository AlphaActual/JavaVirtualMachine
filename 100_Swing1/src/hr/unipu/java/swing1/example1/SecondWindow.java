package hr.unipu.java.swing1.example1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SecondWindow extends JFrame {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    // metoda main
    public static void main(String[] args) {
        SecondWindow w = new SecondWindow();    //stavaranje GUI-a pozivom konstruktora
        w.setVisible(true);                     //GUI se postavlja kao vidljiv
    }

    // Konstruktor GUI-a
    public SecondWindow() {
        super();    //poziv konstruktora natklase JFrame (može se i izostaviti pa će Java prevoditelj sam ubaciti)
        setSize(WIDTH, HEIGHT);
        setTitle("Second Window Class");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JButton endButton = new JButton("Klikni da prekineš GUI program.");
        endButton.addActionListener(new EndingListener()); // pretplačivanje na slušača (anonimna klasa)
        add(endButton); //dodavanje komponente u GUI
    }

    // Slušač - implementiran kao unutrašnja klasa GUI-a
    public class EndingListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {    // event-handling metoda
            System.exit(0);
        }
    }

}
