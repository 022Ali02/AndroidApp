package com.example.gitproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText etUsernameSignUp;
    private EditText etPasswordSignUp;
    private Button btnCreateUser;
    private TextView tvSignUpStatus;

    // Название файла SharedPreferences
    private static final String PREFS_NAME = "MyPrefs";
    // Ключи для логина и пароля
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUsernameSignUp = findViewById(R.id.etUsernameSignUp);
        etPasswordSignUp = findViewById(R.id.etPasswordSignUp);
        btnCreateUser = findViewById(R.id.btnCreateUser);
        tvSignUpStatus = findViewById(R.id.tvSignUpStatus);

        btnCreateUser.setOnClickListener(v -> createUser());
    }

    private void createUser() {
        String username = etUsernameSignUp.getText().toString().trim();
        String password = etPasswordSignUp.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username/Password не могут быть пустыми", Toast.LENGTH_SHORT).show();
            return;
        }

        // Сохраняем в SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_PASSWORD, password);
        editor.apply();

        tvSignUpStatus.setText("User Created Successfully");
        Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show();

        // Закрываем SignUpActivity и возвращаемся на LoginActivity
        finish();
    }
}
