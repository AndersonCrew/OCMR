package com.example.ocmr.ui.customer.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.example.ocmr.R
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.SplashFragmentBinding
import com.example.ocmr.utils.PermissionUtil
import com.example.ocmr.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by BM Anderson on 18/01/2022.
 */
@AndroidEntryPoint
class SplashFragment: BaseFragment<SplashViewModel, SplashFragmentBinding>() {

    @Inject lateinit var permission: PermissionUtil
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
            val splashTextAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.text_splash_anim)
            binding?.tvMessage?.startAnimation(splashTextAnim)
            binding?.tvMessage?.visibility = View.VISIBLE
        }, 800)
    }

    override fun initObservers() {

    }
}