package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;

public class ViewController {

    // Para fazer as referencias entre tela
    // Sempre colocar a notação @FXML para referenciar atributos de tela
    @FXML
    private TextField txtNumber1;
    @FXML
    private TextField txtNumber2;
    @FXML
    private Label labelResult;
    @FXML
    private Button btSum; //javafx.scene.control.Button;

    @FXML
    public void onBtSumAction() {
        try {
            Locale.setDefault(Locale.US);
            double number1 = Double.parseDouble(txtNumber1.getText());
            double number2 = Double.parseDouble(txtNumber2.getText());
            double sum = number1 + number2;
            labelResult.setText(String.format("%.2f",sum));
        }
        catch (NumberFormatException e) {
            Alerts.showAlert("Error","Error","Invalid number", Alert.AlertType.ERROR);
        }
    }

    /*
    @FXML
    public void onBtTestAction() {
        //System.out.println("Click");
        Alerts.showAlert("Alert Title","Alert Header","Alert Content", Alert.AlertType.INFORMATION);
    }
     */
}
