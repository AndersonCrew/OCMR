package com.example.ocmr.ui.customer.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ocmr.R
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.ChattingFragmentBinding
import com.example.ocmr.databinding.HomeFragmentBinding
import com.example.ocmr.event.MessageEvent
import com.example.ocmr.event.RxBus
import com.example.ocmr.viewmodel.MainViewModel

class HomeFragment: BaseFragment<MainViewModel, HomeFragmentBinding>() {
    private var isVisibility = true
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onResume() {
        super.onResume()
        Log.d("onEventReceive", "HomeFragment onResume")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("onEventReceive", "HomeFragment onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onEventReceive", "HomeFragment onDestroy")
    }

    override fun initViews() {

    }

    override fun onPause() {
        super.onPause()
        isVisibility = false
        Log.d("onEventReceive", "HomeFragment onPause")
    }

    override fun onEventReceive(messageEvent: MessageEvent) {
        if(isVisibility) {
            when(messageEvent.key) {
                RxBus.ON_CHATTING_CLICK -> {
                    findNavController().navigate(R.id.actionHomeFragment_toChattingFragment)
                }
            }
        }
    }
}