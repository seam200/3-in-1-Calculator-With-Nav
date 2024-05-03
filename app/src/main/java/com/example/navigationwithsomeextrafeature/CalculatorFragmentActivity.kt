package com.example.navigationwithsomeextrafeature

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.cos
import kotlin.math.ln
import kotlin.math.log10
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.tan

class CalculatorFragmentActivity : AppCompatActivity() {
    private lateinit var b1: Button
    private lateinit var b2: Button
    private lateinit var b3: Button
    private lateinit var b4: Button
    private lateinit var b5: Button
    private lateinit var b6: Button
    private lateinit var b7: Button
    private lateinit var b8: Button
    private lateinit var b9: Button
    private lateinit var b0: Button
    private lateinit var bac: Button
    private lateinit var bc: Button
    private lateinit var bbl: Button
    private lateinit var bbr: Button
    private lateinit var bSin: Button
    private lateinit var bco: Button
    private lateinit var bta: Button
    private lateinit var blog: Button
    private lateinit var bIn: Button
    private lateinit var bxi: Button
    private lateinit var bSar: Button
    private lateinit var bRoot: Button
    private lateinit var bInv: Button
    private lateinit var bDiv: Button
    private lateinit var bMulti: Button
    private lateinit var bMin: Button
    private lateinit var bPlus: Button
    private lateinit var bpi: Button
    private lateinit var bDot: Button
    private lateinit var bEel: Button
    private lateinit var bPercent: Button
    private lateinit var tvSec: TextView
    private lateinit var tvMain: TextView
    private lateinit var copyright: TextView

