package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition = 1
    private lateinit var mQuestionsList : ArrayList<Question>
    private var mSelectedOptionPosition = 0
    private lateinit var mUserName : String
    private var mCorrectAnswers = 0

    private lateinit var progressBar : ProgressBar
    private lateinit var tvProgress : TextView
    private lateinit var tvQuestion : TextView
    private lateinit var ivFlag : ImageView
    private lateinit var tvOptionOne : TextView
    private lateinit var tvOptionTwo : TextView
    private lateinit var tvOptionThree : TextView
    private lateinit var tvOptionFour : TextView
    private lateinit var btnSubmit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME).toString()

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivFlag = findViewById(R.id.ivFlag)
        tvOptionOne = findViewById(R.id.tvOptionOne)
        tvOptionTwo = findViewById(R.id.tvOptionTwo)
        tvOptionThree = findViewById(R.id.tvOptionThree)
        tvOptionFour = findViewById(R.id.tvOptionFour)
        btnSubmit = findViewById(R.id.btnSubmit)

        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()
        setQuestion()
    }

    private fun setQuestion() {
        defaultOptionsView()
        val question = mQuestionsList[mCurrentPosition - 1]
        ivFlag.setImageResource(question.image)
        progressBar.progress = mCurrentPosition
        tvProgress.text = "${mCurrentPosition}/${progressBar.max}"
        tvQuestion.text = question.question
        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour

        if (mCurrentPosition == mQuestionsList.size) {
            btnSubmit.text = "FINISH"
        } else {
            btnSubmit.text = "SUBMIT"
        }
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(tvOptionOne)
        options.add(tvOptionTwo)
        options.add(tvOptionThree)
        options.add(tvOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
            2 -> tvOptionTwo.background = ContextCompat.getDrawable(this, drawableView)
            3 -> tvOptionThree.background = ContextCompat.getDrawable(this, drawableView)
            4 -> tvOptionFour.background = ContextCompat.getDrawable(this, drawableView)
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvOptionOne -> {
                selectedOptionView(view as TextView, 1)
            }
            R.id.tvOptionTwo -> {
                selectedOptionView(view as TextView, 2)
            }
            R.id.tvOptionThree -> {
                selectedOptionView(view as TextView, 3)
            }
            R.id.tvOptionFour -> {
                selectedOptionView(view as TextView, 4)
            }
            R.id.btnSubmit -> {
                // allows a question to be skipped
                // also allows for handling pressing button to proceed to next question
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList.size -> {
                            setQuestion()
                        } else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionsList[mCurrentPosition - 1]
                    if (question.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList.size) {
                        btnSubmit.text = "FINISH"
                    } else {
                        btnSubmit.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }
}