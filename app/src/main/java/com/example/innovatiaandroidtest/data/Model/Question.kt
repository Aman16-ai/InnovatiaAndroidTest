package com.example.innovatiaandroidtest.data.Model

data class Question(
    val id:Int,
    val question:String,
    val imgUrl : String,
    val options:List<String>,
    val correct:String
)
