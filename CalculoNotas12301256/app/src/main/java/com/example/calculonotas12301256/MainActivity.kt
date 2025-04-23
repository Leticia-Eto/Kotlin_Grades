package com.example.calculonotas12301256

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn_media= findViewById<Button>(R.id.btn_media)
        btn_media.setOnClickListener {
            media();
        }
    }
    fun media(){
        val tv_resultado = findViewById<TextView>(R.id.tv_total)
        val nota1=findViewById<EditText>(R.id.edit_nota1).getText().toString().toDouble()
        val nota2=findViewById<EditText>(R.id.edit_nota2).getText().toString().toDouble()
        if (nota1<0||nota2<0){
            tv_resultado.setText("ERRO - nota menor que zero")
        }
        else if (nota1>10||nota2>10){
            tv_resultado.setText("ERRO - nota maior que dez")
        }
        else{
            val total= ((nota1+nota2)/2)
            if (total == 10.0) {
                tv_resultado.setText("Média: ${total} - Aprovado com Distinção")
            }
            else if (total<7){
                tv_resultado.setText("Média: ${total} - Reprovado")
            }
            else{
                tv_resultado.setText("Média: ${total} - Aprovado")

            }
        }

    }
}