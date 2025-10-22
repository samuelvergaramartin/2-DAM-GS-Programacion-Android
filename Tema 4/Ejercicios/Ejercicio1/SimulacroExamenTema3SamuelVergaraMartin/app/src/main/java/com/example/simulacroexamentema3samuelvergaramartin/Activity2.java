package com.example.simulacroexamentema3samuelvergaramartin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        final Button button1 = findViewById(R.id.activity2_button1);
        final Button button2 = findViewById(R.id.activity2_button2);
        final Button button3 = findViewById(R.id.activity2_button3);
        final Button button4 = findViewById(R.id.activity2_button4);
        final Button buttonActivity1 = findViewById(R.id.botonActividad1);
        final Button buttonActivity3 = findViewById(R.id.botonActividad3);
        final int defaultColor = Color.rgb(247,193,234), clickedColor = Color.rgb(243,230,248);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundColor(clickedColor);
                button2.setBackgroundColor(defaultColor);
                button3.setBackgroundColor(defaultColor);
                button4.setBackgroundColor(defaultColor);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundColor(defaultColor);
                button2.setBackgroundColor(clickedColor);
                button3.setBackgroundColor(defaultColor);
                button4.setBackgroundColor(defaultColor);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundColor(defaultColor);
                button2.setBackgroundColor(defaultColor);
                button3.setBackgroundColor(clickedColor);
                button4.setBackgroundColor(defaultColor);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity2.this, "Accediendo a la siguiente pantalla", Toast.LENGTH_SHORT).show();
            }
        });

        buttonActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad1 = new Intent(Activity2.this, MainActivity.class);
                startActivity(actividad1);
            }
        });

        buttonActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad3 = new Intent(Activity2.this, Activity3.class);
                startActivity(actividad3);
            }
        });
    }
}