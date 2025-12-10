package com.example.project4_2

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var switchStart: Switch
    lateinit var textQuestion: TextView
    lateinit var rGroup: RadioGroup
    lateinit var imgAndroid: ImageView
    lateinit var layoutButtons: LinearLayout
    lateinit var btnExit: Button
    lateinit var btnReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchStart = findViewById(R.id.switchStart)
        textQuestion = findViewById(R.id.textQuestion)
        rGroup = findViewById(R.id.rGroup)
        imgAndroid = findViewById(R.id.imgAndroid)
        layoutButtons = findViewById(R.id.layoutButtons)
        btnExit = findViewById(R.id.btnExit)
        btnReset = findViewById(R.id.btnReset)


        switchStart.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                textQuestion.visibility = View.VISIBLE
                rGroup.visibility = View.VISIBLE
                layoutButtons.visibility = View.VISIBLE

                if (rGroup.checkedRadioButtonId == -1) {
                    imgAndroid.visibility = View.INVISIBLE
                } else {
                    imgAndroid.visibility = View.VISIBLE
                }
            } else {
                textQuestion.visibility = View.INVISIBLE
                rGroup.visibility = View.INVISIBLE
                imgAndroid.visibility = View.INVISIBLE
                layoutButtons.visibility = View.INVISIBLE
                rGroup.clearCheck()
            }
        }


        rGroup.setOnCheckedChangeListener { _, checkedId ->
            imgAndroid.visibility = View.VISIBLE
            when (checkedId) {

                R.id.radioOreo -> imgAndroid.setImageResource(R.drawable.oreo)
                R.id.radioPie -> imgAndroid.setImageResource(R.drawable.pie)
                R.id.radioQ -> imgAndroid.setImageResource(R.drawable.q10)
                else -> imgAndroid.visibility = View.INVISIBLE
            }
        }


        btnExit.setOnClickListener {
            finish()
        }


        btnReset.setOnClickListener {
            switchStart.isChecked = false
        }
    }
}