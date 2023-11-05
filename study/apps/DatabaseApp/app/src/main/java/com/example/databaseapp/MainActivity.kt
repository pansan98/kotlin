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

    // DBヘルパ
    private val _helper = DatabaseHelper(this@MainActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // リストを取得
        val cocktailList = findViewById<ListView>(R.id.cocktail)
        // イベントの付与
        cocktailList.onItemClickListener = ListItemClickListener()
    }

    override fun onDestroy() {
        _helper.close()
        super.onDestroy()
    }

    fun onSaveButton(view: View) {
        // 感想欄を取得
        val noteTextView = findViewById<EditText>(R.id.etNote)
        // 入力情報を取得
        val note = noteTextView.text.toString()
        // dbヘルパーから接続オブジェクトを取得
        val db = _helper.writableDatabase
        val sqldel = "DELETE FROM cocktail WHERE _id = ?"
        var stmt = db.compileStatement(sqldel)
        stmt.bindLong(1, cocktailId.toLong())
        // 削除SQLの実行
        stmt.executeUpdateDelete()

        // 新たにメモを保存
        val sqlup = "INSERT INTO cocktail (_id, name, note) VALUES (?, ?, ?)"
        stmt = db.compileStatement(sqlup)
        stmt.bindLong(1, cocktailId.toLong())
        stmt.bindString(2, cocktailName)
        stmt.bindString(3, note)
        // アップデートsql実行（厳密には削除後に新たにデータを挿入）
        stmt.executeInsert()

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

            val db = _helper.readableDatabase
            val sql = "SELECT * FROM cocktail WHERE _id = ${cocktailId}"
            val cursor = db.rawQuery(sql, null)
            var note = ""
            while(cursor.moveToNext()) {
                // カラムのindex値を取得
                val idxNote = cursor.getColumnIndex("note")
                note = cursor.getString(idxNote)
            }
            // 保存情報を反映
            val noteTextView = findViewById<EditText>(R.id.etNote)
            noteTextView.setText(note)
        }
    }
}