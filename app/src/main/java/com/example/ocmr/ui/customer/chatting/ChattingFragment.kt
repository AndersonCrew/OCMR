package com.example.ocmr.ui.customer.chatting

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ocmr.R
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.ChattingFragmentBinding
import com.example.ocmr.event.MessageEvent
import com.example.ocmr.event.RxBus
import com.example.ocmr.viewmodel.ChattingViewModel

class ChattingFragment: BaseFragment<ChattingViewModel, ChattingFragmentBinding>() {

    private var isVisibility = true
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ChattingFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onResume() {
        super.onResume()
        Log.d("onEventReceive", "ChattingFragment onResume")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("onEventReceive", "ChattingFragment onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onEventReceive", "ChattingFragment onDestroy")
    }

    override fun initViews() {

    }

    override fun onPause() {
        super.onPause()
        isVisibility = false
        Log.d("onEventReceive", "ChattingFragment onPause")
    }

    override fun onEventReceive(messageEvent: MessageEvent) {
        super.onEventReceive(messageEvent)
        if(isVisibility) {
            when(messageEvent.key) {
                RxBus.ON_HOME_CLICK -> {
                    findNavController().navigate(R.id.actionChattingFragment_toHomeFragment)
                }
            }
        }
    }
}