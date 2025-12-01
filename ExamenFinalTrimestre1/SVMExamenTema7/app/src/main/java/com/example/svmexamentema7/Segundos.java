package com.example.svmexamentema7;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Segundos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segundos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.segundos_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final ArrayList<String> pastas = new ArrayList<>();
        pastas.add("Espaguetis a la carbonara");
        pastas.add("Macarrones a la boloñesa");
        pastas.add("Espaguetis aglio e olio");
        pastas.add("Fetuccini a la marinera");
        pastas.add("Penne all'arrabbiata");

        final ArrayList<String> segundos = new ArrayList<>();
        segundos.add("Seleccione una opción");
        segundos.add("Pasta");
        segundos.add("Carne");
        segundos.add("Arroces");

        final GridView gridView = findViewById(R.id.gridview);
        final ArrayAdapter<String> adaptadorGrid = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pastas);
        final ArrayAdapter<String> adaptadorSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, segundos);
        final Spinner spinner = findViewById(R.id.spinner_segundos);

        gridView.setAdapter(adaptadorGrid);

        spinner.setAdapter(adaptadorSpinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String opcion = parent.getItemAtPosition(position).toString();

                if(opcion.equals("Pasta")) {
                    gridView.setVisibility(View.VISIBLE);
                }
                else {
                    gridView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}