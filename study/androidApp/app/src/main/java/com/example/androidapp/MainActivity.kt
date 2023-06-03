package com.example.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.androidapp.ui.main.MainViewModel
import com.example.androidapp.databinding.ActivityMainBinding
import android.widget.Toast
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO bindingさせる（まだ詳細がわからないので後で調べる）
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        fun updateData() {
//            binding.viewText.text = viewModel.getAll()
//        }
        // 廃止されたのでなし
        //setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewmodel = viewModel
        //updateData()

        binding.switch1.setOnCheckedChangeListener {btn: CompoundButton, f: Boolean ->
            Toast.makeText(binding.root.context, "checked:${f}.", Toast.LENGTH_SHORT).show()
        }

        binding.radioGroup.setOnCheckedChangeListener {group: RadioGroup, id: Int ->
            val ob = findViewById<RadioGroup>(id)
            //Toast.makeText(binding.root.context, "checked: ${id}", Toast.LENGTH_SHORT).show()
        }

        binding.seekBar.setOnSeekBarChangeListener(object: OnSeekBarChangeListener {
            var vol:Int = 0
            override fun onProgressChanged(sb: SeekBar, value: Int, f: Boolean) {
                vol = value
            }

            override fun onStartTrackingTouch(sb: SeekBar) {}

            override fun onStopTrackingTouch(sb: SeekBar) {
                Toast.makeText(binding.root.context, "値：${vol}", Toast.LENGTH_SHORT).show()
            }
        })

        binding.saveButton.setOnClickListener {
            val txt = binding.editText.text
            viewModel.add(txt.toString())
            binding.editText.text = null
            //updateData()
            Toast.makeText(binding.root.context, txt, Toast.LENGTH_SHORT).show()
        }

//        binding.button.setOnClickListener {
//            val txt = binding.editText.text
//            binding.message.text = "Hello, ${txt}"
//            Toast.makeText(binding.root.context, "こんにちは、${txt}さん", Toast.LENGTH_SHORT).show()
//        }
    }
}