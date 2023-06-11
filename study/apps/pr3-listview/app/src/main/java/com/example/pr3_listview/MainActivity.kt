package com.example.pr3_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.AdapterView
import android.view.View
import android.widget.Toast
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        lvMenu.onItemClickListener = listItemClickListener()
    }

    private inner class listItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            val item = parent.getItemAtPosition(position).toString()
            val show = "あなたが選んだ定食：" + item
            Toast.makeText(this@MainActivity, show, Toast.LENGTH_SHORT).show()
        }
    }
}