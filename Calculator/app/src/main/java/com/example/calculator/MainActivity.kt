package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var tvInput: TextView
    private var lastNumeric = true
    private var lastDecimal = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput = findViewById(R.id.tvInput)
    }

    fun onDigit(view: View) {
        tvInput.append((view as Button).text)
        lastNumeric = true
        lastDecimal = false
    }

    fun onClear(view: View) {
        tvInput.text = ""
        lastNumeric = true
        lastDecimal = false
    }

    fun onDecimal(view: View) {
        if (lastNumeric && !lastDecimal) {
            tvInput.append((view as Button).text)
            // update flags
            lastDecimal = true
            lastNumeric = false
        }
    }

    fun onOperator(view: View) {
        if (lastNumeric && !isOperatorAdded(tvInput.text.toString())) {
            tvInput.append((view as Button).text)
            lastNumeric = false
            lastDecimal = false
        }
    }

    fun onEqual(view: View) {
        if (lastNumeric) {
            var tvValue = tvInput.text.toString()
            var prefix = ""
            try {
                if (tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }
                when {
                    tvValue.contains("-") -> {
                        val splitVal = tvValue.split("-")
                        var left = prefix + splitVal[0]
                        var right = splitVal[1]
                        tvInput.text = (left.toDouble() - right.toDouble()).toString()
                    }
                    tvValue.contains("+") -> {
                        val splitVal = tvValue.split("+")
                        var left = prefix + splitVal[0]
                        var right = splitVal[1]
                        tvInput.text = (left.toDouble() + right.toDouble()).toString()
                    }
                    tvValue.contains("/") -> {
                        val splitVal = tvValue.split("/")
                        var left = prefix + splitVal[0]
                        var right = splitVal[1]
                        tvInput.text = (left.toDouble() / right.toDouble()).toString()
                    }
                    tvValue.contains("*") -> {
                        val splitVal = tvValue.split("*")
                        var left = prefix + splitVal[0]
                        var right = splitVal[1]
                        tvInput.text = (left.toDouble() * right.toDouble()).toString()
                    }
                }
                tvInput.text = removeZeroAfterDot(tvInput.text.toString())
            } catch(err: ArithmeticException) {
                err.printStackTrace()
            }
        }
    }

    private fun removeZeroAfterDot(value: String) : String {
        return if (value.endsWith(".0")) {
            value.dropLast(2)
        } else {
            value
        }
    }

    private fun isOperatorAdded(value: String) : Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/")
                    || value.contains("*")
                    || value.contains("+")
                    || value.contains("-")
        }
    }
}