package com.module.footballscores.base


import androidx.fragment.app.Fragment
import com.module.footballscores.model.MatchResults

abstract class BaseResultDashboardFragment : Fragment() {

    private var dashboardListener: DashboardListener? = null


    protected fun onResultSelected(matchResult: MatchResults) {
        dashboardListener?.onResultSelected(matchResult)
    }

    fun setListener(listener: DashboardListener) {
        this.dashboardListener = listener
    }

    interface DashboardListener {
        fun onResultSelected(matchResult: MatchResults)
    }


}