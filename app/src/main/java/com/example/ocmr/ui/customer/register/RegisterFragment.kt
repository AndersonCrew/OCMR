package com.example.ocmr.ui.customer.register

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.ocmr.R
import com.example.ocmr.base.BaseFragment
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

    override fun initViews() {
        binding?.apply {
            cardHelpCraftsman.setOnClickListener {
                if (ckHelpCraftsman.isChecked) {
                    csHelpCraftsman.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
                    ckHelpCraftsman.isChecked = false
                    tvTitle.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorMainBlack))
                    tvMessageHelpCraftsman.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorGray3))
                } else {
                    csHelpCraftsman.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.black))
                    ckHelpCraftsman.isChecked = true
                    tvTitle.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                    tvMessageHelpCraftsman.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorWhite80))
                }
            }

            cardJoinMaster.setOnClickListener {
                if (ckJoinMaster.isChecked) {
                    csJoinMaster.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
                    ckJoinMaster.isChecked = false
                    tvTitleJoinMaster.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorMainBlack))
                    tvMessageJoinMaster.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorGray3))

                    csTermAndCondition.visibility = View.GONE
                } else {
                    csJoinMaster.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.black))
                    ckJoinMaster.isChecked = true
                    tvTitleJoinMaster.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                    tvMessageJoinMaster.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorWhite80))

                    csTermAndCondition.visibility = View.VISIBLE
                }
            }

            btnSignUp.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_registerStepFragment)
            }
        }

        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {

            }
        }.start()
    }
}