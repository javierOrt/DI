package com.example.listas;

import com.example.listas.utils.Pelicula;
import com.example.listas.utils.Persona;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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
    private Button btnComprobar, btnDetalle;

    @FXML
    private ImageView imageView;

    @FXML
    private HBox hbox;

    private ObservableList<Persona> listaCombo, listaChoice;

    private ObservableList<Pelicula> listaPeliculas;

    private Task tareaJSON;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociasElementos();
        iniciarListas();
        lecturaJson();
        acciones();
    }

    private void acciones() {
        btnComprobar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new Thread(tareaJSON).start();
            }
        });

        btnDetalle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (listView.getSelectionModel().getSelectedIndex()<0){
                    System.out.println("No hay nada seleccionado");
                } else {
                    Stage stage = new Stage();
                    stage.setTitle("Detalle");
                    FXMLLoader loader = null;
                    Parent root = null;

                    try {

                        loader = new FXMLLoader(getClass().getResource("detalle-view.fxml"));
                        root = loader.load();

                    } catch (IOException e) {

                        e.printStackTrace();
                    }

                    Scene scene = new Scene(root, 400, 400);
                    stage.setScene(scene);
                    stage.show();
                }
            }
        });

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                Pelicula peliculaSeleccionada = (Pelicula) t1;
                imageView.setImage(new Image(((Pelicula) t1).getPoster()));
            }
        });
    }

    private void lecturaJson() {

        tareaJSON = new Task() {
            @Override
            protected Object call() throws Exception {

                String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=4ef66e12cddbb8fe9d4fd03ac9632f6e&language=en-US&page=1";

                try {
                    InputStream inputStream = new URL(url).openStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                    //Para una linea
                    /*
                    String respuesta = bufferedReader.readLine();
                    JSONObject jsonObject = new JSONObject(respuesta);
                     */

                    //Para varias lineas se usa el while
                    String linea ="";
                    StringBuffer stringBuffer = new StringBuffer();

                    while ((linea=bufferedReader.readLine()) != null){
                        stringBuffer.append(linea);
                    }

                    JSONObject jsonObject = new JSONObject(stringBuffer.toString());
                    JSONArray arrayResultados = jsonObject.getJSONArray("results");

                    JSONObject objetoPelicula;
                    for (int i = 0; i < arrayResultados.length(); i++) {
                        objetoPelicula = arrayResultados.getJSONObject(i);
                        String titulo = objetoPelicula.getString("original_title");
                        String overview = objetoPelicula.getString("overview");
                        String poster = "https://image.tmdb.org/t/p/w500"+objetoPelicula.getString("poster_path");
                        int id = objetoPelicula.getInt("id");
                        double popularity = objetoPelicula.getDouble("popularity");

                        Pelicula pelicula = new Pelicula(titulo,overview,poster,id,popularity);
                        listaPeliculas.add(pelicula);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
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
        listView.setItems(listaPeliculas);
    }

    private void instancias() {

        listaCombo = FXCollections.observableArrayList();
        listaChoice = FXCollections.observableArrayList();
        listaPeliculas = FXCollections.observableArrayList();
    }

}