package com.example.ejemplofragments;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
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

        final View view1 = findViewById(R.id.view1);
        final View view2 = findViewById(R.id.view2);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.miFragmentContainerView, Fragment1.class, null)
                .commit();

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.setBackgroundColor(getResources().getColor(R.color.red));
                view2.setBackgroundColor(getResources().getColor(R.color.grey));

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.miFragmentContainerView, Fragment1.class, null)
                        .commit();
            }
        });

        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.setBackgroundColor(getResources().getColor(R.color.grey));
                view2.setBackgroundColor(getResources().getColor(R.color.red));

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.miFragmentContainerView, Fragment2.class, null)
                        .commit();
            }
        });

    }
}