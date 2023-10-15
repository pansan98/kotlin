package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.*
import android.view.*

class MainActivity : AppCompatActivity() {
    // Viewに表示するリストデータ
    private var _menulist: MutableList<MutableMap<String, Any>> = mutableListOf()
    // SimpleAdaptor の第4引数
    private val _from = arrayOf("name", "price")
    // SimpleAdaptor の第5引数
    private val _to = intArrayOf(R.id.tvMenuNameRow, R.id.tvMenuPriceRow)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 画面部品のListViewを取得
        val lvMenu = findViewById<ListView>(R.id.lvMenu)

        _menulist = createTeishokuList()

        // SimpleAdapterの用意
        val adapter = SimpleAdapter(this@MainActivity, _menulist, R.layout.row, _from, _to)
        lvMenu.adapter = adapter
        lvMenu.onItemClickListener = ListItemClickListener()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options_list, menu)
        return true
    }

    private fun createTeishokuList(): MutableList<MutableMap<String, Any>> {
        // 定食メニューリストのListオブジェクトを用意
        val menulist: MutableList<MutableMap<String, Any>> = mutableListOf()
        // 定食データを格納するMapオブジェクトの用意とmenulistへ追加
        var menu = mutableMapOf<String, Any>("name" to "からあげ定食", "price" to 800, "desc" to "若鶏のからあげにサラダ、ご飯とお味噌汁が付きます。")
        menulist.add(menu)
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 850, "desc" to "手ごねハンバーグにサラダ、ご飯とお味噌汁が付きます。")
        menulist.add(menu)
        menu = mutableMapOf("name" to "味噌さば定食", "price" to 750, "desc" to "サラダとご飯とお味噌汁が付きます。")
        menulist.add(menu)
        menu = mutableMapOf("name" to "アジフライ定食", "price" to 850, "desc" to "ご飯だけ付きます。")
        menulist.add(menu)
        menu = mutableMapOf("name" to "牛丼", "price" to 560, "desc" to "ご飯の大盛りや頭大盛りが追加料金で選択できます。")
        menulist.add(menu)
        menu = mutableMapOf("name" to "卵かけご飯", "price" to 180, "desc" to "醤油は自由にお使い頂けます。おかわりは無料です。")
        menulist.add(menu)

        return menulist
    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            // タップされた行のデータを取得。SimpleAdapterでは1行のデータはMutableMap型になる
            val item = parent.getItemAtPosition(position) as MutableMap<String, Any>
            // 定食名と金額
            val menuName = item["name"] as String
            val menuPrice = item["price"] as Int
            // インテントオブジェクトを生成
            val intent2MenuThanks = Intent(this@MainActivity, MenuThanksActivity::class.java)
            // 第2画面に送るデータを格納
            intent2MenuThanks.putExtra("name", menuName)
            intent2MenuThanks.putExtra("price", "${menuPrice}円")
            // 第2画面の起動
            startActivity(intent2MenuThanks)
        }
    }
}