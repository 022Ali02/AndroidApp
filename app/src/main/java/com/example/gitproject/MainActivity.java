package com.example.gitproject.;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnCreateUser;
    private Button btnOpenLogin;
    private TextView tvStatus;

    // Название файла SharedPreferences
    private static final String PREFS_NAME = "MyPrefs";
    // Ключи для логина и пароля
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализируем View
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnCreateUser = findViewById(R.id.btnCreateUser);
        btnOpenLogin = findViewById(R.id.btnOpenLogin);
        tvStatus = findViewById(R.id.tvStatus);

        // Обработчик нажатия кнопки CREATE USER
        btnCreateUser.setOnClickListener(view -> createUser());

        // Переход на LoginActivity
        btnOpenLogin.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }

    private void createUser() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username/Password не могут быть пустыми", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_PASSWORD, password);
        editor.apply();

        tvStatus.setText("User Created Successfully");
        Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show();
    }
}
