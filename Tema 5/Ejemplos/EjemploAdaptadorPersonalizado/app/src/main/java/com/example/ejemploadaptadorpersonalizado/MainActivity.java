package com.example.ejemploadaptadorpersonalizado;

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

        Datos[] datos = {
                new Datos("Linea superior 1", "Linea inferir  1"),
                new Datos("Linea superior 2", "Linea inferir  2"),
                new Datos("Linea superior 3", "Linea inferir  3"),
                new Datos("Linea superior 4", "Linea inferir  4"),
                new Datos("Linea superior 5", "Linea inferir  5"),

        };

        final ListView listado = findViewById(R.id.listado);

        //Incorporar la cabezera
        View miCabezera = getLayoutInflater().inflate(R.layout.cabezera, null);
        listado.addHeaderView(miCabezera);

        //Creo y asigno el adaptador

        Adaptador miAdaptador = new Adaptador(this, datos);
        listado.setAdapter(miAdaptador);

        //Inserto el listener

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position) == null) {
                    Toast.makeText(MainActivity.this, "Cabecera", Toast.LENGTH_SHORT).show();
                }
                else {
                    String seleccionado  = ((Datos) parent.getItemAtPosition(position)).getTexto1();
                    Toast.makeText(MainActivity.this, "Has  pulsado " + seleccionado, Toast.LENGTH_SHORT).show();

                    seleccionado  = ((Datos) parent.getItemAtPosition(position)).getTexto2();
                    Toast.makeText(MainActivity.this, "Has  pulsado " + seleccionado, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}