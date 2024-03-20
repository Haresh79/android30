package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Login : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    companion object{
        const val KEY="com.example.loginregister.Login.KEY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val name=findViewById<TextInputEditText>(R.id.names)
        val pass=findViewById<TextInputEditText>(R.id.password)

        findViewById<Button>(R.id.LoginBtn).setOnClickListener {
           var Tname=name.text.toString()
            var Tpass=pass.text.toString()
            if (name.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty() ){
                findData(Tname.toString(), Tpass.toString())
            }
           else{
               Toast.makeText(this, "Please Enter Informations",Toast.LENGTH_SHORT).show()
           }
        }
    }

    private fun findData(name: String, password: String) {

        databaseReference=FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(name).get().addOnSuccessListener {
            if (it.exists()){
                val a=it.child("password").value.toString()
                if (password==a){  
                    val b=it.child("email").value.toString()
                    intent= Intent(this,home::class.java)
                    intent.putExtra(KEY, b)
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"Wrong Password",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"User is Not exist",Toast.LENGTH_SHORT).show()
            }
        }




    }

}