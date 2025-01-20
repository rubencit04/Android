package com.example.recyclerviewvideojuegos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewvideojuegos.adaptador.AdaptadorVideoJuego;


public class editar extends AppCompatActivity {
    private RecyclerView recyclerViewUser;
    private AdaptadorVideoJuego adaptadorVideoJuego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.editar);

        Button guardar = findViewById(R.id.guardar);
        guardar.setOnClickListener(view -> {
            Intent intent = new Intent(editar.this, MainActivity.class);
            startActivity(intent);
        });

    }
}