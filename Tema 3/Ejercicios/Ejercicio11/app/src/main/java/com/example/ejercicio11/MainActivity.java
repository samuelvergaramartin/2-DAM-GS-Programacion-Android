package com.example.ejercicio11;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final EditText userInput = findViewById(R.id.user_input);
        final EditText passwordInput = findViewById(R.id.password_input);
        final Button loginButton = findViewById(R.id.login_button);
        final TextView forgottenPasswordText = findViewById(R.id.forgotten_password_text);
        final String userInputPlaceholder = userInput.getText().toString();
        final String passwordInputPlaceholder = passwordInput.getText().toString();
        final int passwordInputType = EditorInfo.TYPE_TEXT_VARIATION_PASSWORD + 1;

        passwordInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if(passwordInput.getInputType() != passwordInputType && !passwordInput.getText().toString().equals(passwordInputPlaceholder)) {
                    passwordInput.setInputType(passwordInputType);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        passwordInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userInput.getText().toString().isEmpty()) userInput.setText(userInputPlaceholder);
            }
        });

        userInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passwordInput.getText().toString().isEmpty()) {
                    passwordInput.setText(passwordInputPlaceholder);
                    passwordInput.setInputType(EditorInfo.TYPE_CLASS_TEXT);
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toaster = new Toast(getApplicationContext());
                toaster.setDuration(Toast.LENGTH_LONG);

                if(userInput.getText().toString().equals("root") && passwordInput.getText().toString().equals("root")) {
                    toaster.setText("Has iniciado sesión correctamente");
                    toaster.show();
                    Intent accountActivity = new Intent(MainActivity.this, AccountActivity.class);
                    startActivity(accountActivity);
                }
                else {
                    toaster.setText("Error: Credenciales inválidas");
                    toaster.show();
                }
            }
        });

        forgottenPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recoveryPassword = new Intent(MainActivity.this, RecoveryPassword.class);
                startActivity(recoveryPassword);
            }
        });
    }
}