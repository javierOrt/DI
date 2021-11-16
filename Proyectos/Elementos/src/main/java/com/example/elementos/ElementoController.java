package com.example.elementos;

import com.example.elementos.Persona;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ElementoController implements Initializable {

    @FXML
    private ToggleButton btnToggle;

    @FXML
    private RadioButton radioUno, radioDos, radioTres;

    @FXML
    private Button btnComprobar, btnImagen, btnListas;

    @FXML
    private BorderPane ventanaGeneral;

    @FXML
    private GridPane gridAdicional, panelBotones;

    @FXML
    CheckBox checkUno, checkDos, checkTres;

    @FXML
    HBox panelCheck;

    @FXML
    private ComboBox<Persona> combo;

    @FXML
    private ChoiceBox<Persona> choice;

    @FXML
    private ListView<Persona> listView;


    private ObservableList<Persona> listaCombo, listaChoice;

    private ObservableList<Persona> listaListView;

    private ToggleGroup grupoRadios;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        iniciarListas();

        asociarElementos();
        iniciarElementos();
        acciones();
    }

    private void iniciarListas() {
        listaChoice.addAll(new Persona("Pepe", "Telas", 12)
                              ,new Persona("Venom", "Otro", 123)
                              ,new Persona("CapitanAmerica", "Loquesea",1));

        listaCombo.addAll(new Persona("Pepe", "Telas", 12)
                              ,new Persona("Venom", "Otro", 123)
                              ,new Persona("CapitanAmerica", "Loquesea",1));

    }


    private void asociarElementos() {

        combo.setItems(listaCombo);
        choice.setItems(listaChoice);
        listView.setItems(listaListView);
    }

    private void instancias() {
        grupoRadios = new ToggleGroup();
        listaCombo = FXCollections.observableArrayList();
        listaChoice = FXCollections.observableArrayList();
        listaListView = FXCollections.observableArrayList();
        grupoRadios.getToggles().addAll(radioUno, radioDos, radioTres);
    }

    private void iniciarElementos() {

        btnToggle.setSelected(false);
        ventanaGeneral.getChildren().remove(gridAdicional);
        btnToggle.setBackground(null);
        btnToggle.setText("");
        btnToggle.setBorder(null);

    }

    private void acciones() {
        /*btnComprobar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /*boolean activado = btnToggle.isSelected();
                System.out.println(activado);
                ObservableList<Node> listaNodos = panelCheck.getChildren();
                for (Node itemNode : listaNodos) {
                    if (((CheckBox) itemNode).isSelected()) {
                        // lo añado a la lista de personajes
                        //System.out.println(((CheckBox)itemNode).getText());
                        Personaje seleccionado = (Personaje) itemNode.getUserData();
                        System.out.println(seleccionado.getNombre());
                        System.out.println(seleccionado.getPoder());
                        System.out.println(seleccionado.getAtaque());
                        System.out.println(seleccionado.getDefensa());
                        System.out.println(seleccionado.getConcetracion());
                    }
                    System.out.println();
                }

            }
        });*/


        btnToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    ventanaGeneral.setLeft(gridAdicional);
                } else {
                    ventanaGeneral.getChildren().remove(gridAdicional);
                }
            }
        });
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {
                String titular = ((Persona) newValue.getUserData()).getNombre();
                System.out.println(titular);
            }
        });
        ObservableList<Node> listaElementos = panelBotones.getChildren();
        btnListas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(combo.getSelectionModel().getSelectedItem().getNombre());
                System.out.println(choice.getSelectionModel().getSelectedItem().getNombre());
            }
        });
        for (Node elemento : listaElementos) {
            if (elemento instanceof Button) {
                //((Button) elemento).setOnAction(new ManejoPulsaciones());
                ((Button) elemento).addEventHandler(ActionEvent.ACTION, new ManejoPulsaciones());
            }
        }
        combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Persona>() {
            @Override
            public void changed(ObservableValue<? extends Persona> observableValue,
                                Persona personaje, Persona t1) {
                /*if (t1.getNombre().equals("Venom")){

                }*/
                System.out.println(t1.getNombre());
            }
        });
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            Button bAux = (Button) actionEvent.getSource();

            if (bAux != btnImagen) {
                System.out.println(bAux.getText());
            }
        }
    }
}