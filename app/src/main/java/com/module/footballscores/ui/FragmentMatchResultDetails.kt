package com.module.footballscores.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.module.footballscores.R
import com.module.footballscores.base.BaseResultDashboardFragment
import com.module.footballscores.databinding.FragmentMatchResultDetailBinding
import com.module.footballscores.model.MatchResults

class FragmentMatchResultDetails : BaseResultDashboardFragment() {


    private lateinit var binding: FragmentMatchResultDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMatchResultDetailBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readBundle()

    }

    private fun readBundle() {
        val matchResult =
            arguments?.getSerializable(getString(R.string.intent_extra_match_result)) as MatchResults
        binding.detailMatchResult = matchResult
    }

}