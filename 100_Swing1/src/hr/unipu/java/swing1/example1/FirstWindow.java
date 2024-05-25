package hr.unipu.java.swing1.example1;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FirstWindow extends JFrame {

  public static void main(String[] args) {
    try {
      //sve oko GUI-ja treba izvršavati u grafičkoj dretvi
      //metoda invokeAndWait stavlja objekt Runnable u red iz kojeg grafička dretva uzima poslove koje treba obaviti
      SwingUtilities.invokeAndWait(new Runnable() {

        @Override
        public void run() {                       //grafička dretva će pozvati metodu run iz objekta Runnable
          FirstWindow window = new FirstWindow(); //stvara se JFrame
          window.setLocation(20, 20);       //postavlja se lokacija na ekranu
          window.setVisible(true);                //prikazuje prozor na ekranu
        }

      });
    } catch (InvocationTargetException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
