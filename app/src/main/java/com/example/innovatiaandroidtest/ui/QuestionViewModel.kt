package com.example.innovatiaandroidtest.ui

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.innovatiaandroidtest.data.Model.Question
import com.example.innovatiaandroidtest.data.Repository.QuestionRepository

class QuestionViewModel:ViewModel() {

    private val questionRepository = QuestionRepository()
    private var index : Int = 0


    private var _questionLiveData = MutableLiveData<Question>()
    val questionLiveData : LiveData<Question>
    get() = _questionLiveData

    private var _questionProgress = MutableLiveData<Float>()
    val questionProgress : LiveData<Float>
    get() = _questionProgress

    private var questionList : List<Question> = ArrayList()

    init {
        questionList = questionRepository.questionsData()
        _questionLiveData.postValue(questionList[index])
    }

    fun updateProgress() {
        val progress  = ((index).toFloat()/questionList.size.toFloat()) * 100
        _questionProgress.value = progress
    }

    fun updateQuestion() {
        index++
        updateProgress()
        if(index < questionList.size) {
            _questionLiveData.postValue(questionList[index])
        }
    }


}