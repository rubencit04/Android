package com.example.a00_minicalculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        setContentView(R.layout.activity_main);

        Button sumar = findViewById(R.id.sumar);
        Button restar = findViewById(R.id.restar);
        Button multiplicar = findViewById(R.id.multiplicar);
        Button dividir = findViewById(R.id.dividir);
        Button potencia = findViewById(R.id.potencia);
        Button borrar = findViewById(R.id.borrar);
        EditText num1 = findViewById(R.id.num1);
        EditText num2 = findViewById(R.id.num2);
        TextView resultado = findViewById(R.id.resultado);

        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1Str = num1.getText().toString().trim();
                String num2Str = num2.getText().toString().trim();
                if(!num1Str.isBlank()&&!num2Str.isBlank()) {
                    double num1 = Double.parseDouble(num1Str);
                    double num2 = Double.parseDouble(num2Str);
                    resultado.setText("Resultado: " + (num1 + num2));
                }
            }
        });

        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1Str = num1.getText().toString().trim();
                String num2Str = num2.getText().toString().trim();
                if(!num1Str.isBlank()&&!num2Str.isBlank()) {
                    double num1 = Double.parseDouble(num1Str);
                    double num2 = Double.parseDouble(num2Str);
                    resultado.setText("Resultado: " + (num1 - num2));
                }
            }
        });

        multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1Str = num1.getText().toString().trim();
                String num2Str = num2.getText().toString().trim();
                if(!num1Str.isBlank()&&!num2Str.isBlank()) {
                    double num1 = Double.parseDouble(num1Str);
                    double num2 = Double.parseDouble(num2Str);
                    resultado.setText("Resultado: " + (num1 * num2));
                }
            }
        });
        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1Str = num1.getText().toString();
                String num2Str = num2.getText().toString();
                if(!num1Str.isBlank()&&!num2Str.isBlank()) {
                    double num1 = Double.parseDouble(num1Str);
                    double num2 = Double.parseDouble(num2Str);
                    resultado.setText("Resultado: " + (num1 / num2));
                }
            }
        });
        potencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1Str = num1.getText().toString().trim();
                String num2Str = num2.getText().toString().trim();
                if(!num1Str.isBlank()&&!num2Str.isBlank()) {
                    double num1 = Double.parseDouble(num1Str);
                    double num2 = Double.parseDouble(num2Str);
                    resultado.setText("Resultado: " + Math.pow(num1,num2));
                }
            }
        });
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1.setText("");
                num2.setText("");
                resultado.setText("");
            }
        });


    }
}