package com.example.ejemplocontextmenulistas;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listado;

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

        // Recupero listado
        listado = findViewById(R.id.listado);

        // Creo los datos
        ArrayList<String> datos = new ArrayList<>();
        datos.add("Elemento 1");
        datos.add("Elemento 2");
        datos.add("Elemento 3");

        // Creo el  adaptador

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datos);
        listado.setAdapter(adapter);

        // Pongo que va a tener el menu contextual al listado
        registerForContextMenu(listado);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        menu.setHeaderTitle(listado.getAdapter().getItem(info.position).toString().toUpperCase());

        switch (info.position) {
            case 0: {
                inflater.inflate(R.menu.menu_c1, menu);
                break;
            }
            case 1: {
                inflater.inflate(R.menu.menu_c2, menu);
                break;
            }
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String texto;
        int id = item.getItemId();

        if(id == R.id.mcOp1 || id == R.id.mcOp2 || id == R.id.mcOp3) {
            texto = item.getTitle().toString();
            Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
        }

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        texto = listado.getItemAtPosition(info.position).toString();

        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();

        return super.onContextItemSelected(item);
    }
}