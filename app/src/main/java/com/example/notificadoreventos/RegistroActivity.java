package com.example.notificadoreventos;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.notificadoreventos.clases.Usuario;
import com.example.notificadoreventos.util.DatosApp;

public class RegistroActivity extends AppCompatActivity {
    EditText txtUsuario, txtContrasena;
    CheckBox[] categorias;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtUsuario = findViewById(R.id.txtUsuario);
        txtContrasena = findViewById(R.id.txtContrasena);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        categorias = new CheckBox[] {
                findViewById(R.id.chkConciertos),
                findViewById(R.id.chkEventosDeportivos),
                findViewById(R.id.chkCursos),
                findViewById(R.id.chkConferencias),
                findViewById(R.id.chkTalleres)
        };

        btnRegistrar.setOnClickListener(v -> {
            String nombre = txtUsuario.getText().toString();
            String pass = txtContrasena.getText().toString();
            if (nombre.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            Usuario nuevo = new Usuario(nombre, pass);
            for (CheckBox c : categorias) {
                if (c.isChecked()) {
                    nuevo.agregarCategoria(c.getText().toString());
                }
            }
            DatosApp.getInstancia().registrarUsuario(nuevo);
            Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
