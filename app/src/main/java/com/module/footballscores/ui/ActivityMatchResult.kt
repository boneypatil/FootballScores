package com.module.footballscores.ui

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.module.footballscores.R
import com.module.footballscores.base.BaseResultDashboardFragment
import com.module.footballscores.model.MatchResults

open class ActivityMatchResult : AppCompatActivity(),
    BaseResultDashboardFragment.DashboardListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_result_activity)
        selectScreen(MatchResultDashboardScreen.MatchResultScreen)
    }


    private fun selectScreen(
        dashboardScreen: MatchResultDashboardScreen,
        bundleToSend: Bundle? = null
    ) {
        val fragment: BaseResultDashboardFragment = when (dashboardScreen) {
            MatchResultDashboardScreen.MatchResultScreen -> FragmentMatchResult()
            MatchResultDashboardScreen.MatchResultDetailScreen -> FragmentMatchResultDetails()
        }
        fragment.setListener(this)
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

    override fun onResultSelected(matchResult: MatchResults) {
        selectScreen(
            MatchResultDashboardScreen.MatchResultDetailScreen,
            bundleOf(Pair(getString(R.string.intent_extra_match_result), matchResult))
        )
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
                supportFragmentManager.popBackStack()
            }else
                this.finish()

    }

}