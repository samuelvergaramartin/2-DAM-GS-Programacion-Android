package com.example.ejercicio7;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter<Datos> {
    private ArrayList<Datos> datos;

    public Adaptador(@NonNull Context context, Datos datos) {
        super(context, R.layout.elemento);
    }
}
