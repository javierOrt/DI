package com.example.javierortiz;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    ImageView imagenJson;
    @FXML
    ComboBox comboJson;
    @FXML
    ListView listChistes;
    @FXML
    Button btnChisteAleatorio, btnChisteCategoria;

    private Task tareaJson;
    private String categoria;
    private ObservableList<String> listaCombo;
    private ObservableList<String> listaChistes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        initGUI();
        asociarElementos();
        lecturaJSON();
        acciones();

    }

    private void initGUI() {
        imagenJson.setImage(new Image("https://api.chucknorris.io/img/chucknorris_logo_coloured_small@2x.png"));
    }

    private void instancias() {

        listaCombo = FXCollections.observableArrayList();
        listaChistes = FXCollections.observableArrayList();
    }

    private void acciones() {

        comboJson.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                categoria = t1.toString();
            }
        });

        btnChisteAleatorio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    String url = "https://api.chucknorris.io/jokes/random";
                    InputStream inputStream = new URL(url).openStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String linea = null;
                    StringBuffer stringBuffer = new StringBuffer();

                    while ((linea = bufferedReader.readLine()) != null) {
                        stringBuffer.append(linea);
                    }

                    JSONObject jsonObject = new JSONObject(stringBuffer.toString());
                    String chiste = jsonObject.getString("value");

                    listaChistes.add(chiste);


                }  catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        btnChisteCategoria.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {

                if (categoria!=null){
                    try {
                        String url = "https://api.chucknorris.io/jokes/random?category="+categoria;
                        InputStream inputStream = new URL(url).openStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        String linea = null;
                        StringBuffer stringBuffer = new StringBuffer();

                        while ((linea = bufferedReader.readLine()) != null) {
                            stringBuffer.append(linea);
                        }

                        JSONObject jsonObject = new JSONObject(stringBuffer.toString());
                        String chiste = jsonObject.getString("value");

                        listaChistes.add(chiste);

                    }  catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("No se ha seleccionado una categoria");
                }
            }
        });
    }

    private void asociarElementos() {

        comboJson.setItems(listaCombo);
        listChistes.setItems(listaChistes);
    }

    private void lecturaJSON() {
        tareaJson = new Task() {
            @Override
            protected Object call() throws Exception {

                String url = "https://api.chucknorris.io/jokes/categories";
                InputStream inputStream = new URL(url).openStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String linea = null;
                StringBuilder stringBuffer = new StringBuilder();

                while ( (linea=bufferedReader.readLine())!=null ){
                    stringBuffer.append(linea);
                }

                JSONArray categoriasArray = new JSONArray(stringBuffer.toString());

                for (int i = 0; i < categoriasArray.length(); i++) {
                    listaCombo.add(categoriasArray.getString(i));
                }
                return null;
            }
        };

        new Thread(tareaJson).start();
    }
}