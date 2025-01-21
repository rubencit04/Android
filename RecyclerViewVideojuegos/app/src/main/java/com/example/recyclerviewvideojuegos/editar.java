package com.example.recyclerviewvideojuegos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewvideojuegos.adaptador.AdaptadorVideoJuego;
import com.example.recyclerviewvideojuegos.entidad.VideoJuego;
import com.example.recyclerviewvideojuegos.singelton.ListaVideoJuegosSingelton;


public class editar extends AppCompatActivity {
    private RecyclerView recyclerViewUser;
    private AdaptadorVideoJuego adaptadorVideoJuego;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.editar);

        EditText edtnombre = findViewById(R.id.edtNombre);
        EditText edtfechaCreacion = findViewById(R.id.edtFecha);
        EditText edtpuntuacion = findViewById(R.id.edtPuntuacion);

        int id = getIntent().getIntExtra("videojuego_id",-1);
        String nombre = getIntent().getStringExtra("videojuego_nombre");
        String fecha = getIntent().getStringExtra("videojuego_fecha");
        int puntuacion = getIntent().getIntExtra("videojuego_puntuacion", 0);

        edtnombre.setText(nombre);
        edtfechaCreacion.setText(fecha);
        edtpuntuacion.setText(String.valueOf(puntuacion));
        Button guardar = findViewById(R.id.guardar);

        guardar.setOnClickListener(view -> {
            String nombreRecibido = edtnombre.getText().toString();
            String fechaRecibido = edtfechaCreacion.getText().toString();
            String puntuacionRecibido = edtpuntuacion.getText().toString();

            int puntuacionanumero = Integer.parseInt(puntuacionRecibido);

            if(id!=-1) {
                VideoJuego videojuego = ListaVideoJuegosSingelton.getInstance().getVideoJuegoById(id);
                videojuego.setNombre(nombreRecibido);
                videojuego.setFechaCreacion(fechaRecibido);
                videojuego.setPuntuacion(puntuacionanumero);
            }else{
                VideoJuego nuevoVideojuego = new VideoJuego();
                nuevoVideojuego.setNombre(nombreRecibido);
                nuevoVideojuego.setFechaCreacion(fechaRecibido);
                nuevoVideojuego.setPuntuacion(puntuacionanumero);
                ListaVideoJuegosSingelton.getInstance().agregar(nuevoVideojuego);
            }


            finish();
        });

    }
}