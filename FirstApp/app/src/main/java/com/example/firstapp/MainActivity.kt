package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mybutton = findViewById<Button>(R.id.mybutton)
        val textView = findViewById<TextView>(R.id.textView)
        var timesClicked = 0
        mybutton.setOnClickListener {
            timesClicked++
            textView.text = timesClicked.toString()
            Toast.makeText(this, "Hey I'm a toast!", Toast.LENGTH_LONG).show()
        }
    }
}