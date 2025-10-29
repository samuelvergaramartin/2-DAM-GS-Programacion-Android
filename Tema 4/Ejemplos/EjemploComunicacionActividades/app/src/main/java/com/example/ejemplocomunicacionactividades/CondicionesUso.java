package com.example.ejemplocomunicacionactividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CondicionesUso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_condiciones_uso);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layoutCondiciones), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final TextView lblMensaje = findViewById(R.id.lblMensaje);

        // Obtengoo la informacion de mi intent

        Bundle extras = getIntent().getExtras();
        String usuario = extras.getString("usuario");

        // Muestro  un  saludo  en el  textView

        lblMensaje.setText("Hola " + usuario + ". ¿Aceptas las condiciones?");
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        // Comprobamos que vista (boton) ha invocado

        int id = view.getId();

        if(id == R.id.btnAceptar) {
            intent.putExtra("boton_pulsado", "Aceptar");
            setResult(RESULT_OK, intent);
        }
        else if(id == R.id.btnRechazar) {
            intent.putExtra("boton_pulsado", "Rechazar");
            setResult(RESULT_OK, intent);
        }
        else if(id == R.id.btnCancelar)  {
            //EL intent es innecesario , lo pongo para mostrarlo en el  ejemplo
            // cuando muestre informacion en la actividad 1
            intent.putExtra("boton_pulsado", "Cancelar actividad");
            //setResult(RESULT_CANCELED, intent);
            setResult(RESULT_CANCELED);
        }

        finish();
    }
}