package com.example.ocmr.ui.login

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import androidx.navigation.fragment.findNavController
import com.example.ocmr.R
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.LoginFragmentBinding
import com.example.ocmr.viewmodel.LoginViewModel

class LoginFragment: BaseFragment<LoginViewModel, LoginFragmentBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun initViews() {
        binding?.tvRegister?.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding?.btnLogin?.setOnClickListener {
            if(checkValidation() == null) {

            } else {
                binding?.formEmail?.onError(checkValidation()!!)
            }
        }
    }

    override fun initObservers() {

    }

    private fun checkValidation(): String? {
        if(binding?.formEmail?.getTextForm().isNullOrEmpty()) {
           return "Please enter your Email!"
        }
        return null
    }


}