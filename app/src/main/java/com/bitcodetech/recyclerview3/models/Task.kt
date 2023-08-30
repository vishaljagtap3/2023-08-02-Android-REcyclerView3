package com.bitcodetech.recyclerview3.models

class Task(
    val id : Int,
    val title : String,
    val dueDate : String,
    val imageId : Int,
    val status : Boolean,
    var selected : Boolean = false
)