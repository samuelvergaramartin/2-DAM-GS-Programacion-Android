package com.example.ejercicio4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TratoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trato);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tratoActivity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final TextView fantasmasText = findViewById(R.id.fantasmasText);
        final TextView calabazasText = findViewById(R.id.calabazasText);

        fantasmasText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                intent.putExtra("option", "Fantasmas");
                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });

        calabazasText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                intent.putExtra("option", "Calabazas");
                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });
    }
}