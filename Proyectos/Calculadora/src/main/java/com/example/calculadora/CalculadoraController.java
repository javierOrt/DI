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

    String operacion;
    double numero1,numero2,resultado;

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
        }

        if (btnAux.getText().equals("+") ||
                btnAux.getText().equals("-") ||
                btnAux.getText().equals("/") ||
                btnAux.getText().equals("X") ||
                btnAux.getText().equals("Borrar")||
                btnAux.getText().equals("Salir") ||
                btnAux.getText().equals("AC")||
                btnAux.getText().equals("%")){

            numero1 = Double.parseDouble(campoTexto.getText());
            operacion = btnAux.getText();
            campoTexto.clear();
        }

        if (btnAux.getText().equals("=")) {

            numero2 = Double.parseDouble(campoTexto.getText());

            switch (operacion) {
                case "+" -> resultado = numero1 + numero2;
                case "-" -> resultado = numero1 - numero2;
                case "X" -> resultado = numero1 * numero2;
                case "/" -> resultado = numero1 / numero2;
                //case "%" -> resultado = numero1 / numero2;
                case "AC"-> {campoTexto.clear();
                            numero1=0;
                            numero2=0;
                            operacion = "";}
            }

            campoTexto.setText(String.valueOf(resultado));
        }
    }
}