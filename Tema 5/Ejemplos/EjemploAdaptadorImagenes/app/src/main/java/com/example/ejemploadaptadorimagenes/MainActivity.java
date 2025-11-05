package com.example.ejemploadaptadorimagenes;

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

        //Defino los datos
        ArrayList<Datos> datos = new ArrayList<>();
        datos.add(new Datos(R.drawable.consola, "Consola"));
        datos.add(new Datos(R.drawable.ordenador_fijo, "Ordenador fijo"));
        datos.add(new Datos(R.drawable.ordenador_portatil, "Ordenador portatil"));
        datos.add(new Datos(R.drawable.reloj, "Reloj"));
        datos.add(new Datos(R.drawable.smartphone, "Smartphone"));
        datos.add(new Datos(R.drawable.tablet, "Tablet"));
        datos.add(new Datos(R.drawable.tv, "Televisión"));

        //Instancio el  listado
        final ListView listado  = findViewById(R.id.listado);

        // Creo el adaptador
        Adaptador miAdaptador = new Adaptador(datos, this);
        listado.setAdapter(miAdaptador);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seleccionado = ((Datos) parent.getItemAtPosition(position)).getTexto();
                Toast.makeText(MainActivity.this, seleccionado, Toast.LENGTH_SHORT).show();


            }
        });
    }
}