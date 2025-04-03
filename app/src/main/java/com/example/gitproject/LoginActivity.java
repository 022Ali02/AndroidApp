package com.example.gitproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsernameLogin;
    private EditText etPasswordLogin;
    private Button btnLogin;
    private TextView tvLoginStatus;

    // Название файла SharedPreferences и ключи (те же, что в MainActivity)
    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsernameLogin = findViewById(R.id.etUsernameLogin);
        etPasswordLogin = findViewById(R.id.etPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        tvLoginStatus = findViewById(R.id.tvLoginStatus);

        btnLogin.setOnClickListener(v -> checkLogin());
    }

    private void checkLogin() {
        String usernameInput = etUsernameLogin.getText().toString().trim();
        String passwordInput = etPasswordLogin.getText().toString().trim();

        // Получаем сохранённые в SharedPreferences данные
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString(KEY_USERNAME, "");
        String savedPassword = sharedPreferences.getString(KEY_PASSWORD, "");

        // Сравниваем
        if (usernameInput.equals(savedUsername) && passwordInput.equals(savedPassword)) {
            tvLoginStatus.setText("Login Successful");
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        } else {
            tvLoginStatus.setText("Login Failed");
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }
}
