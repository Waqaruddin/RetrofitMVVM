package com.example.a1119retrofitmvvm.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a1119retrofitmvvm.Model.Users
import com.example.a1119retrofitmvvm.R
import com.example.a1119retrofitmvvm.ViewModel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val model: MyViewModel by viewModels()
    var mList:ArrayList<Users> = ArrayList()
    private var adapter:MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        adapter = MyAdapter(this, mList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter

        model.getUsers().observe(this , {
            adapter?.setData(it)
        })

    }
}