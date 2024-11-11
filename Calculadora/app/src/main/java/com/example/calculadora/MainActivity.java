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
    private double resultado2 = 0;
    private String operacion = "";
    private boolean isNuevoNumero = true;

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
        usuario.setText("Bienvenido a la calculadora " + usuario1);
        TextView resultado = findViewById(R.id.result);
        Button punto = findViewById(R.id.btn_punto);
        Button sumar = findViewById(R.id.btn_sumar);
        Button restar = findViewById(R.id.btn_restar);
        Button mult = findViewById(R.id.btn_mult);
        Button div = findViewById(R.id.btn_div);
        Button borrar = findViewById(R.id.btn_C);
        Button cero = findViewById(R.id.btn_0);
        Button uno = findViewById(R.id.btn_1);
        Button dos = findViewById(R.id.btn_2);
        Button tres = findViewById(R.id.btn_3);
        Button cuatro = findViewById(R.id.btn_4);
        Button cinco = findViewById(R.id.btn_5);
        Button seis = findViewById(R.id.btn_6);
        Button siete = findViewById(R.id.btn_7);
        Button ocho = findViewById(R.id.btn_8);
        Button nueve = findViewById(R.id.btn_9);
        Button igual = findViewById(R.id.btn_equals);

        setButtonClickListener(uno, "1", resultado);
        setButtonClickListener(dos, "2", resultado);
        setButtonClickListener(tres, "3", resultado);
        setButtonClickListener(cuatro, "4", resultado);
        setButtonClickListener(cinco, "5", resultado);
        setButtonClickListener(seis, "6", resultado);
        setButtonClickListener(siete, "7", resultado);
        setButtonClickListener(ocho, "8", resultado);
        setButtonClickListener(nueve, "9", resultado);
        setButtonClickListener(cero, "0", resultado);
        setButtonClickListener(punto, ".", resultado);


        sumar.setOnClickListener(v -> realizarOperacion(resultado, "+"));
        restar.setOnClickListener(v -> realizarOperacion(resultado, "-"));
        mult.setOnClickListener(v -> realizarOperacion(resultado, "*"));
        div.setOnClickListener(v -> realizarOperacion(resultado, "/"));

        igual.setOnClickListener(v -> calcularResultado(resultado));

        borrar.setOnClickListener(v -> {
            resultado.setText("0");
            resultado2 = 0;
            operacion = "";
        });
    }

    private void setButtonClickListener(Button button, String value, TextView resultadoView) {
        button.setOnClickListener(v -> {
            // Si el resultado es 0 (o está vacío), sustituirlo por el valor pulsado
            if (resultadoView.getText().toString().equals("0")) {
                resultadoView.setText(value);
            } else {
                // Si no, agregar el valor al texto actual
                resultadoView.append(value);
            }
        });
    }

    private void realizarOperacion(TextView resultadoView, String operacion) {
        this.operacion = operacion;
        // Guardamos el valor actual en 'resultado' para realizar la operación con el siguiente número
        this.resultado2 = Double.parseDouble(resultadoView.getText().toString());
        // Limpiar la pantalla para ingresar el siguiente número
        resultadoView.setText("0");
    }

    private void calcularResultado(TextView resultadoView) {
        double segundoNumero = Double.parseDouble(resultadoView.getText().toString());

        // Realizar las operaciones dependiendo de la operación seleccionada
        switch (operacion) {
            case "+":
                resultado2 = resultado2 + segundoNumero;
                break;
            case "-":
                resultado2 = resultado2 - segundoNumero;
                break;
            case "*":
                resultado2 = resultado2 * segundoNumero;
                break;
            case "/":
                if (segundoNumero != 0) {
                    resultado2 = resultado2 / segundoNumero;
                } else {
                    resultadoView.setText("Error");
                    return;  // Si hay un error, no seguir
                }
                break;
        }
        // Mostrar el resultado en el TextView
        resultadoView.setText(String.valueOf(resultado2));
    }

}



