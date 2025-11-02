package com.example.ejercicio4;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

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

        final LinearLayout mainLayout = findViewById(R.id.main);
        final Spinner spinner = findViewById(R.id.mainSpinner);
        final ImageButton spiderButton = findViewById(R.id.spiderButton);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_options, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final ActivityResultLauncher tratoActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK) {
                            Intent intent = result.getData();
                            if(intent != null) {
                                Bundle extras = intent.getExtras();
                                String option = extras.getString("option");
                                if(option.equals("Fantasmas")) {
                                    spiderButton.setImageResource(R.drawable.fantasma);
                                }
                                else {
                                    spiderButton.setImageResource(R.drawable.calabaza);
                                }

                                mainLayout.setBackgroundColor(getResources().getColor(R.color.orange));
                            }
                        }
                    }
                }
        );

        final ActivityResultLauncher trucoActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK) {
                            final Drawable fondo6 = getDrawable(R.drawable.fondo6);
                            if(!mainLayout.getBackground().equals(fondo6)) {
                                mainLayout.setBackground(fondo6);
                            }
                        }
                    }
                }
        );

        spiderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String option = spinner.getSelectedItem().toString();
                Intent activity;

                if(option.equals("Trato")) {
                    activity = new Intent(MainActivity.this, TratoActivity.class);
                    tratoActivityResultLauncher.launch(activity);
                }
                else {
                    activity = new Intent(MainActivity.this, TrucoActivity.class);
                    trucoActivityResultLauncher.launch(activity);
                }
            }
        });
    }
}