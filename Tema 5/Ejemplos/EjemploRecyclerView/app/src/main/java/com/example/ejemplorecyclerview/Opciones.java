package com.example.ejemplorecyclerview;

public class Opciones {
    private String titulo;
    private String subtitulo;
    private int icono;

    public Opciones(String titulo, String subtitulo, int icono) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.icono = icono;
    }

    public int getIcono() {
        return icono;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
