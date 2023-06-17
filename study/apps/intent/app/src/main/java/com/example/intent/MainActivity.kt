package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.*
import android.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 画面部品のListViewを取得
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        // SampleAdapterで仕様するMutableListオブジェを用意
        val menulist: MutableList<MutableMap<String, String>> = mutableListOf()
        // メニューデータの登録
        var menu = mutableMapOf("name" to "からあげ定食", "price" to "800円")
        menulist.add(menu)
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to "900円")
        menulist.add(menu)
        menu = mutableMapOf("name" to "味噌さば定食", "price" to "750円")
        menulist.add(menu)
        menu = mutableMapOf("name" to "アジフライ定食", "price" to "850円")
        menulist.add(menu)
        menu = mutableMapOf("name" to "牛丼", "price" to "560円")
        menulist.add(menu)
        menu = mutableMapOf("name" to "卵かけご飯", "price" to "180円")
        menulist.add(menu)

        // SimpleAdapter第4引数fromデータの用意
        val from = arrayOf("name", "price")
        // SimpleAdapter第5引数toデータの用意
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        // SimpleAdapterの用意
        val adapter = SimpleAdapter(this@MainActivity, menulist, android.R.layout.simple_list_item_2, from, to)
        lvMenu.adapter = adapter
        lvMenu.onItemClickListener = ListItemClickListener()
    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            // タップされた行のデータを取得。SimpleAdapterでは1行のデータはMutableMap型になる
            val item = parent.getItemAtPosition(position) as MutableMap<String, String>
            // 定食名と金額
            val menuName = item["name"]
            val menuPrice = item["price"]
            // インテントオブジェクトを生成
            val intent2MenuThanks = Intent(this@MainActivity, MenuThanksActivity::class.java)
            // 第2画面に送るデータを格納
            intent2MenuThanks.putExtra("name", menuName)
            intent2MenuThanks.putExtra("price", menuPrice)
            // 第2画面の起動
            startActivity(intent2MenuThanks)
        }
    }
}