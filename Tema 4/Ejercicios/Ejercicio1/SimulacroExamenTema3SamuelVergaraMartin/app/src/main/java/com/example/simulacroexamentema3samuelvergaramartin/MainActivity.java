package com.example.simulacroexamentema3samuelvergaramartin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText userInput = findViewById(R.id.activity_main_user_input);
        EditText passwordInput = findViewById(R.id.activity_main_password_input);
        Button activityMainButton = findViewById(R.id.activity_main_button);
        Button activity2Button =  findViewById(R.id.botonActividad2);
        Button activity3Button = findViewById(R.id.botonActividad3);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                userInput.setVisibility(View.VISIBLE);
                passwordInput.setVisibility(View.VISIBLE);
                activityMainButton.setVisibility(View.VISIBLE);
                activity2Button.setVisibility(View.VISIBLE);
                activity3Button.setVisibility(View.VISIBLE);

                activityMainButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(userInput.getText().toString().isEmpty() || passwordInput.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity.this, "Introoduce usuario y clave", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Hola Samuel. Accediendo a la app", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                activity2Button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent actividad2 = new Intent(MainActivity.this, Activity2.class);
                        startActivity(actividad2);
                    }
                });

                activity3Button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent actividad3 = new Intent(MainActivity.this, Activity3.class);
                        startActivity(actividad3);
                    }
                });
            }
        },3000);
    }
}