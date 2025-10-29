package com.example.ejemplocomunicacionactividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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

        final TextView lblResultado = findViewById(R.id.lblResultado);

        //Creo uun objeto de tipo ResultLauncher para recoger la informacion  que que devuele .....

        ActivityResultLauncher resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK) {
                            Intent intent = result.getData();
                            if(intent != null) {
                                Bundle extras = intent.getExtras();
                                String resultado = extras.getString("boton_pulsado");
                                lblResultado.setText("Resultado: " + resultado);
                            }
                        }
                        else if(result.getResultCode() == Activity.RESULT_CANCELED) {
                            Toast.makeText(MainActivity.this, "Actividad cancelada", Toast.LENGTH_SHORT).show();
                            Intent intent = result.getData();

                            if(intent != null) {
                                Bundle extras = intent.getExtras();
                                if(extras != null) {
                                    String resultado = extras.getString("boton_pulsado");

                                    lblResultado.setText("Resultado: " + resultado);
                                }
                                else {
                                    Toast.makeText(MainActivity.this, "Intent vacio", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }
        );

        // Obtengo la informacin del EditText al pulsar el boton
        final EditText etNombre = findViewById(R.id.etNombre);
        final Button verificar = findViewById(R.id.btnVerificar);

        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etNombre.getText().toString();

                Intent intentCondiciones = new Intent(MainActivity.this, CondicionesUso.class);
                intentCondiciones.putExtra("usuario", usuario);

                resultLauncher.launch(intentCondiciones);
            }
        });
    }
}