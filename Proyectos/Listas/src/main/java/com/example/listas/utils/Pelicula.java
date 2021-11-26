package com.example.listas.utils;

public class Pelicula {
    private String titulo,overview,poster;
    private int id;
    private double popularidad;

    public Pelicula(String titulo, String overview, String poster, int id, double popularidad) {
        this.titulo = titulo;
        this.overview = overview;
        this.poster = poster;
        this.id = id;
        this.popularidad = popularidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(double popularidad) {
        this.popularidad = popularidad;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
