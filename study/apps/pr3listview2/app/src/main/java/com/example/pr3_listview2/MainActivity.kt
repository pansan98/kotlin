package com.example.pr3_listview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pr3_listview2.OrderConfirmDialogFragment
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ListViewオブジェクトの取得
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        // ListViewに表示するデータを作成
        val menulist = mutableListOf("からあげ定食", "ハンバーグ定食", "生姜焼き定食", "ステーキ定食", "卵かけごはん", "野菜炒め定食", "味噌サバ定食", "ライス大盛り", "水")

        val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, menulist)
        lvMenu.adapter = adapter
        lvMenu.onItemClickListener = ListItemClickListener()
    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            val dialogFragment = OrderConfirmDialogFragment()
            dialogFragment.show(supportFragmentManager, "OrderConfirmDialogFragment")
        }
    }
}