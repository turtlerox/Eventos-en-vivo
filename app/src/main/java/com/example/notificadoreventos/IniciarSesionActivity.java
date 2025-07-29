package com.example.notificadoreventos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.notificadoreventos.util.DatosApp;

public class IniciarSesionActivity extends AppCompatActivity {
    EditText txtUsuario, txtContrasena;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        txtUsuario = findViewById(R.id.txtUsuario);
        txtContrasena = findViewById(R.id.txtContrasena);
        btnIngresar = findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(v -> {
            String user = txtUsuario.getText().toString();
            String pass = txtContrasena.getText().toString();

            if (DatosApp.getInstancia().iniciarSesion(user, pass)) {
                startActivity(new Intent(this, PerfilActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
