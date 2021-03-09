package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Sign_up : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = FirebaseAuth.getInstance()
        val btn_sign: Button = findViewById<Button>(R.id.btn_sign)
        btn_sign.setOnClickListener {
            signUpUser()
        }
    }
    private fun signUpUser() {
        val et_username: EditText = findViewById<EditText>(R.id.et_username)
        val et_password: EditText = findViewById<EditText>(R.id.et_password)

        if (et_username.text.toString().isEmpty()) {
            et_username.error = "Please enter email"
            et_username.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(et_username.text.toString()).matches()) {
            et_username.error = "Please enter valid email"
            et_username.requestFocus()
            return
        }

        if (et_password.text.toString().isEmpty()) {
            et_password.error = "Please enter password"
            et_password.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(et_username.text.toString(), et_password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this,MainActivity2::class.java))
                    finish()
                } else {
                    Toast.makeText(baseContext, "Sign Up failed. Try again after some time.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}