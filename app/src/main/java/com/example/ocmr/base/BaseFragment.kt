package com.example.ocmr.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.ocmr.event.MessageEvent
import com.example.ocmr.event.RxBus
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by BM Anderson on 18/01/2022.
 */
abstract class BaseFragment<VM: BaseViewModel, VB: ViewBinding>: Fragment() {
    private val viewModel: VM?= null
    var binding: VB? = null
    var eventDisposable: CompositeDisposable = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RxBus.publisher
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { onEventReceive(it) }
            .addTo(eventDisposable)

        initViews()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        eventDisposable.dispose()
    }

    abstract fun initViews()

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    open fun onEventReceive(messageEvent: MessageEvent) {

    }
}
