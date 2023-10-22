package com.example.databaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.view.*

class MainActivity : AppCompatActivity() {

    // 選択中のカクテルIDを格納
    private var cocktailId = -1

    // 選択されたカクテル名を表す
    private var cocktailName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // リストを取得
        val cocktailList = findViewById<ListView>(R.id.cocktail)
        // イベントの付与
        cocktailList.onItemClickListener = ListItemClickListener()
    }

    fun onSaveButton(view: View) {
        // 感想欄を取得
        val noteTextView = findViewById<EditText>(R.id.etNote)
        // 感想欄を初期化
        noteTextView.setText("")
        // カクテル名を表示
        val cocktailViewName = findViewById<TextView>(R.id.name)
        cocktailViewName.text = getString(R.string.lb_name)

        // 保存ボタンを非活性にする
        val saveButton = findViewById<Button>(R.id.btnSave)
        saveButton.isEnabled = false
    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            // タップされたIDを挿入
            cocktailId = position
            // 対象のデータを取得
            cocktailName = parent?.getItemAtPosition(position) as String

            // TextViewを取得
            val cocktailTextView = findViewById<TextView>(R.id.name)
            cocktailTextView.text = cocktailName
            // 保存ボタンを有効化
            val saveButton = findViewById<Button>(R.id.btnSave)
            saveButton.isEnabled = true
        }
    }
}