package com.example.mvptest.lessonB

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter1(val router: Router, val screens: IScreens) : MvpPresenter<MainView1>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }
}