package com.example.ejercicio5;

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
        datos.add(new Datos("Samuel Vergara Martín", "+34722688078"));
        datos.add(new Datos("Maria", "+348873928"));
        datos.add(new Datos("Pepe", "+3482837473"));
        datos.add(new Datos("Alba", "+349395750490"));


        final ListView listado = findViewById(R.id.listado);

        View cabezera = getLayoutInflater().inflate(R.layout.cabecera, null);
        listado.addHeaderView(cabezera);

        Adaptador adaptador = new Adaptador(this, datos);
        listado.setAdapter(adaptador);


        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nombre = ((Datos) parent.getItemAtPosition(position)).getNombre();
                Toast.makeText(MainActivity.this, "Llamando a " + nombre, Toast.LENGTH_SHORT).show();
            }
        });
    }
}