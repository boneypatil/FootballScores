package com.module.footballscores.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.dagger.module.viewModule.ViewModelFactory
import com.module.footballscores.dagger.App
import com.module.footballscores.databinding.MainFragmentBinding
import com.module.footballscores.utils.hide
import javax.inject.Inject

class FragmentMatchResult : Fragment() {

    companion object {
        fun newInstance() = FragmentMatchResult()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

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
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it == false) binding.progressBar.hide()
        })
    }

}