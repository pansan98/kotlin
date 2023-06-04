package com.example.pr2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btClick = findViewById<Button>(R.id.btClick)
        val btClear = findViewById<Button>(R.id.btClear)
        val listener = HelloListener()
        btClick.setOnClickListener(listener)
        btClear.setOnClickListener(listener)
    }

    private inner class HelloListener: View.OnClickListener {
        override fun onClick(view: View) {
            // EditTextを取得
            val input = findViewById<EditText>(R.id.etName)
            // Outputを取得
            val output = findViewById<TextView>(R.id.tvOutput)

            when(view.id) {
                R.id.btClick -> {
                    // 入力された文字列の取得
                    val inputStr:String = input.text.toString()
                    // メッセージを表示
                    output.text = inputStr + "さん、こんにちは。"
                }
                R.id.btClear -> {
                    input.setText("")
                    output.text = ""
                }
            }
        }
    }
}