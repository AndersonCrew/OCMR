package com.example.ocmr.ui.customer.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.SearchFragmentBinding
import com.example.ocmr.viewmodel.SearchViewModel

class SearchFragment: BaseFragment<SearchViewModel, SearchFragmentBinding>() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun initViews() {

    }
}