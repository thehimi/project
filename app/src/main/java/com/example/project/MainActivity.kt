package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_signup: Button = findViewById<Button>(R.id.btn_signup)
        btn_signup.setOnClickListener{
            val intent = Intent(this,Sign_up::class.java)
            startActivity(intent)
        }

        val signinBtn: Button = findViewById<Button>(R.id.btn_signin)
        signinBtn.setOnClickListener {
            startActivity(Intent(this,SignIn::class.java))

        }
    }

}