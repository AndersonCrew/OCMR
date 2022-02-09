package com.example.ocmr.ui.customer.forgot_password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.ocmr.R
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.CheckAreaExpertiseFragmentBinding
import com.example.ocmr.databinding.ForgotPasswordFragmentBinding
import com.example.ocmr.viewmodel.ForgotPasswordViewModel

/**
 * Created by BM Anderson on 09/02/2022.
 */
class ForgotPasswordFragment: BaseFragment<ForgotPasswordViewModel, ForgotPasswordFragmentBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ForgotPasswordFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }
    override fun initViews() {
        binding?.imgBack?.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun initObservers() {

    }
}