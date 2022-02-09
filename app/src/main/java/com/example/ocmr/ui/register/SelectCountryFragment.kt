package com.example.ocmr.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.SelectCountryFragmentBinding
import com.example.ocmr.viewmodel.RegisterViewModel

class SelectCountryFragment: BaseFragment<RegisterViewModel, SelectCountryFragmentBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SelectCountryFragmentBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun initViews() {

    }

    override fun initObservers() {

    }

}