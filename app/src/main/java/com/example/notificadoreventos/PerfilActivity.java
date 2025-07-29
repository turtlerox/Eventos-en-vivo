package com.example.notificadoreventos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.notificadoreventos.util.DatosApp;

public class PerfilActivity extends AppCompatActivity {
    TextView txtUsuario;
    Button btnCrearEvento, btnVerEventos, btnVerNotificaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        txtUsuario = findViewById(R.id.txtUsuarioLog);
        btnCrearEvento = findViewById(R.id.btnCrearEvento);
        btnVerEventos = findViewById(R.id.btnVerEventos);
        btnVerNotificaciones = findViewById(R.id.btnVerNotificaciones);

        txtUsuario.setText("Bienvenido: " + DatosApp.getInstancia().getUsuarioActual().getNombre());

        btnCrearEvento.setOnClickListener(v -> startActivity(new Intent(this, CrearEventoActivity.class)));
        btnVerEventos.setOnClickListener(v -> startActivity(new Intent(this, VerEventosActivity.class)));
        btnVerNotificaciones.setOnClickListener(v -> startActivity(new Intent(this, VerNotificacionesActivity.class)));
    }
}
