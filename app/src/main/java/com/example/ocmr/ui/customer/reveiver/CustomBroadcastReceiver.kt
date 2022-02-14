package com.example.ocmr.ui.customer.reveiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class CustomBroadcastReceiver constructor(private val listener: ICusBro): BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        val number = p1?.getIntExtra("ABC", 20)?: 20
        listener.abc(number)
    }
}
interface ICusBro {
    fun abc(number: Int)
}