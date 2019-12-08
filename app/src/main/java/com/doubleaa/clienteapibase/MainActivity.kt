package com.doubleaa.clienteapibase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCatalogo1.setOnClickListener {
            val intent = Intent(this,Catalogo1::class.java)
            startActivity(intent)
        }

        btnCatalogo2.setOnClickListener {
            val intent = Intent(this,Catalogo2::class.java)
            startActivity(intent)
        }

        btnCatalogo3.setOnClickListener {
            val intent = Intent(this,Catalogo3::class.java)
            startActivity(intent)
        }

        btnCatalogo4.setOnClickListener {
            val intent = Intent(this,Catalogo4::class.java)
            startActivity(intent)
        }

        btnCatalogo5.setOnClickListener {
            val intent = Intent(this,Catalogo5::class.java)
            startActivity(intent)
        }

        btnCatalogo6.setOnClickListener {
            val intent = Intent(this,Catalogo6::class.java)
            startActivity(intent)
        }

    }
}
