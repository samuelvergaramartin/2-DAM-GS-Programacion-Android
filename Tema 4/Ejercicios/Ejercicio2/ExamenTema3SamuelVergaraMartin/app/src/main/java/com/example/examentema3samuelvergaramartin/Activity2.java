package com.example.examentema3samuelvergaramartin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final TextView text1 = findViewById(R.id.text1_activity2);
        final TextView text2 = findViewById(R.id.text2_activity2);
        final TextView text3 = findViewById(R.id.text3_activity2);
        final TextView text4 = findViewById(R.id.text4_activity2);
        final TextView text5 = findViewById(R.id.text5_activity2);
        final String toastMessage = "Futuro Intent";

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity2.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity2.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity2.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad3 = new Intent(Activity2.this, Activity3.class);
                startActivity(actividad3);
            }
        });

        text5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad3 = new Intent(Activity2.this, MainActivity.class);
                startActivity(actividad3);
            }
        });
    }
}