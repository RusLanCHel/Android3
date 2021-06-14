package com.example.mvptest.lessonA

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mvptest.R

class MainActivity : AppCompatActivity(), View {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        val presenter = Presenter(this, Model())

        button1.setOnClickListener{
            presenter.incrementCounter(0)
        }
        button2.setOnClickListener {
            presenter.incrementCounter(1)
        }
        button3.setOnClickListener {
            presenter.incrementCounter(2)
        }
    }

    fun initViews(){
        button1 = findViewById<Button>(R.id.btn1)
        button2 = findViewById<Button>(R.id.btn2)
        button3 = findViewById<Button>(R.id.btn3)
    }
    override fun showCounter(counterNo: Int, counter: Int, color: Int) {
        when(counterNo){
            0 -> button1.text = counter.toString()
            1 -> button2.text = counter.toString()
            2 -> button3.text = counter.toString()
        }
    }

}