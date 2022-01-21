package com.example.ocmr.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

/**
 * Created by BM Anderson on 18/01/2022.
 */
abstract class BaseFragment<VM: BaseViewModel, VB: ViewBinding>: Fragment() {
    private val viewModel: VM?= null
    var binding: VB? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initObservers()
    }

    abstract fun initViews()
    abstract fun initObservers()

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}