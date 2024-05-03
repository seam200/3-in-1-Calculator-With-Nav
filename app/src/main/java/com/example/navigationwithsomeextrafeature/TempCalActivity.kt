package com.example.navigationwithsomeextrafeature

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TempCalActivity : AppCompatActivity() {
    private lateinit var editTextNumberDecimal: EditText
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp_cal)

        editTextNumberDecimal = findViewById(R.id.editTextNumberDecimal)
        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)
    }

    fun OnConverterClick(view: View) {
        val celsiusValue = editTextNumberDecimal.text.toString().toDoubleOrNull()

        if (celsiusValue != null) {
            val fahrenheitValue = celsiusToFahrenheit(celsiusValue)
            textView.text = "Fahrenheit value: $fahrenheitValue"
        } else {
            textView.text = "Invalid input"
        }
    }

    private fun celsiusToFahrenheit(celsius: Double): Double {
        return celsius * 9 / 5 + 32
    }
}