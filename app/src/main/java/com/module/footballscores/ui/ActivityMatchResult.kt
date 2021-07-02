package com.module.footballscores.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.module.footballscores.R
import com.module.footballscores.dagger.App

class ActivityMatchResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
        setContentView(R.layout.activity_main_result_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ActivityMainResultFragment.newInstance())
                .commitNow()
        }
    }


}