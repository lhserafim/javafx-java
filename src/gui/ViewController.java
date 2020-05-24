package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ViewController {

    // Para fazer as referencias entre tela
    // Sempre colocar a notação @FXML para referenciar atributos de tela
    @FXML
    private Button btTest; //javafx.scene.control.Button;

    @FXML
    public void onBtTestAction() {
        System.out.println("Click");
    }
}
