package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private GridPane gridBtn;

    @FXML
    private TextField campoTexto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
    }

    private void acciones() {
    Collection<Node> gridbtnList = gridBtn.getChildren();
        for (Node i:
             gridbtnList) {
            ((Button) i).setOnAction(this);
        }
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Button btnAux = (Button) actionEvent.getSource();
        String numeroUno;
        String numeroDos;

        if (!(btnAux.getText().equals("=") ||
            btnAux.getText().equals("+") ||
            btnAux.getText().equals("-") ||
            btnAux.getText().equals("/") ||
            btnAux.getText().equals("X") ||
            btnAux.getText().equals("Borrar")||
            btnAux.getText().equals("Salir") ||
            btnAux.getText().equals("%") ||
            btnAux.getText().equals("AC"))){

            campoTexto.appendText(btnAux.getText());
            numeroUno = campoTexto.getText();
            }

            if (btnAux.getText().equals("+")){
            campoTexto.setText(btnAux.getText());
        }
    }
}