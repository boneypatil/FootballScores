package com.module.footballscores.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.dagger.module.viewModule.ViewModelFactory
import com.module.footballscores.base.BaseResultDashboardFragment
import com.module.footballscores.dagger.App
import com.module.footballscores.databinding.FragmentMainResultBinding
import com.module.footballscores.model.MatchResults
import com.module.footballscores.ui.adapters.MatchResultsAdapter
import com.module.footballscores.utils.show
import com.module.footballscores.viewmodel.MatchResultViewModel
import javax.inject.Inject

class FragmentMatchResult : BaseResultDashboardFragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var matchResultAdapter: MatchResultsAdapter

    private lateinit var viewModel: MatchResultViewModel
    private lateinit var binding: FragmentMainResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        App.appComponent.inject(this)
        binding = FragmentMainResultBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MatchResultViewModel::class.java)
        initAdapter()
        setObservers()
        initListener()
    }

    private fun initListener() {
        binding.swipe.setOnRefreshListener {
            viewModel.loadMatchResult()
        }
    }

    private fun initAdapter() {
        binding.recyclerMatchResults.adapter = MatchResultsAdapter {
            onResultSelected(it)
        }
        matchResultAdapter = binding.recyclerMatchResults.adapter as MatchResultsAdapter
    }

    private fun setObservers() {
        viewModel.matchResultLiveData.observe(viewLifecycleOwner, matchResultObserver)
        viewModel.isLoading.observe(viewLifecycleOwner, loaderObserver)

    }

    private val matchResultObserver = Observer<List<MatchResults>> { list ->
        matchResultAdapter.submitList(list)
    }

    private val loaderObserver = Observer<Boolean> {
        if (it == false){ binding.progressBar.show(it)
        binding.swipe.isRefreshing = it}
    }

}