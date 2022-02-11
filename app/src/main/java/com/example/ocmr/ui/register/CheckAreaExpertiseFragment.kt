package com.example.ocmr.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ocmr.R
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.CheckAreaExpertiseFragmentBinding
import com.example.ocmr.viewmodel.RegisterViewModel

class CheckAreaExpertiseFragment: BaseFragment<RegisterViewModel, CheckAreaExpertiseFragmentBinding>() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CheckAreaExpertiseFragmentBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun initViews() {
        binding?.btnNext?.setOnClickListener {
            findNavController().navigate(R.id.action_checkArea_to_select_item)
        }
    }
}