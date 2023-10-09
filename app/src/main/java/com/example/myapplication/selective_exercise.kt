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

class selective_exercise : AppCompatActivity(), OnClickListener {
    private lateinit var editB : EditText
    private lateinit var btnSelectRes : Button
    private lateinit var textSelect : TextView
    private var first_value = 0
    private var second_value = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selective_exercise)
        editB = findViewById(R.id.selective_input)
        btnSelectRes = findViewById(R.id.button_sel_ans)
        textSelect = findViewById(R.id.textView_3)
        btnSelectRes.setOnClickListener(this)

        first_value = intent.getIntExtra("value", 2)
        second_value = (2..9).random()
        textSelect.text = getString(R.string.Exercise, first_value, second_value)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.button_sel_ans->{
                val otvet = editB.text.toString().toInt()
                if (otvet == first_value * second_value) {
                    Toast.makeText(this, getString(R.string.Correct), Toast.LENGTH_SHORT).show()
                    val intent_def = Intent(this, MainActivity::class.java)
                    startActivity(intent_def)
                }
                else
                    Toast.makeText(this, getString(R.string.Incorrect), Toast.LENGTH_SHORT).show()
                    editB.text = null
            }
        }
    }
}