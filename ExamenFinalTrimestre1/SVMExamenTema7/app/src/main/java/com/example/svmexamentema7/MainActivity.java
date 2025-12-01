package com.example.svmexamentema7;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher resultLauncher;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

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

        resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK) {
                            Toast.makeText(MainActivity.this, "En construcción", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        Toolbar toolbar = findViewById(R.id.action_bar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.opc_primeros) {
            Intent actividadPrimeros = new Intent(MainActivity.this, Primeros.class);
            actividadPrimeros.putExtra("color_fondo", R.color.background_main_page);

            startActivity(actividadPrimeros);
        }
        if(item.getItemId() == R.id.opc_segundos) {
            Intent actividadSegundos = new Intent(MainActivity.this, Segundos.class);
            startActivity(actividadSegundos);
        }

        if(item.getItemId() == R.id.opc_keto) {
            Intent paginaWeb = new Intent(Intent.ACTION_VIEW);
            paginaWeb.setData(Uri.parse("https://www.quironsalud.com/blogs/es/objetivo-peso-saludable/hacer-dieta-keto-forma-segura-adios-dietas-milagro-pasar-ha"));
            startActivity(paginaWeb);
        }

        if(item.getItemId() == R.id.opc_sugerencias) {
            Intent correo = new Intent(Intent.ACTION_SENDTO);
            correo.setData(Uri.parse("mailto:sugerencias@gmail.com"));
            startActivity(correo);
        }

        if(item.getItemId() == R.id.opc_postres) {
            Intent postresActivity = new Intent(MainActivity.this, Postres.class);
            postresActivity.putExtra("color", R.color.postres);
            resultLauncher.launch(postresActivity);
        }

        return super.onOptionsItemSelected(item);
    }
}