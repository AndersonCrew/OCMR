package com.example.ocmr.ui.splash

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ocmr.R
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.SplashFragmentBinding
import com.example.ocmr.viewmodel.SplashViewModel

/**
 * Created by BM Anderson on 18/01/2022.
 */
class SplashFragment: BaseFragment<SplashViewModel, SplashFragmentBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SplashFragmentBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun initViews() {
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }, 2000)
    }

    override fun initObservers() {

    }
}