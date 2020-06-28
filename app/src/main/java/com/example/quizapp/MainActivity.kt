package com.example.quizapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var score:Int = 0
    private var radioGroup1ID:Int = 0
    private var radioGroup2ID:Int = 0
    private var radioGroup3ID:Int = 0
    private var radioGroup4ID:Int = 0
    private var radioGroup5ID:Int = 0
    private val radioGroupIDArray = arrayOf(radioGroup1ID, radioGroup2ID, radioGroup3ID, radioGroup4ID, radioGroup5ID)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN //get rid off status bar, fullscreen

        radioGroup1ID = radioGroup1.checkedRadioButtonId
        radioGroup2ID = radioGroup2.checkedRadioButtonId
        radioGroup3ID = radioGroup3.checkedRadioButtonId
        radioGroup4ID = radioGroup4.checkedRadioButtonId
        radioGroup5ID = radioGroup5.checkedRadioButtonId


        radioGroup1.setOnCheckedChangeListener { _, checkedId -> //first parameter will be the name of radio group, second the id of the selected item that
            //we use to compare
            if(checkedId == R.id.answer1)
                score++;
        }
        radioGroup2.setOnCheckedChangeListener { _, checkedId ->
            if(checkedId == R.id.answer7)
                score++;
        }
        radioGroup3.setOnCheckedChangeListener { _, checkedId ->
            if(checkedId == R.id.answer13)
                score++;
        }
        radioGroup4.setOnCheckedChangeListener { _, checkedId ->

            if(checkedId == R.id.answer19)
                score++;
        }

        radioGroup5.setOnCheckedChangeListener { _, checkedId ->
            if(checkedId == R.id.answer25)
                score++;
        }

        scoreTextview.visibility = View.GONE
        usernameTextView.visibility = View.GONE
        dobTextView.visibility = View.GONE


        submitButton.setOnClickListener {
            scoreTextview.visibility = View.VISIBLE
            usernameTextView.visibility = View.VISIBLE
            dobTextView.visibility = View.VISIBLE

            val username = usernameEditText.text.toString().trim()
            val dob = dobEditText.text.toString().trim()

            val scoreDetails = "Score: $score"
            val userNameDetails = "Username: $username"
            val dobDetails = "Date of Birth: $dob"

            for(id in radioGroupIDArray){
                when(id){
                    R.id.answer1 -> answer1.setTextColor(Color.parseColor("#74f6a7"))

                    R.id.answer7 -> answer7.setTextColor(Color.parseColor("#74f6a7"))

                    R.id.answer13 -> answer13.setTextColor(Color.parseColor("#74f6a7"))

                    R.id.answer19 -> answer19.setTextColor(Color.parseColor("#74f6a7"))

                    R.id.answer25 -> answer25.setTextColor(Color.parseColor("#74f6a7"))

                    else -> {
                        answer1.setTextColor(Color.parseColor("#74f6a7")) //Green
                        answer2.setTextColor(Color.parseColor("#fa1616"))
                        answer3.setTextColor(Color.parseColor("#fa1616"))
                        answer4.setTextColor(Color.parseColor("#fa1616"))
                        answer5.setTextColor(Color.parseColor("#fa1616"))

                        answer6.setTextColor(Color.parseColor("#fa1616"))
                        answer7.setTextColor(Color.parseColor("#74f6a7")) //Green
                        answer8.setTextColor(Color.parseColor("#fa1616"))
                        answer9.setTextColor(Color.parseColor("#fa1616"))
                        answer10.setTextColor(Color.parseColor("#fa1616"))

                        answer11.setTextColor(Color.parseColor("#fa1616"))
                        answer12.setTextColor(Color.parseColor("#fa1616"))
                        answer13.setTextColor(Color.parseColor("#74f6a7")) //Green
                        answer14.setTextColor(Color.parseColor("#fa1616"))
                        answer15.setTextColor(Color.parseColor("#fa1616"))

                        answer16.setTextColor(Color.parseColor("#fa1616"))
                        answer17.setTextColor(Color.parseColor("#fa1616"))
                        answer18.setTextColor(Color.parseColor("#fa1616"))
                        answer19.setTextColor(Color.parseColor("#74f6a7")) //Green
                        answer20.setTextColor(Color.parseColor("#fa1616"))

                        answer21.setTextColor(Color.parseColor("#fa1616"))
                        answer22.setTextColor(Color.parseColor("#fa1616"))
                        answer23.setTextColor(Color.parseColor("#fa1616"))
                        answer24.setTextColor(Color.parseColor("#fa1616"))
                        answer25.setTextColor(Color.parseColor("#74f6a7")) //Green
                    }
                }
            }

            usernameEditText.isEnabled = false
            dobEditText.isEnabled = false

            for(index in 1..5){
                radioGroup1.getChildAt(index).isEnabled = false
                radioGroup2.getChildAt(index).isEnabled = false
                radioGroup3.getChildAt(index).isEnabled = false
                radioGroup4.getChildAt(index).isEnabled = false
                radioGroup5.getChildAt(index).isEnabled = false
            }

            scoreTextview.text = scoreDetails
            usernameTextView.text = userNameDetails
            dobTextView.text = dobDetails
            submitButton.text = ("Try again?").toString()
        }
    }
}