    private val pi = "3.141529265"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator_fragment)

        b1 = findViewById(R.id.b1)
        b2 = findViewById(R.id.b2)
        b3 = findViewById(R.id.b3)
        b4 = findViewById(R.id.b4)
        b5 = findViewById(R.id.b5)
        b6 = findViewById(R.id.b6)
        b7 = findViewById(R.id.b7)
        b8 = findViewById(R.id.b8)
        b9 = findViewById(R.id.b9)
        b0 = findViewById(R.id.b0)
        bac = findViewById(R.id.bac)
        bc = findViewById(R.id.bc)
        bbl = findViewById(R.id.bbl)
        bbr = findViewById(R.id.bbr)
        bSin = findViewById(R.id.bSin)
        bco = findViewById(R.id.bco)
        bta = findViewById(R.id.bta)
        blog = findViewById(R.id.blog)
        bIn = findViewById(R.id.bIn)
        bxi = findViewById(R.id.bxi)
        bSar = findViewById(R.id.bSar)
        bRoot = findViewById(R.id.bRoot)
        bInv = findViewById(R.id.bInv)
        bDiv = findViewById(R.id.bDiv)
        bMulti = findViewById(R.id.bMulti)
        bMin = findViewById(R.id.bMin)
        bPlus = findViewById(R.id.bPlus)
        bpi = findViewById(R.id.bpi)
        bDot = findViewById(R.id.bDot)
        bEel = findViewById(R.id.bEel)
        bPercent = findViewById(R.id.bPercent)

        tvMain = findViewById(R.id.tvMain)
        tvSec = findViewById(R.id.tvSec)
        copyright = findViewById(R.id.copyright)

        // Set onClickListeners for each button
        b1.setOnClickListener { tvMain.append("1") }
        b2.setOnClickListener { tvMain.append("2") }
        b3.setOnClickListener { tvMain.append("3") }
        b4.setOnClickListener { tvMain.append("4") }
        b5.setOnClickListener { tvMain.append("5") }
        b6.setOnClickListener { tvMain.append("6") }
        b7.setOnClickListener { tvMain.append("7") }
        b8.setOnClickListener { tvMain.append("8") }
        b9.setOnClickListener { tvMain.append("9") }
        b0.setOnClickListener { tvMain.append("0") }
        bDot.setOnClickListener { tvMain.append(".") }

        bac.setOnClickListener {
            tvMain.text = ""
            tvSec.text = ""
        }

        bc.setOnClickListener {
            val value = tvMain.text.toString()
            if (value.isNotEmpty()) {
                tvMain.text = value.substring(0, value.length - 1)
            }
        }

        bPlus.setOnClickListener { tvMain.append("+") }
        bMin.setOnClickListener { tvMain.append("-") }
        bMulti.setOnClickListener { tvMain.append("×") }
        bDiv.setOnClickListener { tvMain.append("÷") }

        bSar.setOnClickListener {
            val value = tvMain.text.toString()
            val r = sqrt(value.toDouble())
            tvMain.text = r.toString()
        }

        bbl.setOnClickListener { tvMain.append("(") }
        bbr.setOnClickListener { tvMain.append(")") }

        bpi.setOnClickListener {
            tvSec.text = bpi.text
            tvMain.append(pi)
        }

        bSin.setOnClickListener {
            val input = tvMain.text.toString()
            if (input.isNotEmpty()) {
                try {
                    val number = input.toDouble()
                    val sinValue = sin(Math.toRadians(number))
                    tvMain.text = sinValue.toString()
                    tvSec.text = "sin($input)"
                } catch (e: NumberFormatException) {
                    tvMain.text = "Error"
                }
            }
        }

        bco.setOnClickListener {
            val input = tvMain.text.toString()
            if (input.isNotEmpty()) {
                try {
                    val number = input.toDouble()
                    val cosValue = cos(Math.toRadians(number))
                    tvMain.text = cosValue.toString()
                    tvSec.text = "cos($input)"
                } catch (e: NumberFormatException) {
                    tvMain.text = "Error"
                }
            }
        }

        bIn.setOnClickListener {
            val input = tvMain.text.toString()
            if (input.isNotEmpty()) {
                try {
                    val number = input.toDouble()
                    val lnValue = ln(number)
                    tvMain.text = lnValue.toString()
                    tvSec.text = "ln($input)"
                } catch (e: NumberFormatException) {
                    tvMain.text = "Error"
                }
            }
        }

        blog.setOnClickListener {
            val input = tvMain.text.toString()
            if (input.isNotEmpty()) {
                try {
                    val number = input.toDouble()
                    val logValue = log10(number)
                    tvMain.text = logValue.toString()
                    tvSec.text = "log($input)"
                } catch (e: NumberFormatException) {
                    tvMain.text = "Error"
                }
            }
        }

        bta.setOnClickListener {
            val input = tvMain.text.toString()
            if (input.isNotEmpty()) {
                try {
                    val number = input.toDouble()
                    val tanValue = tan(Math.toRadians(number))
                    tvMain.text = tanValue.toString()
                    tvSec.text = "tan($input)"
                } catch (e: NumberFormatException) {
                    tvMain.text = "Error"
                }
            }
        }

        bInv.setOnClickListener { tvMain.append("^(-1)") }

        blog.setOnClickListener {
            val input = tvMain.text.toString().toInt()
            val fact = factorial(input)
            tvMain.text = fact.toString()
            tvSec.text = "$input!"
        }

        bSar.setOnClickListener {
            val d = tvMain.text.toString().toDouble()
            val square = d * d
            tvMain.text = square.toString()
            tvSec.text = "$d²"
        }

        bEel.setOnClickListener {
            val input = tvMain.text.toString()
            if (input.isNotEmpty()) {
                try {
                    val replacedStr = input.replace("×", "*").replace("÷", "/")
                    val result = eval(replacedStr)
                    tvMain.text = result.toString()
                    tvSec.text = input
                } catch (e: Exception) {
                    tvMain.text = "Error"
                }
            }
        }

        bPercent.setOnClickListener {
            val input = tvMain.text.toString()
            if (input.isNotEmpty()) {
                try {
                    val value = input.toDouble()
                    val percentage = value * 0.01
                    tvMain.text = percentage.toString()
                    tvSec.text = "$input%"
                } catch (e: NumberFormatException) {
                    tvMain.text = "$input%"
                }
            }
        }

        bRoot.setOnClickListener {
            val input = tvMain.text.toString()
            if (input.isNotEmpty()) {
                try {
                    val number = input.toDouble()
                    val squareRoot = sqrt(number)
                    tvMain.text = squareRoot.toString()
                    tvSec.text = "√($input)"
                } catch (e: NumberFormatException) {
                    tvMain.text = "Error"
                }
            }
        }
    }

    // Function to calculate factorial
    private fun factorial(n: Int): Int {
        return if (n == 1 || n == 0) 1 else n * factorial(n - 1)
    }

    // Evaluate mathematical expression
    private fun eval(str: String): Double {
        return object : Any() {
            var pos = -1
            var ch = 0

            fun nextChar() {
                ch = if (++pos < str.length) str[pos].toInt() else -1
            }

            fun eat(charToEat: Int): Boolean {
                while (ch == ' '.toInt()) nextChar()
                if (ch == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }

            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (pos < str.length) throw RuntimeException("Unexpected: ${(ch.toChar())}")
                return x
            }

            fun parseExpression(): Double {
                var x = parseTerm()
                while (true) {
                    if (eat('+'.toInt())) x += parseTerm()
                    else if (eat('-'.toInt())) x -= parseTerm()
                    else return x
                }
            }

            fun parseTerm(): Double {
                var x = parseFactor()
                while (true) {
                    if (eat('*'.toInt())) x *= parseFactor()
                    else if (eat('/'.toInt())) x /= parseFactor()
                    else return x
                }
            }

            fun parseFactor(): Double {
                if (eat('+'.toInt())) return parseFactor()
                if (eat('-'.toInt())) return -parseFactor()
                var x: Double
                val startPos = pos
                if (eat('('.toInt())) {
                    x = parseExpression()
                    eat(')'.toInt())
                } else if (ch in '0'.toInt()..'9'.toInt() || ch == '.'.toInt()) {
                    while (ch in '0'.toInt()..'9'.toInt() || ch == '.'.toInt()) nextChar()
                    x = str.substring(startPos, pos).toDouble()
                } else {
                    throw RuntimeException("Unexpected: ${(ch.toChar())}")
                }
                return x
            }
        }.parse()
    }
}