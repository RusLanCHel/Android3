package com.example.mvptest.lessonB

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mvptest.databinding.FragmentUserBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import kotlin.properties.Delegates

class UserFragment: MvpAppCompatFragment(), UserView, BackButtonListener{

    var loginCounter: Int? = null

    fun newInstance(counter: Int): UserFragment {
        loginCounter = counter
        return UserFragment()
    }

    val presenter: UserPresenter by moxyPresenter { UserPresenter(GithubUsersRepo(), App.instance.router) }

    private var vb: FragmentUserBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentUserBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init(data: List<GithubUser>) {
        vb?.textViewUser?.text = data[loginCounter?: 0].toString()
    }

    override fun backPressed(): Boolean {
        return presenter.backPressed()
    }
}