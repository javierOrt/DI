package com.practicajson.manga.utils;

public class Manga {

    private String titulo,descripcion,imagen,creado,actualizado;

    public Manga(String titulo, String descripcion, String imagen, String creado, String actualizado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCreado() {
        return creado;
    }

    public void setCreado(String creado) {
        this.creado = creado;
    }

    public String getActualizado() {
        return actualizado;
    }

    public void setActualizado(String actualizado) {
        this.actualizado = actualizado;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
