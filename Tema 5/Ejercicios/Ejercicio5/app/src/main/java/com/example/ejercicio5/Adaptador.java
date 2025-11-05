package com.example.ejercicio5;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter<Datos> {
    private ArrayList<Datos> datos;
    public Adaptador(@NonNull Context context, ArrayList<Datos> datos) {
        super(context, R.layout.contacto, datos);
        this.datos = datos;
    }

    
}
