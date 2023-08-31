package com.bitcodetech.recyclerview3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bitcodetech.recyclerview3.models.Task

class TaskDetailsActivity : AppCompatActivity() {

    private lateinit var task : Task

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        task = intent.getSerializableExtra("task") as Task
    }
}