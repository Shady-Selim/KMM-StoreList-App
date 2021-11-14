package com.shady.kmm.android.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.shady.kmm.Greeting
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.shady.kmm.android.R

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vm = ViewModelProvider(this)[MainViewModel::class.java]
        vm.getBanners().observe(this, {
            Log.d("result from KMM", it.toString())
        })

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()
    }
}
