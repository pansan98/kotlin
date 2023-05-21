package com.example.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 廃止されたのでなし
        //setContentView(R.layout.activity_main)

        // TODO bindingさせる（まだ詳細がわからないので後で調べる）
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val txt = binding.editText.text
            binding.message.text = "Hello, ${txt}"
        }
    }
}