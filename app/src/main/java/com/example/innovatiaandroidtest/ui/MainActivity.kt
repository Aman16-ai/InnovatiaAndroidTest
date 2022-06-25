package com.example.innovatiaandroidtest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.innovatiaandroidtest.R
import com.example.innovatiaandroidtest.data.Model.Question

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var questiontxt : TextView
    private lateinit var nextBtn : TextView
    private lateinit var questionImg : ImageView
    private lateinit var questionProgress : ProgressBar
    private lateinit var optionsAdapter: OptionsAdapter

    val questionViewModel : QuestionViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        questiontxt = findViewById(R.id.question_txt)
        nextBtn = findViewById(R.id.next_btn)
        questionImg = findViewById(R.id.question_img)
        questionProgress = findViewById(R.id.quiz_progress)


        nextBtn.setOnClickListener {
            questionViewModel.updateQuestion()
        }

        optionsAdapter = OptionsAdapter(this)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = optionsAdapter
        }


        questionViewModel.questionLiveData.observe(this) {
            it?.let {
                questiontxt.text = it.question
                questionImg.setImageResource(it.imgUrl.toInt())
                optionsAdapter.updateOptions(it)
            }
        }

        questionViewModel.questionProgress.observe(this){
            questionProgress.progress = it.toInt()
        }
    }



}