package com.example.dialoguebox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.dialoguebox.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val builder=AlertDialog.Builder(this)
            builder.setMessage("Are you sure")
            builder.setTitle("Delete")
            builder.setPositiveButton("Yes"){d, w->
                // do something
            }
            builder.setNegativeButton("No"){d, w->
                d.cancel()
            }
            builder.create().show()
        }

        binding.button2.setOnClickListener {
             val builder=AlertDialog.Builder(this)
            builder.setTitle("Which Language You Know ?")
            builder.setNegativeButton("Nothing"){d, i->
                d.cancel()
            }
            builder.setPositiveButton("This"){d, i->

            }
            builder.setMultiChoiceItems(arrayOf("C", "C++", "JAVA", "PYTHON", "JAVA SCRIPT", "RUST", "Kotlin"), null){d, w, i->

            }
            builder.create().show()
        }

        binding.button3.setOnClickListener {
            val builder=AlertDialog.Builder(this)
            builder.setTitle("select your gender")
            builder.setPositiveButton("Submit"){d, i->

            }
            builder.setNegativeButton("No"){d, i->
                d.cancel()
            }
            builder.setSingleChoiceItems(arrayOf("Male", "Female", "Asexual", "Bisexual", "gay", "Lesbian"), 0){d, i->

            }
            builder.create().show()
        }

    }
}