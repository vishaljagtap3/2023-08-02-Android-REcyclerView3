package com.bitcodetech.recyclerview3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bitcodetech.recyclerview3.models.Task

class MainActivity : AppCompatActivity() {

    private val tasks = ArrayList<Task>()
    private lateinit var recyclerTasks: RecyclerView
    private lateinit var tasksAdapter: TasksAdapter
    private lateinit var chkSelect: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTasks()
        initViews()
    }

    private fun initViews() {
        setContentView(R.layout.activity_main)

        chkSelect = findViewById(R.id.chkSelect)

        recyclerTasks = findViewById(R.id.recyclerTasks)
        recyclerTasks.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        tasksAdapter = TasksAdapter(tasks)
        tasksAdapter.onTaskClickListener = MyOnTaskClickListener()
        recyclerTasks.adapter = tasksAdapter
    }

    private inner class MyOnTaskClickListener : TasksAdapter.OnTaskClickListener {
        override fun onTaskImageClick(imgTask: ImageView, position: Int, task: Task) {
            if (chkSelect.isChecked) {
                task.selected = !task.selected
                tasksAdapter.notifyItemChanged(position)
            } else {
                val intent = Intent(
                    this@MainActivity,
                    TaskDetailsActivity::class.java
                )
                intent.putExtra("task", task)
                startActivity(intent)
            }
        }

        override fun onTaskTitleClick(txtTaskTitle: TextView, position: Int, task: Task) {

        }
    }

    private fun initTasks() {
        tasks.add(Task(1, "Pay bills", "12-09-2023", R.mipmap.ic_launcher, false))
        tasks.add(Task(2, "Finish the assignments", "12-09-2023", R.mipmap.ic_launcher, true))
        tasks.add(Task(3, "Call office", "1-11-2023", R.mipmap.ic_launcher, false))
        tasks.add(Task(4, "Email work plan", "30-09-2023", R.mipmap.ic_launcher, true))
        tasks.add(Task(5, "Plan the party", "16-09-2023", R.mipmap.ic_launcher, false))
        tasks.add(Task(6, "XYZ something", "21-09-2023", R.mipmap.ic_launcher, false))
        tasks.add(Task(7, "Something xyz", "12-10-2023", R.mipmap.ic_launcher, true))
        tasks.add(Task(1, "Pay bills", "12-09-2023", R.mipmap.ic_launcher, false))
        tasks.add(Task(2, "Finish the assignments", "12-09-2023", R.mipmap.ic_launcher, true))
        tasks.add(Task(3, "Call office", "1-11-2023", R.mipmap.ic_launcher, false))
        tasks.add(Task(4, "Email work plan", "30-09-2023", R.mipmap.ic_launcher, true))
        tasks.add(Task(5, "Plan the party", "16-09-2023", R.mipmap.ic_launcher, false))
        tasks.add(Task(6, "XYZ something", "21-09-2023", R.mipmap.ic_launcher, false))
        tasks.add(Task(7, "Something xyz", "12-10-2023", R.mipmap.ic_launcher, true))
    }
}