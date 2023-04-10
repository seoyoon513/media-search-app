package com.syoon.mediasearchapp

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.syoon.mediasearchapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            view = this@MainActivity
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                // 입력 완료 버튼 누를 시 호출
                override fun onQueryTextSubmit(query: String?): Boolean {
                    Log.d("입력완료","$query")
                    return false
                }

                // 검색창의 text가 변경될 때마다 호출
                override fun onQueryTextChange(newText: String?): Boolean {
                    Log.d("입력중","$newText")
                    return false
                }

            })
        }

        return true
    }
}