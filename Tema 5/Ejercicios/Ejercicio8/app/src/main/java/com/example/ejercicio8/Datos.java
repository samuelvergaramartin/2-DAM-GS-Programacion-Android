package com.example.ejercicio8;

public class Datos {
    private int imagen;
    private String texto;
    private boolean checked;

    public Datos(int imagen, String texto) {
        this.imagen = imagen;
        this.texto = texto;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getTexto() {
        return texto;
    }

    public int getImagen() {
        return imagen;
    }

    public boolean isChecked() {
        return checked;
    }
}
