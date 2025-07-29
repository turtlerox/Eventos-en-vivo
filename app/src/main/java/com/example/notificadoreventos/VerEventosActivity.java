package com.example.notificadoreventos;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.notificadoreventos.util.DatosApp;

public class VerEventosActivity extends AppCompatActivity {
    ListView listaEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_eventos);

        listaEventos = findViewById(R.id.listaEventos);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                DatosApp.getInstancia().listarEventosTexto());
        listaEventos.setAdapter(adapter);
    }
}
