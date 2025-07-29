package com.example.notificadoreventos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnRegistro, btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegistro = findViewById(R.id.btnRegistro);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);

        btnRegistro.setOnClickListener(v -> startActivity(new Intent(this, RegistroActivity.class)));
        btnIniciarSesion.setOnClickListener(v -> startActivity(new Intent(this, IniciarSesionActivity.class)));
    }
}
