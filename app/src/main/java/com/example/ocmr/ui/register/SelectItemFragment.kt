package com.example.ocmr.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.SelectItemFragmentBinding
import com.example.ocmr.viewmodel.RegisterViewModel

class SelectItemFragment: BaseFragment<RegisterViewModel, SelectItemFragmentBinding>() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SelectItemFragmentBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun initViews() {

    }

    override fun initObservers() {

    }
}