package com.example.ocmr.ui.customer.login

import android.os.Bundle
import android.view.*
import androidx.navigation.fragment.findNavController
import com.example.ocmr.R
import com.example.ocmr.base.BaseFragment
import com.example.ocmr.databinding.LoginFragmentBinding
import com.example.ocmr.viewmodel.LoginViewModel
import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException
import org.json.JSONException

import org.json.JSONObject

import io.socket.emitter.Emitter




class LoginFragment: BaseFragment<LoginViewModel, LoginFragmentBinding>() {

    private var socket: Socket?= null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun initViews() {
        binding?.tvRegister?.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding?.btnLogin?.setOnClickListener {
            socket?.emit("new message", "ABC");
        }


        try {
            socket = IO.socket("http://chat.socket.io")
        } catch (e: URISyntaxException) {
            e.printStackTrace()
        }

        socket?.on("new message", onNewMessage)
        socket?.connect()

    }

    override fun initObservers() {

    }

    override fun onDestroy() {
        super.onDestroy()
        socket?.disconnect()
        socket?.off("new message", onNewMessage)
    }

    private fun checkValidation(): String? {
        if(binding?.formEmail?.getTextForm().isNullOrEmpty()) {
           return "Please enter your Email!"
        }
        return null
    }

    private val onNewMessage =
        Emitter.Listener { args ->
            requireActivity().runOnUiThread(Runnable {
                val data = args[0] as JSONObject
                val username: String
                val message: String
                try {
                    username = data.getString("username")
                    message = data.getString("message")
                } catch (e: JSONException) {
                    return@Runnable
                }

                // add the message to view
                //addMessage(username, message)
            })
        }


}