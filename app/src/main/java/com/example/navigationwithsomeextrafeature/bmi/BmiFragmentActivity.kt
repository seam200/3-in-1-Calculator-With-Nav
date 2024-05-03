package com.example.navigationwithsomeextrafeature.bmi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.navigationwithsomeextrafeature.R
import kotlin.math.pow

class BmiFragmentActivity : AppCompatActivity() {
    private lateinit var seekBar: SeekBar
    private lateinit var height:TextView
    private lateinit var weight:TextView
    private lateinit var weightPlus: ImageView
    private lateinit var weightMinus:ImageView
    private lateinit var age: TextView
    private lateinit var agePlus:ImageView
    private lateinit var ageMinus: ImageView
    private lateinit var male: RelativeLayout
    private lateinit var female: RelativeLayout
    lateinit var btn: AppCompatButton
    private var isBackground1:Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_bmi_fragment)

        male=findViewById(R.id.male)
        female=findViewById(R.id.female)
        seekBar=findViewById(R.id.seekbar)
        height=findViewById(R.id.height)
        weight=findViewById(R.id.weight)
        weightPlus=findViewById(R.id.weightPlus)
        weightMinus=findViewById(R.id.weightMinus)
        age=findViewById(R.id.age)
        agePlus=findViewById(R.id.agePlus)
        ageMinus=findViewById(R.id.ageMinus)
        btn=findViewById(R.id.btn)

        male.setOnClickListener(View.OnClickListener {
            toggleBackground() // Call method to toggle background color
            female.setBackgroundResource(R.drawable.background)
        })

        female.setOnClickListener(View.OnClickListener{
            toggleBackground()
            male.setBackgroundResource(R.drawable.background)
        })

        weightPlus.setOnClickListener(){
            increaseValue(weight)
        }
        weightMinus.setOnClickListener(){
            decreaseValue(weight)
        }
        agePlus.setOnClickListener(){
            increaseValue(age)
        }
        ageMinus.setOnClickListener(){
            decreaseValue(age)
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Update the TextView with the current progress value
                height.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Not needed for this example
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Not needed for this example
            }
        })

        btn.setOnClickListener(){
            calculateBMI()

        }

    }

    private fun calculateBMI() {
        val height = seekBar.progress
        val weight = weight.text.toString().toInt()
        val age = age.text.toString().toInt()

        val bmi = calculateBMIValue(height, weight)

        val intent = Intent(this, BMIResultActivity::class.java)
        intent.putExtra("BMI", bmi)
        startActivity(intent)

    }

    private fun calculateBMIValue(height: Int, weight: Int): Double {
        val heightInMeters: Double = height / 100.0
        return weight / heightInMeters.pow(2)
    }

    private fun toggleBackground() {
        if (isBackground1) {
            male.setBackgroundResource(R.drawable.background)
            female.setBackgroundResource(R.drawable.onclickbackground)
        } else {
            male.setBackgroundResource(R.drawable.onclickbackground)
            female.setBackgroundResource(R.drawable.background)
        }

        // Toggle the flag
        isBackground1 = !isBackground1;
    }

    private fun increaseValue(textView: TextView) {
        val currentValue = textView.text.toString().toInt()
        textView.text = (currentValue + 1).toString()
    }

    private fun decreaseValue(textView: TextView) {
        val currentValue = textView.text.toString().toInt()
        if (currentValue > 0) {
            textView.text = (currentValue - 1).toString()
        }
    }


}