package com.example.pizzeria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
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


        final CheckBox peperoni = findViewById(R.id.peperoni);
        final CheckBox jamon = findViewById(R.id.jamon);
        final CheckBox aceitunas = findViewById(R.id.aceitunas);
        final CheckBox bacon = findViewById(R.id.bacon);
        RadioGroup rgOpciones = findViewById(R.id.rgGrupo1);
        Button calcular = findViewById(R.id.calcular);
        TextView resultado = findViewById(R.id.resultado);


        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pizza = 0;
                if(rgOpciones.getCheckedRadioButtonId() == (R.id.pequeña)){
                    pizza = 5;
                }else if(rgOpciones.getCheckedRadioButtonId() == (R.id.mediana)){
                    pizza = 10;
                } else if(rgOpciones.getCheckedRadioButtonId() == (R.id.grande)) {
                    pizza = 15;
                }
                int resultado2 = pizza + devolverIngredientes();
                resultado.setText("Total: "+resultado2+"€");

            }

            public int devolverIngredientes(){
                int resultado = 0;

                if(peperoni.isChecked()){

                    resultado += 1;
                }
                if(jamon.isChecked()){
                    resultado += 3;
                }
                if(aceitunas.isChecked()){
                    resultado += 3;
                }
                if(bacon.isChecked()){
                    resultado += 2;
                }
                return resultado;
            }





        });


    }
}