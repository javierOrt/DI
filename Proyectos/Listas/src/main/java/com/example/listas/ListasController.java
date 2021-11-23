package com.example.listas;

import com.example.listas.utils.Persona;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListasController implements Initializable {

    @FXML
    private ChoiceBox choice;

    @FXML
    private ComboBox combo;

    @FXML
    private ListView listView;

    @FXML
    private Label labelCombo, labelChoice;

    @FXML
    private Button btnComprobar;

    private ObservableList<Persona> listaCombo, listaChoice;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociasElementos();
        iniciarListas();
        acciones();
        lecturaJson();
    }

    private void lecturaJson() {
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=4ef66e12cddbb8fe9d4fd03ac9632f6e&language=en-US&page=1";
        try {
            InputStream inputStream = new URL(url).openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String respuesta = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void acciones() {
    }

    private void iniciarListas() {

        listaCombo.addAll(new Persona("Javier","Ortiz","2333",22,666),
                new Persona("Alba","Ortiz","2313",22,999),
                new Persona("Joan","Mendoza","0001",22,777));

        listaChoice.addAll(new Persona("Javier","Ortiz","2333",22,666),
                new Persona("Alba","Ortiz","2313",22,999),
                new Persona("Joan","Mendoza","0001",22,777));
    }

    private void asociasElementos() {
        choice.setItems(listaChoice);
        combo.setItems(listaCombo);
    }

    private void instancias() {

        listaCombo = FXCollections.observableArrayList();
        listaChoice = FXCollections.observableArrayList();
    }

}