package com.tanu.aleartdialogandlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.jar.Attributes

class MainActivity : AppCompatActivity() {
   private lateinit var nameTextView: TextView
    private lateinit var studingText: TextView
   private lateinit var updateButton: Button
   private lateinit var ClearButton: Button
   private var items = arrayOf("Name","Collage")
   private var booleanItem= booleanArrayOf(false,false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameTextView=findViewById(R.id.nameTextView)
        studingText=findViewById(R.id.studingText)
        updateButton=findViewById(R.id.updateButton)
        ClearButton=findViewById(R.id.ClearButton)
        ClearButton.setOnClickListener {
            AlertDialog.Builder(this)

                .setTitle("Alert")
                .setMessage("Do you clear your information ")
                .setCancelable(false)
                .setPositiveButton("yes") { _, _ ->
                    Toast.makeText(this, "positive button", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No") { _, _ ->
                    Toast.makeText(this, "negative click", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
                updateButton.setOnClickListener {
                    AlertDialog.Builder(this)
                        .setTitle("Remove item")
                        .setItems(items) { _, position ->
                            Toast.makeText(
                                this,
                                "selected item ${items[position]}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        .setPositiveButton("yes") { _, _ ->
                            Toast.makeText(this, "click yes button", Toast.LENGTH_SHORT).show()
                        }
                        .setNegativeButton("No") { _, _ ->
                            Toast.makeText(this, "click no button", Toast.LENGTH_SHORT).show()
                        }
                        .show()
                }
                        updateButton.setOnClickListener {
                            AlertDialog.Builder(this)
                                .setTitle("Items")
                                .setMultiChoiceItems(items, booleanItem) { _, position, isChecked ->
                                    println("selected podition $position is Cheked $isChecked")
                                    for (position in 0..(booleanItem.size - 1)) {
                                        if (booleanItem[position] == true) {
                                            println("check items ${items[position]}")
                                        }
                                    }
                                    Toast.makeText(
                                        this,
                                        "select $position $isChecked", Toast.LENGTH_SHORT).show()

                                }
                                .setPositiveButton("ok"){_,_->
                                    Toast.makeText(this,"click okay",Toast.LENGTH_SHORT).show()
                                }
                                .show()

                        }


        }

        }


