package com.example.t_repasojfx;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable , EventHandler<Event> {

    @FXML Button boton1,boton2,boton3;

    DropShadow dropShadow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void instancias() {
        dropShadow = new DropShadow();
    }

    private void acciones() {

        boton1.addEventHandler(ActionEvent.ACTION, this);
        boton2.addEventHandler(ActionEvent.ACTION, this);
        boton3.addEventHandler(ActionEvent.ACTION, this);

        boton1.addEventHandler(MouseEvent.MOUSE_ENTERED, this);
        boton1.addEventHandler(MouseEvent.MOUSE_EXITED, this);
        boton2.addEventHandler(MouseEvent.MOUSE_ENTERED, this);
        boton2.addEventHandler(MouseEvent.MOUSE_EXITED, this);
        boton3.addEventHandler(MouseEvent.MOUSE_ENTERED, this);
        boton3.addEventHandler(MouseEvent.MOUSE_EXITED, this);

        /*
        boton1.setOnAction(new ManejoPulsaciones());
        boton2.setOnAction(new ManejoPulsaciones());
        boton3.setOnAction(new ManejoPulsaciones());

        boton1.setOnMouseEntered(new ManejoRaton());
        boton1.setOnMouseExited(new ManejoRaton());
        boton2.setOnMouseEntered(new ManejoRaton());
        boton2.setOnMouseExited(new ManejoRaton());
        boton3.setOnMouseEntered(new ManejoRaton());
        boton3.setOnMouseExited(new ManejoRaton());
         */
    }

    @Override
    public void handle(Event event) {

        Button btnaux = (Button) event.getSource();

        if (event.getEventType() == ActionEvent.ACTION){

            if (event.getSource() == boton1) {
                System.out.println("Pulsado boton 1");
            } else {
                System.out.println("Pulsado boton 2 o 3");
            }

        } else if (event.getEventType() == MouseEvent.MOUSE_ENTERED){

            btnaux.setEffect(dropShadow);

        } else if (event.getEventType() == MouseEvent.MOUSE_EXITED){

            btnaux.setEffect(null);
        }

    }

    /*
    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {

            if (actionEvent.getSource() == boton1) {
                System.out.println("Pulsado boton1");
            } else {
                System.out.println("Pulsado boton 2 o 3");
            }
        }
    }
    */

    /*
    class ManejoRaton implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {

            Button btnaux = (Button) mouseEvent.getSource();

            if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED){
                btnaux.setEffect(null);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                btnaux.setEffect(dropShadow);
            }
        }
    }
    */
}