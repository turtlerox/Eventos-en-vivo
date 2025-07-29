// VerNotificacionesActivity.java
package com.example.notificadoreventos;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.notificadoreventos.util.DatosApp;

public class VerNotificacionesActivity extends AppCompatActivity {
    ListView listaNotificaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_notificaciones);

        listaNotificaciones = findViewById(R.id.listaNotificaciones);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                DatosApp.getInstancia().getEventosInteres());
        listaNotificaciones.setAdapter(adapter);
    }
}
