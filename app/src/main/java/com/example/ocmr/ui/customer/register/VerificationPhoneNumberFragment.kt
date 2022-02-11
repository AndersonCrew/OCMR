package com.example.ocmr.ui.customer.register

import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.CheckAreaExpertiseFragmentBinding
import com.example.ocmr.databinding.VerificationPhonenumberFragmentBinding
import com.example.ocmr.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.verification_phonenumber_fragment.*

/**
 * Created by BM Anderson on 09/02/2022.
 */
class VerificationPhoneNumberFragment: BaseFragment<RegisterViewModel, VerificationPhonenumberFragmentBinding>() {

    private var timer: CountDownTimer?= null
    private var DURATION_COUNT_TIME = 90000L
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = VerificationPhonenumberFragmentBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun initViews() {
        binding?.etPhoneNumber?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                binding?.btnGetVerification?.isEnabled =
                    binding?.etPhoneNumber?.text.toString().isNotEmpty()

                binding?.btnNext?.isEnabled =
                    binding?.etPhoneNumber?.text.toString().isNotEmpty() && binding?.etCode?.text.toString().isNotEmpty()
            }

        })

        binding?.etCode?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                binding?.btnNext?.isEnabled =
                    binding?.etPhoneNumber?.text.toString().isNotEmpty() && binding?.etCode?.text.toString().isNotEmpty()
            }

        })

        binding?.btnGetVerification?.setOnClickListener {
            binding?.tvCountTimeResendCode?.visibility = View.VISIBLE
            binding?.tvTimeCountCode?.visibility = View.VISIBLE
            startCountTimeResendCode()
        }
    }

    fun formatDuration(seconds: Long): String = if (seconds < 60) {
        seconds.toString()
    } else {
        DateUtils.formatElapsedTime(seconds)
    }

    private fun startCountTimeResendCode() {
        timer = object : CountDownTimer(DURATION_COUNT_TIME, 1000) {
            override fun onTick(p0: Long) {
                binding?.tvCountTimeResendCode?.text = formatDuration(p0 / 1000)
            }

            override fun onFinish() {

            }
        }.start()
    }
}