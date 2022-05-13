package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName = findViewById<TextView>(R.id.tvName)
        tvName.text = intent.getStringExtra(Constants.USER_NAME)
        val score = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 10)

        val tvScore = findViewById<TextView>(R.id.tvScore)
        tvScore.text = "Your score is $score out of $totalQuestions."

        val btnFinish = findViewById<Button>(R.id.btnFinish)

        btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}