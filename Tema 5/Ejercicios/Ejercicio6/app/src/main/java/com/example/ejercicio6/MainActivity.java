package com.example.ejercicio6;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<Datos> datos = new ArrayList<>();
        datos.add(new Datos("DONUTS", "Descripción de Donuts"));
        datos.add(new Datos("FROYOS", "Descripción de Froyos"));
        datos.add(new Datos("GINGERBREAD", "Descripcion de Gingerbread"));
        datos.add(new Datos("HONEYCOMB", "Descripción de Honeycomb"));
        datos.add(new Datos("ICE CREAM", "Descripción de Ice Cream"));
        datos.add(new Datos("JELLY BEAN", "Descripción de Jelly Bean"));
        datos.add(new Datos("KITKAT", "Descripción de KitKat"));
        datos.add(new Datos("LOLLYPOP", "Descipción de Lollypop"));

        ListView listado = findViewById(R.id.listado);

        Adaptador adaptador = new Adaptador(this, datos);
        listado.setAdapter(adaptador);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String texto = ((Datos) parent.getItemAtPosition(position)).getTexto();
                Toast.makeText(MainActivity.this, texto, Toast.LENGTH_SHORT).show();
            }
        });
    }
}