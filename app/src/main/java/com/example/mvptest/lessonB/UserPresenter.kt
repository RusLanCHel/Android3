package com.example.mvptest.lessonB

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter(val usersRepo: GithubUsersRepo, val router: Router): MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init(usersRepo.getUsers())
    }

    fun backPressed(): Boolean {
        router.navigateTo(AndroidScreens().users())
        return true
    }
}