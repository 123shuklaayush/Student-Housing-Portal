package com.example.hostelmanagement.warden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.hostelmanagement.R
import com.example.hostelmanagement.databinding.FragmentWardenLoginBinding

class WardenLogin : Fragment() {

    lateinit var binding: FragmentWardenLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.fragment_warden_login,
                container,
                false
        )

        //seting on click listeners

        binding.wardenLoginButton.setOnClickListener {
            if (loginSuccessful()) {
                it.findNavController().navigate(R.id.action_wardenLogin_to_wardenAfterLogin)
            }
        }


        return binding.root
    }

    private fun loginSuccessful(): Boolean {
        if (binding.wardenEmail.text.toString() == "" || binding.wardenPassword.text.toString() == "") {
            Toast.makeText(context, "Enter All Details", Toast.LENGTH_SHORT).show()
            return false
        }
        if (binding.wardenEmail.text.toString() == "harshgoud@iiitn.ac.in" && binding.wardenPassword.text.toString() == "Password") {
            return true
        }
        Toast.makeText(context, "wrong Details", Toast.LENGTH_SHORT).show()
        return false
    }

}