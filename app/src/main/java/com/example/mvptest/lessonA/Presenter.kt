package com.example.mvptest.lessonA

class Presenter(private val view: View, private val model: Model) {
    fun incrementCounter(counterNo: Int){
        counterNo
            .let(model::incrementCounter)
            .let { counter -> view.showCounter(counterNo, counter, if (counter > 3) 0 else 1)}
    }
}