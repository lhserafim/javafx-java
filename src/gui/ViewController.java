package gui;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

// Para implementar o controller, necessário implementar o Initializable e seu método
public class ViewController implements Initializable {

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
            Alerts.showAlert("Error","Error",e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // colocar ações que eu quero sejam executadas no momento da instanciação do controlador
        Constraints.setTextFieldDouble(txtNumber1);
        Constraints.setTextFieldDouble(txtNumber2);
        //Constraints.setTextFieldInteger(txtNumber1);
        //Constraints.setTextFieldInteger(txtNumber2);
        Constraints.setTextFieldMaxLength(txtNumber1,12);
        Constraints.setTextFieldMaxLength(txtNumber2,12);
    }

    /*
    @FXML
    public void onBtTestAction() {
        //System.out.println("Click");
        Alerts.showAlert("Alert Title","Alert Header","Alert Content", Alert.AlertType.INFORMATION);
    }
     */
}
