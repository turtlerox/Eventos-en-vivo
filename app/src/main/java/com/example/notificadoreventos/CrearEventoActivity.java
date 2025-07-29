// desde aqui se corrige
package com.example.notificadoreventos;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.notificadoreventos.clases.Evento;
import com.example.notificadoreventos.util.DatosApp;

import java.util.*;

public class CrearEventoActivity extends AppCompatActivity {
    Spinner spinnerCategoria;
    EditText txtFecha, txtHora, txtLugar, txtDescripcion;
    Button btnCrear;

    String[] categorias = {"Conciertos", "Eventos Deportivos", "Cursos", "Conferencias", "Talleres"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_evento);

        spinnerCategoria = findViewById(R.id.spinnerCategoria);
        txtFecha = findViewById(R.id.txtFecha);
        txtHora = findViewById(R.id.txtHora);
        txtLugar = findViewById(R.id.txtLugar);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        btnCrear = findViewById(R.id.btnCrear);

        // Adaptador con layout desplegable corregido
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categorias);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // línea clave
        spinnerCategoria.setAdapter(adapter);

        txtFecha.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            new DatePickerDialog(this, (view, year, month, day) -> {
                txtFecha.setText(day + "/" + (month + 1) + "/" + year);
            }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
        });

        txtHora.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            new TimePickerDialog(this, (view, hour, minute) -> {
                txtHora.setText(hour + ":" + String.format("%02d", minute));
            }, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), true).show();
        });

        btnCrear.setOnClickListener(v -> {
            String categoria = spinnerCategoria.getSelectedItem().toString();
            String fecha = txtFecha.getText().toString();
            String hora = txtHora.getText().toString();
            String lugar = txtLugar.getText().toString();
            String descripcion = txtDescripcion.getText().toString();

            Evento e = new Evento(categoria, fecha, hora, lugar, descripcion);
            DatosApp.getInstancia().crearEvento(e);
            Toast.makeText(this, "Evento creado y notificado", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
