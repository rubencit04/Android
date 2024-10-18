package com.example.a00_kotlinminicalculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val sumar = findViewById<Button>(R.id.sumar)
        val restar = findViewById<Button>(R.id.restar)
        val multiplicar = findViewById<Button>(R.id.multiplicar)
        val dividir = findViewById<Button>(R.id.dividir)
        val potencia = findViewById<Button>(R.id.potencia)
        val borrar = findViewById<Button>(R.id.borrar)
        val num1 = findViewById<EditText>(R.id.num1)
        val num2 = findViewById<EditText>(R.id.num2)
        val resultado = findViewById<TextView>(R.id.resultado)

        sumar.setOnClickListener {
            val num1Str = num1.text.toString().trim { it <= ' ' }
            val num2Str = num2.text.toString().trim { it <= ' ' }
            if (!num1Str.isBlank() && !num2Str.isBlank()) {
                val num1 = num1Str.toDouble()
                val num2 = num2Str.toDouble()
                resultado.text = "Resultado: " + (num1 + num2)
            }
        }
        restar.setOnClickListener {
            val num1Str = num1.text.toString().trim { it <= ' ' }
            val num2Str = num2.text.toString().trim { it <= ' ' }
            if (!num1Str.isBlank() && !num2Str.isBlank()) {
                val num1 = num1Str.toDouble()
                val num2 = num2Str.toDouble()
                resultado.text = "Resultado: " + (num1 - num2)
            }
        }

        multiplicar.setOnClickListener {
            val num1Str = num1.text.toString().trim { it <= ' ' }
            val num2Str = num2.text.toString().trim { it <= ' ' }
            if (!num1Str.isBlank() && !num2Str.isBlank()) {
                val num1 = num1Str.toDouble()
                val num2 = num2Str.toDouble()
                resultado.text = "Resultado: " + (num1 * num2)
            }
        }
        dividir.setOnClickListener {
            val num1Str = num1.text.toString()
            val num2Str = num2.text.toString()
            if (!num1Str.isBlank() && !num2Str.isBlank()) {
                val num1 = num1Str.toDouble()
                val num2 = num2Str.toDouble()
                resultado.text = "Resultado: " + (num1 / num2)
            }
        }
        potencia.setOnClickListener {
            val num1Str = num1.text.toString().trim { it <= ' ' }
            val num2Str = num2.text.toString().trim { it <= ' ' }
            if (!num1Str.isBlank() && !num2Str.isBlank()) {
                val num1 = num1Str.toDouble()
                val num2 = num2Str.toDouble()
                resultado.text = "Resultado: " + num1.pow(num2)
            }
        }
        borrar.setOnClickListener {
            num1.setText("")
            num2.setText("")
            resultado.text = ""
        }
    }
}