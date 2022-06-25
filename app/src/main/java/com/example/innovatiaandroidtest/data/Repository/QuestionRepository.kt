package com.example.innovatiaandroidtest.data.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.innovatiaandroidtest.R
import com.example.innovatiaandroidtest.data.Model.Question

class QuestionRepository {

    fun questionsData() : List<Question> {
        val question1 = Question(
            id = 1,
            question = "Programming langauge which does not support oops",
            imgUrl = R.drawable.kotlinimg.toString(),
            options = listOf("c","c++","python","kotlin"),
            correct = "c"
        )

        val question2 = Question(
            id = 2,
            question = "How to create an array of integer of size 5",
            imgUrl = R.drawable.quizimg.toString(),
            options = listOf("new Int[5]","MakeArray<Int>(5)","IntArray(5)"),
            correct = "IntArray(5)"
        )


    val question3 = Question(
        id = 3,
        question = "which of the following statement is true",
        imgUrl = R.drawable.kotlinimg.toString(),
        options = listOf("Child can store the address of parent class","Parent can store the address of child class"),
        correct = "Parent can store the address of child class"
    )

        val question4 = Question(
            id = 4,
            question = "Question 4",
            imgUrl = R.drawable.quizimg.toString(),
            options = listOf("option1","option3","option4"),
            correct = "option4"
        )


        val questions = ArrayList<Question>()
        questions.add(question1)
        questions.add(question2)
        questions.add(question3)
        questions.add(question4)
        return questions
    }

}