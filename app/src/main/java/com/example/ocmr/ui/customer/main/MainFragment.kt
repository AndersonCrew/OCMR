package com.example.ocmr.ui.customer.main

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.findNavController
import com.example.ocmr.R
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.MainFragmentBinding
import com.example.ocmr.event.MessageEvent
import com.example.ocmr.event.RxBus
import com.example.ocmr.viewmodel.MainViewModel


class MainFragment: BaseFragment<MainViewModel, MainFragmentBinding>() {
    private var imgClose: ImageView?= null
    private var tvHome: TextView?= null
    private var tvChatting: TextView?= null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun initViews() {
        val headerLayout = binding?.navView?.getHeaderView(0)
        imgClose = headerLayout?.findViewById(R.id.imgClose)
        tvHome = headerLayout?.findViewById(R.id.tvHome)
        tvChatting = headerLayout?.findViewById(R.id.tvChatting)

        binding?.appBarMain?.imgMenu?.setOnClickListener {
            binding?.drawerLayout?.openDrawer(GravityCompat.START)
        }

        imgClose?.setOnClickListener {
            binding?.drawerLayout?.closeDrawer(GravityCompat.START)
        }

        tvHome?.setOnClickListener {
            onDrawerClick(RxBus.ON_HOME_CLICK)
        }

        tvChatting?.setOnClickListener {
            onDrawerClick(RxBus.ON_CHATTING_CLICK)
        }
    }

    private fun onDrawerClick(action: String) {
        binding?.drawerLayout?.closeDrawer(GravityCompat.START)
        RxBus.publish(MessageEvent(action, ""))
    }
}