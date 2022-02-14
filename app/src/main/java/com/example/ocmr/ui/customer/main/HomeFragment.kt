package com.example.ocmr.ui.customer.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.ocmr.R
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.ChattingFragmentBinding
import com.example.ocmr.databinding.HomeFragmentBinding
import com.example.ocmr.event.MessageEvent
import com.example.ocmr.event.RxBus
import com.example.ocmr.viewmodel.MainViewModel
import android.widget.LinearLayout

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.Gravity


import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.viewpager.widget.ViewPager
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment: BaseFragment<MainViewModel, HomeFragmentBinding>() {
    private var isVisibility = true
    private val dots: ArrayList<ImageView> = arrayListOf()
    private val handler = Handler(Looper.getMainLooper())
    private val runnableViewPager = Runnable {
        binding?.viewPagerBanner?.currentItem = binding?.viewPagerBanner?.currentItem?: 0 + 1
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun initViews() {
        //Init Viewpager with view
        initViewPager()
    }

    private fun initViewPager() {
        binding?.viewPagerBanner?.adapter = BannerAdapter(requireContext())

        for (i in 0 until 4) {
            dots.add(i, ImageView(requireContext()))
            dots[i].setImageDrawable(
                ContextCompat.getDrawable(requireContext(),
                    R.drawable.indicator_default
                )
            )
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(16, 0, 16, 0)
            binding?.llDots?.addView(dots[i], params)
        }

        dots[0].setImageDrawable(
            ContextCompat.getDrawable(requireContext(),
                R.drawable.indicator_selected
            )
        )

        handler.postDelayed(runnableViewPager, 1000)

        binding?.viewPagerBanner?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                changeDotBackground(position)
                handler.removeCallbacks(runnableViewPager)
                handler.postDelayed(runnableViewPager, 1000)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

    }

    private fun changeDotBackground(position: Int) {
        for(i in 0 until 4) {
            dots[i].setImageDrawable(
                ContextCompat.getDrawable(requireContext(),
                    if(i == position) R.drawable.indicator_selected else  R.drawable.indicator_default
                )
            )
        }
    }

    override fun onEventReceive(messageEvent: MessageEvent) {
        when(messageEvent.key) {
            RxBus.ON_CHATTING_CLICK -> {
                findNavController().navigate(R.id.actionHomeFragment_toChattingFragment)
            }
        }
    }
}