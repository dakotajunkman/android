package com.example.dobcalc

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    // these need to be set here so they can be accessed in outside functions
    private lateinit var tvSelectedDate: TextView
    private lateinit var tvAgeInMin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker = findViewById<Button>(R.id.btnDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvAgeInMin = findViewById(R.id.tvDateMin)

        btnDatePicker.setOnClickListener {
            clickDatePicker()
        }
    }

    private fun clickDatePicker() {
        // these are used to set the date picker to today when it is opened
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,
            // this says what we want to happen once the user selects a date
            DatePickerDialog.OnDateSetListener { _, selYear, selMonth, selDayOfMonth ->
                val selectedDate = "$selYear/${selMonth + 1}/$selDayOfMonth"
                tvSelectedDate.text = selectedDate

                val sdf = SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)
                theDate?.let {
                    val dateInMin = theDate.time / 60000
                    val curDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    curDate?.let {
                        val curMin = curDate.time / 60000
                        val diff = curMin - dateInMin
                        tvAgeInMin.text = diff.toString()
                    }
                }
            },
            year,
            month,
            day
        )
        // sets the max date to yesterday
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()
    }
}