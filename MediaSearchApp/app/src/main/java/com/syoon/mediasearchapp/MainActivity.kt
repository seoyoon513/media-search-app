package com.syoon.mediasearchapp

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.syoon.mediasearchapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val searchFragment = SearchFragment() // 전역변수 - 검색을 했을 때 바로 전달
    private val fragmentList = listOf(searchFragment, FavoriteFragment())
    private val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle, fragmentList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            view = this@MainActivity
            viewPager.adapter = adapter

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = if(fragmentList[position] is SearchFragment) {
                    "검색 결과"
                } else {
                    "즐겨 찾기"
                }
            }.attach()
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