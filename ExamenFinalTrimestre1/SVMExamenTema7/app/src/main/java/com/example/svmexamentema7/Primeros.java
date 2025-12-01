package com.example.svmexamentema7;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Primeros extends AppCompatActivity {

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_contextual_primeros, menu);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_primeros);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.primeros_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final Bundle bundle = getIntent().getExtras();
        final int colorFondoPagina = bundle.getInt("color_fondo");
        final LinearLayout pagina = findViewById(R.id.primeros_activity);

        pagina.setBackground(getDrawable(colorFondoPagina));

        final ArrayList<String> primeros = new ArrayList<>();
        primeros.add("Ensalada de queso de cabra");
        primeros.add("Crema de calabaza");
        primeros.add("Lentejas");
        primeros.add("Gazpacho");
        primeros.add("Consomé");

        final ListView listadoPrimeros = findViewById(R.id.listado_primeros);

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, primeros);
        listadoPrimeros.setAdapter(adaptador);

        listadoPrimeros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opcion = parent.getItemAtPosition(position).toString();
                if(opcion.equals("Ensalada de queso de cabra") || opcion.equals("Crema de calabaza")) {
                    registerForContextMenu(view);
                }
            }
        });

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        return super.onContextItemSelected(item);
    }
}