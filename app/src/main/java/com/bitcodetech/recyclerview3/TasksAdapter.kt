package com.bitcodetech.recyclerview3

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bitcodetech.recyclerview3.models.Task


class TasksAdapter(
    private val tasks : ArrayList<Task>
) : RecyclerView.Adapter<TasksAdapter.TaskViewHolder>() {

    interface OnTaskClickListener {
        fun onTaskImageClick(imgTask : ImageView, position : Int, task : Task)
        fun onTaskTitleClick(txtTaskTitle : TextView, position : Int, task : Task)
    }

    var onTaskClickListener : OnTaskClickListener? = null

    inner class TaskViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val imgTask : ImageView
        val txtTaskTitle : TextView
        val txtTaskDueDate : TextView
        val txtTaskStatus : TextView

        init {
            imgTask = view.findViewById(R.id.imgTask)
            txtTaskTitle = view.findViewById(R.id.txtTaskTitle)
            txtTaskDueDate = view.findViewById(R.id.txtTaskDueDate)
            txtTaskStatus = view.findViewById(R.id.txtTaskStatus)

            imgTask.setOnClickListener {
                onTaskClickListener?.onTaskImageClick(
                    it as ImageView,
                    adapterPosition,
                    tasks[adapterPosition]
                )
                /*it.context.startActivity(
                    Intent(
                        it.context,
                        TaskDetailsActivity::class.java
                    )
                )*/
            }

            txtTaskTitle.setOnClickListener {

                onTaskClickListener?.onTaskTitleClick(
                    it as TextView,
                    adapterPosition,
                    tasks[adapterPosition]
                )

                /*it.context.startActivity(
                    Intent(
                        it.context,
                        TaskDetailsActivity::class.java
                    )
                )*/
            }

        }
    }

    override fun getItemCount() = tasks.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        //create view
        val layoutInflater = LayoutInflater.from(parent.context)
        val taskView = layoutInflater.inflate(R.layout.task_view, null)

        return TaskViewHolder(taskView)

    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]

        holder.imgTask.setImageResource(task.imageId)
        holder.txtTaskTitle.text = task.title
        holder.txtTaskDueDate.text = task.dueDate
        holder.txtTaskStatus.text = "${task.status}"

        if(task.selected) {
            holder.itemView.setBackgroundColor(Color.GRAY)
        }
        else {
            holder.itemView.setBackgroundColor(Color.WHITE)
        }

    }
}