package com.example.recyclerviewvideojuegos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewvideojuegos.adaptador.AdaptadorVideoJuego;
import com.example.recyclerviewvideojuegos.entidad.VideoJuego;
import com.example.recyclerviewvideojuegos.singelton.ListaVideoJuegosSingelton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewUser;
    private AdaptadorVideoJuego adaptadorVideoJuego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerViewUser = findViewById(R.id.rViewVideoJuego);
        recyclerViewUser.setHasFixedSize(true);
        recyclerViewUser.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );

        ListaVideoJuegosSingelton.getInstance().inicializar();
        List<VideoJuego> listaVideoJuegos = ListaVideoJuegosSingelton.getInstance().getListaVideoJuegos();
        adaptadorVideoJuego = new AdaptadorVideoJuego(listaVideoJuegos);
        recyclerViewUser.setAdapter(adaptadorVideoJuego);

        Button añadir = findViewById(R.id.añadir);
        añadir.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, editar.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adaptadorVideoJuego.notifyDataSetChanged();
    }
}
