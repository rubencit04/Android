package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {
    private Button botonSiguienteActividad;
    private EditText textoNombreUsuario;
    public final static String K_NOMBRE_USUARIO = "nombre";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        botonSiguienteActividad = findViewById(R.id.login);
        textoNombreUsuario = findViewById(R.id.nombre);

        botonSiguienteActividad.setOnClickListener(view -> {

            Intent intent = new Intent(login.this,MainActivity.class);
            String nombreUsuario = textoNombreUsuario.getText().toString();

            intent.putExtra(K_NOMBRE_USUARIO, nombreUsuario);
            startActivity(intent);
        });

    }
}


