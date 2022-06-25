package com.example.innovatiaandroidtest.ui

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.innovatiaandroidtest.R
import com.example.innovatiaandroidtest.data.Model.Question


class OptionsAdapter(val context: Context): RecyclerView.Adapter<OptionsAdapter.QuestionViewHolder>() {

    private lateinit var question: Question
    inner class QuestionViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val optionTxt = itemView.findViewById<TextView>(R.id.option_txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.option_list_layout,parent,false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val option = question.options[position]
        holder.optionTxt.text = option
    }

    override fun getItemCount(): Int {
        return question.options.size
    }

    fun updateOptions(newQuestion:Question) {
        question = newQuestion
        notifyDataSetChanged()
    }
}