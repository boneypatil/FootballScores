package com.module.footballscores.ui

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.module.footballscores.R
import com.module.footballscores.dagger.App

open class ActivityMatchResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
        setContentView(R.layout.activity_main_result_activity)
        selectScreen(MatchResultDashboardScreen.MatchResultScreen)
    }


    private fun selectScreen(
        dashboardScreen: MatchResultDashboardScreen,
        bundleToSend: Bundle? = null
    ) {
        val fragment: Fragment = when (dashboardScreen) {
            MatchResultDashboardScreen.MatchResultScreen -> FragmentMatchResult()
            MatchResultDashboardScreen.MatchResultDetailScreen -> FragmentMatchResult()
        }
        transactFragment(fragment, R.id.container, arguments = bundleToSend)
    }

    private enum class MatchResultDashboardScreen {
        MatchResultScreen, MatchResultDetailScreen
    }

    private fun transactFragment(
        frag: Fragment,
        @IdRes fragmentContainer: Int,
        arguments: Bundle? = null,
        retain: Boolean = true
    ) {
        val transaction = supportFragmentManager.beginTransaction()
            .apply {
                if (retain) addToBackStack(null)
                replace(fragmentContainer, frag, frag.tag)
            }
        arguments?.let {
            frag.arguments = it
        }

        transaction
            .commit()
    }

}