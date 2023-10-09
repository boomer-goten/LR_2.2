package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class exercise_for_all_numbers : AppCompatActivity(), OnClickListener {
    private lateinit var editB : EditText
    private lateinit var btnSelectRes : Button
    private lateinit var textSelect : TextView
    private var first_value = 0
    private var second_value = 0
    private var count_correct = 0
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selective_exercise)
        editB = findViewById(R.id.selective_input)
        btnSelectRes = findViewById(R.id.button_sel_ans)
        textSelect = findViewById(R.id.textView_3)
        btnSelectRes.setOnClickListener(this)

        createExercise()
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.button_sel_ans->{
                val otvet = editB.text.toString().toInt()
                if (otvet == first_value * second_value) {
                    Toast.makeText(this, getString(R.string.Correct), Toast.LENGTH_SHORT).show()
                    count_correct++
                } else
                    Toast.makeText(this, getString(R.string.Incorrect), Toast.LENGTH_SHORT).show()
                count++
                editB.text = null
                if (count == 20) {
                    textSelect.text = getString(R.string.PercentAnswer, count_correct, count, count_correct * 100 / count)
                    return
                } else
                    createExercise()
            }
        }
    }

    private fun createExercise() {
        first_value = (2..9).random()
        second_value = (2..9).random()
        textSelect.text = getString(R.string.Exercise, first_value, second_value)
    }
}