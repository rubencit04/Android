package com.example.calculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String usuario1 = getIntent().getStringExtra(login.K_NOMBRE_USUARIO);
        TextView usuario = findViewById(R.id.usuario);
        TextView resultado = findViewById(R.id.result);
        Button punto = findViewById(R.id.btn_punto);
        Button sumar = findViewById(R.id.btn_sumar);
        Button restar = findViewById(R.id.btn_restar);
        Button mult = findViewById(R.id.btn_mult);
        Button div = findViewById(R.id.btn_div);
        usuario.setText("Bienvenido a la calculadora "+usuario1);
    }

}