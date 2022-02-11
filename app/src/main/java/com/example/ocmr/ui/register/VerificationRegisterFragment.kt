package com.example.ocmr.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.VerifyPhoneNumberFragmentBinding
import com.example.ocmr.viewmodel.RegisterViewModel

class VerificationRegisterFragment: BaseFragment<RegisterViewModel, VerifyPhoneNumberFragmentBinding>() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = VerifyPhoneNumberFragmentBinding.inflate(inflater, container, false)

        return binding?.root
    }
    override fun initViews() {

    }
}