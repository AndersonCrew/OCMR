package com.example.ocmr.ui.customer.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.EnterPersonalInformationFragmentBinding
import com.example.ocmr.databinding.RegisterFragmentBinding
import com.example.ocmr.viewmodel.RegisterViewModel

/**
 * Created by BM Anderson on 09/02/2022.
 */
class EnterPersonalInformationFragment: BaseFragment<RegisterViewModel, EnterPersonalInformationFragmentBinding>() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EnterPersonalInformationFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun initViews() {

    }

    override fun initObservers() {

    }
}