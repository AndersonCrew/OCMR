package com.example.ocmr.ui.customer.forgot_password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.CheckAreaExpertiseFragmentBinding
import com.example.ocmr.databinding.SetNewPasswordFragmentBinding
import com.example.ocmr.viewmodel.ForgotPasswordViewModel

/**
 * Created by BM Anderson on 09/02/2022.
 */
class SetNewPasswordFragment: BaseFragment<ForgotPasswordViewModel, SetNewPasswordFragmentBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SetNewPasswordFragmentBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun initViews() {

    }

    override fun initObservers() {

    }
}