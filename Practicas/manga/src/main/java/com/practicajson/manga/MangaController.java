package com.practicajson.manga;

import com.practicajson.manga.utils.Manga;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

public class MangaController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    Button btnAccion,btnAventura,btnRomance,btnAdulto,btnDetalles;

    @FXML
    ListView listViewMangas;

    @FXML
    ImageView imageManga;

    @FXML
    TextArea textAreaSinopsis;

    private ObservableList<Manga> listaMangas;
    private String url;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarElementos();
        acciones();
    }

    private void acciones() {
        listViewMangas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {

                Manga mangaSeleccionado = (Manga) t1;

                if (mangaSeleccionado!=null){

                    imageManga.setImage(new Image(mangaSeleccionado.getImagen()));
                    textAreaSinopsis.setText(mangaSeleccionado.getDescripcion());
                }
            }
        });
    }

    private void asociarElementos() {
        listViewMangas.setItems(listaMangas);
    }

    private void instancias() {

        btnAccion.setOnAction(this);
        btnAventura.setOnAction(this);
        btnRomance.setOnAction(this);
        btnAdulto.setOnAction(this);
        btnDetalles.setOnAction(this);

        listaMangas = FXCollections.observableArrayList();
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        if (btnDetalles.equals(source) && !(listViewMangas.getSelectionModel().getSelectedIndex()<0)){

            Stage stage = new Stage();
            FXMLLoader loader = null;
            Parent root = null;
            DetallesController detallesController = null;
            try {
                loader = new FXMLLoader(getClass().getResource("detalles-view.fxml"));
                root = loader.load();
                detallesController = loader.getController();
                detallesController.mostrarDetalles((Manga) listViewMangas.getSelectionModel().getSelectedItem(),MangaController.this);
            } catch (IOException e) {
                e.printStackTrace();
            }

            assert root != null;
            Scene scene = new Scene(root,400,400);
            stage.setScene(scene);
            stage.setTitle("Detalles");
            stage.show();
        }

        listaMangas.clear();

        if (btnAccion.equals(source)) {
            url = "https://kitsu.io/api/edge/manga?filter[categories]=action";
        } else if (btnAventura.equals(source)) {
            url = "https://kitsu.io/api/edge/manga?filter[categories]=adventure";
        } else if (btnRomance.equals(source)) {
            url = "https://kitsu.io/api/edge/manga?filter[categories]=love";
        }else if (btnAdulto.equals(source)) {
            url = "https://kitsu.io/api/edge/manga?filter[categories]=seinen";
        }


        try {
            InputStream inputStream = new URL(url).openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String linea ="";
            StringBuffer stringBuffer = new StringBuffer();

            while ((linea=bufferedReader.readLine()) != null){
                stringBuffer.append(linea);
            }

            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            JSONArray arrayData = jsonObject.getJSONArray("data");

            for (int i = 0; i < arrayData.length(); i++) {

                JSONObject objetoData = arrayData.getJSONObject(i);
                JSONObject attributes = objetoData.getJSONObject("attributes");
                String descripcion = attributes.getString("description");
                String titulo = attributes.getString("slug");
                String creado = attributes.getString("createdAt");
                String actualizado = attributes.getString("updatedAt");
                JSONObject origenImagen = attributes.getJSONObject("posterImage");
                String imagen = origenImagen.getString("large");

                Manga manga = new Manga(titulo,descripcion,imagen,creado,actualizado);
                listaMangas.add(manga);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}