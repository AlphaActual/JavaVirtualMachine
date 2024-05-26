import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Pritišanac Tin
 * @version 1.0
 * DZ 11a - Jednostavni kalkulator sa JavaFXom
 * Kod svih zadaća dostupan je na git repozitoriju: <a href="https://github.com/AlphaActual/JavaVirtualMachine">MY REPO</a>
 *
 */

// Pokretanje aplikacije
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}