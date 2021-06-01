package com.example.mvptest

class Model {
    private val counters = mutableListOf(0, 0, 0)

    fun incrementCounter(counterNo: Int): Int = ++counters[counterNo]

    //fun getCounter(counterNo: Int): Int = counters[counterNo]
}