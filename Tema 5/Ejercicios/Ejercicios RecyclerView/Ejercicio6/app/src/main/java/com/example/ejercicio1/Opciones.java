package com.example.ejercicio1;

public class Opciones {
    private int imagen;
    private String titulo;
    private String texto;

    public Opciones(int imagen, String titulo, String texto) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.texto = texto;
    }

    public int getImagen() {
        return imagen;
    }

    public String getTexto() {
        return texto;
    }

    public String getTitulo() {
        return titulo;
    }
}
