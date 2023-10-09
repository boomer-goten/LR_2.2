package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var editA : EditText
    private lateinit var btnAll : Button
    private lateinit var btnSelective : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editA = findViewById(R.id.InputNumber)
        btnAll = findViewById(R.id.btn_All)
        btnSelective = findViewById(R.id.btn_Selective)
        btnAll.setOnClickListener(this)
        btnSelective.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_All->{
                val intent_all = Intent(this, exercise_for_all_numbers::class.java)
                startActivity(intent_all)
            }
            R.id.btn_Selective->{
                if (editA.text.toString() == "" || editA.text.toString().toInt() < 2 || editA.text.toString().toInt() > 9) {
                    Toast.makeText(this, R.string.errorTextView, Toast.LENGTH_SHORT).show()
                    return
                }
                val intent_selective = Intent(this, selective_exercise::class.java)
                intent_selective.putExtra("value", editA.text.toString().toInt())
                startActivity(intent_selective)
            }
        }
    }
}