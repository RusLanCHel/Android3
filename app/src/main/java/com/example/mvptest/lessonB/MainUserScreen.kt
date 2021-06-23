package com.example.mvptest.lessonB

import com.github.terrakok.cicerone.androidx.FragmentScreen

class MainUserScreen: UserScreen {
    override fun userScreen(counter: Int) = FragmentScreen{ UserFragment().newInstance(counter) }

}