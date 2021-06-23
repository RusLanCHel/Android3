package com.example.mvptest.lessonB

import android.os.Bundle
import com.example.mvptest.R
import com.example.mvptest.databinding.ActivityMainB1Binding
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity1 : MvpAppCompatActivity(), MainView1 {

    val navigator = AppNavigator(this, R.id.container)

    private val presenter by moxyPresenter { MainPresenter1(router = App.instance.router, screens = AndroidScreens()) }
    private var vb: ActivityMainB1Binding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainB1Binding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if(it is BackButtonListener && it.backPressed()){
                return
            }
        }
        presenter.backClicked()
    }
}