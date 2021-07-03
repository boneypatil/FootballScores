package com.module.footballscores.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.dagger.module.viewModule.ViewModelFactory
import com.module.footballscores.dagger.App
import com.module.footballscores.databinding.MainFragmentBinding
import com.module.footballscores.model.MatchResults
import com.module.footballscores.ui.adapters.MatchResultsAdapter
import com.module.footballscores.utils.hide
import javax.inject.Inject

class FragmentMatchResult : Fragment() {

    companion object {
        fun newInstance() = FragmentMatchResult()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var matchResultAdapter: MatchResultsAdapter

    private lateinit var viewModel: MatchResultViewModel
    private lateinit var binding: MainFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        App.appComponent.inject(this)
        binding = MainFragmentBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MatchResultViewModel::class.java)
        initAdapter()
        setObservers()

    }

    private fun initAdapter() {
        binding.recyclerMatchResults.adapter = MatchResultsAdapter {
            Toast.makeText(requireContext(), "${it.team_A}", Toast.LENGTH_LONG).show()
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

    private val loaderObserver = Observer<Boolean> { it ->
        if (it == false) binding.progressBar.hide()
    }

}