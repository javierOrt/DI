package com.example.javierortizfeliz;

import com.example.javierortizfeliz.utils.Pedido;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.w3c.dom.events.Event;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    Button botonActivar, botonAgregar;

    @FXML
    TextField textUsuario, textPassword, textNombre, textApellido, textDireccion, textTelefono;

    @FXML
    SplitPane splitPane;

    @FXML
    TextArea textArea;

    private Pedido pedidoAnadido;

    private ArrayList<Pedido> listaPedidos;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        acciones();

    }

    private void acciones() {

        botonActivar.setOnAction(new introducirUsuario());
        botonAgregar.setOnAction(new agregarIngredientes());

    }

    class introducirUsuario implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonActivar){
                if (textUsuario.getText().equals("usuario1") && textPassword.getText().equals("12345")){
                    splitPane.setDisable(false);
                }
            }
        }
    }

    class agregarIngredientes implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {

            listaPedidos = new ArrayList<Pedido>();

            if (actionEvent.getSource() == botonAgregar) {

                if (!textNombre.getText().isEmpty() ||
                    !textApellido.getText().isEmpty() ||
                    !textDireccion.getText().isEmpty() ||
                    !textTelefono.getText().isEmpty()) {

                    int contador = 0;

                    listaPedidos.add(pedidoAnadido = new Pedido(textNombre.getText(), textApellido.getText(), textDireccion.getText(), Integer.parseInt(textTelefono.getText())));
                    textArea.appendText(listaPedidos.get(contador).getNombre() + "-" + listaPedidos.get(contador).getTelefono() + "\n");

                    contador++;
                }
            }
        }
    }
}
