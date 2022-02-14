package com.example.ocmr.ui.customer.splash

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.example.ocmr.R
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.SplashFragmentBinding
import com.example.ocmr.utils.Constants
import com.example.ocmr.utils.PermissionUtil
import com.example.ocmr.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.ocmr.ui.customer.reveiver.CustomBroadcastReceiver
import com.example.ocmr.ui.customer.reveiver.ICusBro
import com.example.ocmr.utils.showSnackBar
import com.google.android.material.snackbar.Snackbar


/**
 * Created by BM Anderson on 18/01/2022.
 */
@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashViewModel, SplashFragmentBinding>() {

    @Inject
    lateinit var permission: PermissionUtil
    private var layout: View? = null
    private val requestMultiplePermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            if (permissions.entries.find { it -> it.value == false } == null) {
                goToLoginFragment()
            } else {
                layout?.showSnackBar(
                    R.string.permission_denied,
                    Snackbar.LENGTH_INDEFINITE,
                    R.string.ok
                )
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SplashFragmentBinding.inflate(inflater, container, false)
        layout = binding?.root
        return binding?.root
    }

    override fun initViews() {

        Handler(Looper.getMainLooper()).postDelayed({
            val splashTextAnim =
                AnimationUtils.loadAnimation(requireContext(), R.anim.text_splash_anim)
            splashTextAnim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {

                }

                override fun onAnimationEnd(p0: Animation?) {
                    if (permission.checkPermissions(
                            requireContext(),
                            Constants.storagePermission
                        )
                    ) {
                        goToLoginFragment()
                    } else {
                        requestMultiplePermission.launch(Constants.storagePermission)
                    }
                }

                override fun onAnimationRepeat(p0: Animation?) {

                }

            })
            binding?.tvMessage?.startAnimation(splashTextAnim)
            binding?.tvMessage?.visibility = View.VISIBLE
        }, 800)
    }

    private fun goToLoginFragment() {
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }, 500)

    }


}