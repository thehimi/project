package com.example.project

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val saveBtn: Button = findViewById<Button>(R.id.saveButton)
        val inputfirstname: EditText =findViewById<EditText>(R.id.inputFirstName)
        val placebirth: EditText =findViewById<EditText>(R.id.placeofbirth)
        saveBtn.setOnClickListener {
            val firstName = inputfirstname.text.toString()
            val placebirth = placebirth.text.toString()

            saveFire(firstName, placebirth)

        }

    }
    fun saveFire(firstname: String, placebirth: String ) {

        val ref = FirebaseDatabase.getInstance().getReference("users")
        val dataId =ref.push().key

        val data = dataId?.let { data(it,firstname,placebirth ) }
        if (dataId != null) {
            ref.child(dataId).setValue(data).addOnSuccessListener {
                Toast.makeText(this@MainActivity2, "record added successfully ", Toast.LENGTH_SHORT ).show()

            }
        }




}}