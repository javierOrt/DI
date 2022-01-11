package com.practicajson.manga;

import com.practicajson.manga.utils.Manga;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DetallesController {

    @FXML
    Label tituloManga;
    @FXML
    Label creadoManga;
    @FXML
    Label actualizadoManga;

    private MangaController mangaController;

    public void mostrarDetalles(Manga manga, MangaController mangaController) {
        this.mangaController = mangaController;
        tituloManga.setText("Titulo: "+manga.getTitulo());
        creadoManga.setText("Creado en: "+manga.getCreado());
        actualizadoManga.setText("Actualizado el: "+manga.getActualizado());
    }
}
