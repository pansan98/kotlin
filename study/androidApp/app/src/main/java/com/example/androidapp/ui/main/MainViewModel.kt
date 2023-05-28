package com.example.androidapp.ui.main

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    val data: ObservableArrayList<String> = ObservableArrayList<String>()
    val alltext: ObservableField<String> = ObservableField<String>()

    fun getAll():String {
        return data.joinToString("\n")
    }

    fun add(s:String) {
        data.add(s)
        alltext.set(getAll())
    }

    init {
        data.add("Taro")
        data.add("Hanako")
        alltext.set(getAll())
    }
}