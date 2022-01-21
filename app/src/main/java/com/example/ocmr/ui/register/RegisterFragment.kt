package com.example.ocmr.ui.register

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.LoginFragmentBinding
import com.example.ocmr.databinding.RegisterFragmentBinding
import com.example.ocmr.viewmodel.RegisterViewModel

class RegisterFragment: BaseFragment<RegisterViewModel, RegisterFragmentBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RegisterFragmentBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().window?.apply {
            decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_VISIBLE

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                var flags: Int = decorView.systemUiVisibility
                flags = flags or View.SYSTEM_UI_FLAG_VISIBLE
                decorView.systemUiVisibility = flags
            }

            navigationBarColor = Color.WHITE
        }

    }

    override fun initViews() {

    }

    override fun initObservers() {

    }
}