package gui;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import model.entities.Person;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    private ComboBox<Person> comboBoxPerson;
    // Para carregar o comboBox é obrigatório criar um objeto ObservableList<>
    private ObservableList<Person> obsList;

    @FXML
    private Button btAll;

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

        // Implementação da comboBox
        List<Person> list = new ArrayList<>(); // Cria uma lista padrão
        list.add(new Person(1,"Maria","maria@gmail.com")); // Add instanciando classe
        list.add(new Person(2,"José","jose@gmail.com"));
        list.add(new Person(3,"João","joao@gmail.com"));
        list.add(new Person(4,"Paulo","paulo@gmail.com"));

        obsList = FXCollections.observableArrayList(list); // carrega na ObservableList
        comboBoxPerson.setItems(obsList); // carrega na comboBox

        // IMPLEMENTAÇÃO P/ FORMATAR EXIBIÇÃO NA COMBOBOX
        Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };
        comboBoxPerson.setCellFactory(factory);
        comboBoxPerson.setButtonCell(factory.call(null));
    }

    @FXML
    // Recuperar o item selecionado na tela
    public void onComboBoxPersonAction() {
        Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
        System.out.println(person);
    }

    @FXML
    //Percorrer todos os elementos da lista
    public void onBtAllAction() {
        for (Person person : comboBoxPerson.getItems()) {
            System.out.println(person);
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
