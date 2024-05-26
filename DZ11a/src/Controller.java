import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private TextField input1;
    @FXML
    private TextField input2;
    @FXML
    private Label result;

    @FXML
    public void initialize() {
        ChangeListener<String> numericChangeListener = new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    ((TextField)((StringProperty)observable).getBean()).setText(oldValue);
                }
            }
        };

        input1.textProperty().addListener(numericChangeListener);
        input2.textProperty().addListener(numericChangeListener);
    }
    @FXML
    private void add() {
        double num1 = Double.parseDouble(input1.getText());
        double num2 = Double.parseDouble(input2.getText());
        result.setText(String.valueOf(num1 + num2));
    }

    @FXML
    private void subtract() {
        double num1 = Double.parseDouble(input1.getText());
        double num2 = Double.parseDouble(input2.getText());
        result.setText(String.valueOf(num1 - num2));
    }

    @FXML
    private void multiply() {
        double num1 = Double.parseDouble(input1.getText());
        double num2 = Double.parseDouble(input2.getText());
        result.setText(String.valueOf(num1 * num2));
    }

    @FXML
    private void divide() {
        double num1 = Double.parseDouble(input1.getText());
        double num2 = Double.parseDouble(input2.getText());
        result.setText(String.valueOf(num1 / num2));
    }
}