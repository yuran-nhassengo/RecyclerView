package com.lamarck.recycler3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList = mutableListOf(
            Todo("Follow Android",false),
            Todo("Kotlin Android",true)
        )

        val adapter =TodoAdapter(todoList)
        rvTodo.adapter =adapter
        rvTodo.layoutManager= LinearLayoutManager(this)

        btnAdd.setOnClickListener {
            val title =etTodo.text.toString()
            val todo =Todo(title,false)
            etTodo.setText("")
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}