package com.example.ocmr.utils

import android.view.View
import androidx.constraintlayout.widget.Group
import com.google.android.material.snackbar.Snackbar

/**
 * Created by BM Anderson on 09/02/2022.
 */
fun View.showSnackBar(msgId: Int, length: Int, actionMessageId: Int) {
    showSnackBar(msgId, length, actionMessageId) {}
}

fun View.showSnackBar(
    msgId: Int,
    length: Int,
    actionMessageId: Int,
    action: (View) -> Unit
) {
    showSnackBar(context.getString(msgId), length, context.getString(actionMessageId), action)
}

fun View.showSnackBar(
    msg: String,
    length: Int,
    actionMessage: CharSequence?,
    action: (View) -> Unit
) {
    val snackbar = Snackbar.make(this, msg, length)
    if (actionMessage != null) {
        snackbar.setAction(actionMessage) {
            action(this)
        }.show()
    }
}

fun Group.setAllOnClickListener(listener: (View) -> Unit) {
    referencedIds.forEach { id ->
        rootView.findViewById<View>(id).setOnClickListener(listener)
    }
}