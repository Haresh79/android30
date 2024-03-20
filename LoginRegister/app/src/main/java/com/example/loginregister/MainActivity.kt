package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name=findViewById<TextInputEditText>(R.id.name)
        val email=findViewById<TextInputEditText>(R.id.email)
        val pass=findViewById<TextInputEditText>(R.id.password)
        val signinbtn=findViewById<Button>(R.id.button)
        val loginbtn=findViewById<TextView>(R.id.gologin)
        loginbtn.setOnClickListener {
            val loginIntent= Intent(this, Login::class.java)
            startActivity(loginIntent)
        }
        signinbtn.setOnClickListener {
            var UName=name.text.toString()
            var UEmail=email.text.toString()
            var Upassword=pass.text.toString()

            val user=User(UName, UEmail, Upassword)
            database=FirebaseDatabase.getInstance().getReference("Users")
            if (UName.isNotEmpty() && UEmail.isNotEmpty() && Upassword.isNotEmpty()) {
                database.child(UName).setValue(user).addOnSuccessListener {
                    name.text?.clear()
                    email.text?.clear()
                    pass.text?.clear()
                    Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}