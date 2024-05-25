package hr.unipu.java.swing1.example1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;


public class ThirdWindow extends JFrame {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    // metoda main
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    ThirdWindow w = new ThirdWindow();    //stavaranje GUI-a pozivom konstruktora
                    w.setVisible(true);                   //GUI se postavlja kao vidljiv
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    // Konstruktor GUI-a
    public ThirdWindow() {
        super();    //poziv konstruktora natklase JFrame (može se i izostaviti pa će Java prevoditelj sam ubaciti)
        setSize(WIDTH, HEIGHT);
        setTitle("Second Window Class");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JButton endButton = new JButton("Klikni da prekineš GUI program.");
        endButton.addActionListener(new ActionListener() {  // pretplaćivanje na slušača koji je odmah implementiran kao unutrašnja anonimna klasa
            public void actionPerformed(ActionEvent e) {    // event-handling metoda
                System.exit(0);
            }
        });
        add(endButton); //dodavanje komponente u GUI
    }

}
