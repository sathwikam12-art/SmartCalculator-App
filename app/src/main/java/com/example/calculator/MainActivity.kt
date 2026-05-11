package com.example.calculator

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvHistory: TextView

    private lateinit var historyContainer: ScrollView

    private lateinit var calculatorLayout: LinearLayout

    private lateinit var scientificLayout: LinearLayout

    private lateinit var converterLayout: LinearLayout

    private var expression = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // VIEWS

        tvResult = findViewById(R.id.tvResult)

        tvHistory = findViewById(R.id.tvHistory)

        historyContainer =
            findViewById(R.id.historyContainer)

        calculatorLayout =
            findViewById(R.id.calculatorLayout)

        scientificLayout =
            findViewById(R.id.scientificLayout)

        converterLayout =
            findViewById(R.id.converterLayout)

        val tabCalculator =
            findViewById<TextView>(R.id.tabCalculator)

        val tabHistory =
            findViewById<TextView>(R.id.tabHistory)

        val btnScientific =
            findViewById<Button>(R.id.btnScientific)

        // CONVERTER VIEWS

        val etInput =
            findViewById<EditText>(R.id.etInput)

        val tvConverterResult =
            findViewById<TextView>(R.id.tvConverterResult)

        val btnMeterToCm =
            findViewById<Button>(R.id.btnMeterToCm)

        val btnCmToMeter =
            findViewById<Button>(R.id.btnCmToMeter)

        val btnKmToMeter =
            findViewById<Button>(R.id.btnKmToMeter)

        val btnMeterToKm =
            findViewById<Button>(R.id.btnMeterToKm)

        val btnKgToGram =
            findViewById<Button>(R.id.btnKgToGram)

        val btnGramToKg =
            findViewById<Button>(R.id.btnGramToKg)

        // HISTORY TAB

        tabHistory.setOnClickListener {

            historyContainer.visibility = View.VISIBLE

            calculatorLayout.visibility = View.GONE

            converterLayout.visibility = View.GONE

            tabHistory.setTextColor(
                Color.parseColor("#00BFFF")
            )

            tabCalculator.setTextColor(
                Color.WHITE
            )
        }

        // CALCULATOR TAB

        tabCalculator.setOnClickListener {

            historyContainer.visibility = View.GONE

            converterLayout.visibility = View.GONE

            calculatorLayout.visibility = View.VISIBLE

            tabCalculator.setTextColor(
                Color.parseColor("#00BFFF")
            )

            tabHistory.setTextColor(
                Color.WHITE
            )
        }

        // SCIENTIFIC TOGGLE

        btnScientific.setOnClickListener {

            if (scientificLayout.visibility == View.GONE) {

                scientificLayout.visibility = View.VISIBLE

            } else {

                scientificLayout.visibility = View.GONE
            }
        }

        // OPEN CONVERTER

        findViewById<Button>(R.id.btnConverter)
            .setOnClickListener {

                calculatorLayout.visibility = View.GONE

                historyContainer.visibility = View.GONE

                converterLayout.visibility = View.VISIBLE
            }

        // METER TO CM

        btnMeterToCm.setOnClickListener {

            try {

                val value =
                    etInput.text.toString().toDouble()

                val result = value * 100

                tvConverterResult.text =
                    "$result CM"

            } catch (e: Exception) {

                tvConverterResult.text =
                    "Invalid Input"
            }
        }

        // CM TO METER

        btnCmToMeter.setOnClickListener {

            try {

                val value =
                    etInput.text.toString().toDouble()

                val result = value / 100

                tvConverterResult.text =
                    "$result Meter"

            } catch (e: Exception) {

                tvConverterResult.text =
                    "Invalid Input"
            }
        }

        // KM TO METER

        btnKmToMeter.setOnClickListener {

            try {

                val value =
                    etInput.text.toString().toDouble()

                val result = value * 1000

                tvConverterResult.text =
                    "$result Meter"

            } catch (e: Exception) {

                tvConverterResult.text =
                    "Invalid Input"
            }
        }

        // METER TO KM

        btnMeterToKm.setOnClickListener {

            try {

                val value =
                    etInput.text.toString().toDouble()

                val result = value / 1000

                tvConverterResult.text =
                    "$result KM"

            } catch (e: Exception) {

                tvConverterResult.text =
                    "Invalid Input"
            }
        }

        // KG TO GRAM

        btnKgToGram.setOnClickListener {

            try {

                val value =
                    etInput.text.toString().toDouble()

                val result = value * 1000

                tvConverterResult.text =
                    "$result Gram"

            } catch (e: Exception) {

                tvConverterResult.text =
                    "Invalid Input"
            }
        }

        // GRAM TO KG

        btnGramToKg.setOnClickListener {

            try {

                val value =
                    etInput.text.toString().toDouble()

                val result = value / 1000

                tvConverterResult.text =
                    "$result KG"

            } catch (e: Exception) {

                tvConverterResult.text =
                    "Invalid Input"
            }
        }

        // NORMAL BUTTONS

        val buttons = listOf(

            R.id.btn0,
            R.id.btn1,
            R.id.btn2,
            R.id.btn3,
            R.id.btn4,
            R.id.btn5,
            R.id.btn6,
            R.id.btn7,
            R.id.btn8,
            R.id.btn9,

            R.id.btnPlus,
            R.id.btnMinus,
            R.id.btnMultiply,
            R.id.btnDivide,

            R.id.btnDot,
            R.id.btnPercent
        )

        for (id in buttons) {

            findViewById<Button>(id)
                .setOnClickListener {

                    val button =
                        findViewById<Button>(id)

                    var value =
                        button.text.toString()

                    if (value == "×") {
                        value = "*"
                    }

                    expression += value

                    tvResult.text = expression
                }
        }

        // SCIENTIFIC BUTTONS

        findViewById<Button>(R.id.btnSin)
            .setOnClickListener {

                expression += "sin("

                tvResult.text = expression
            }

        findViewById<Button>(R.id.btnCos)
            .setOnClickListener {

                expression += "cos("

                tvResult.text = expression
            }

        findViewById<Button>(R.id.btnTan)
            .setOnClickListener {

                expression += "tan("

                tvResult.text = expression
            }

        findViewById<Button>(R.id.btnSqrt)
            .setOnClickListener {

                expression += "sqrt("

                tvResult.text = expression
            }

        findViewById<Button>(R.id.btnPower)
            .setOnClickListener {

                expression += "^2"

                tvResult.text = expression
            }

        findViewById<Button>(R.id.btnLog)
            .setOnClickListener {

                expression += "log("

                tvResult.text = expression
            }

        // CLOSE BRACKET

        findViewById<Button>(R.id.btnClose)
            .setOnClickListener {

                expression += ")"

                tvResult.text = expression
            }

        // CLEAR

        findViewById<Button>(R.id.btnClear)
            .setOnClickListener {

                expression = ""

                tvResult.text = "0"
            }

        // BACKSPACE

        findViewById<Button>(R.id.btnBack)
            .setOnClickListener {

                if (expression.isNotEmpty()) {

                    expression =
                        expression.dropLast(1)

                    tvResult.text =
                        if (expression.isEmpty())
                            "0"
                        else
                            expression
                }
            }

        // EQUAL BUTTON

        findViewById<Button>(R.id.btnEqual)
            .setOnClickListener {

                try {

                    val result =
                        ExpressionBuilder(expression)
                            .build()
                            .evaluate()

                    val currentTime =
                        SimpleDateFormat(
                            "dd/MM/yyyy hh:mm a",
                            Locale.getDefault()
                        ).format(Date())

                    tvHistory.append(
                        "$expression = $result\n$currentTime\n\n"
                    )

                    tvResult.text =
                        result.toString()

                    expression =
                        result.toString()

                } catch (e: Exception) {

                    tvResult.text = "Error"
                }
            }
    }
}