package com.example.hostelmanagement.warden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.hostelmanagement.R
import com.example.hostelmanagement.databinding.FragmentWardenAfterLoginBinding

class WardenAfterLogin : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentWardenAfterLoginBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_warden_after_login,
            container,
            false
        )

        //setting on click listenenrs
        binding.studentDetailsButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_wardenAfterLogin_to_wardenAllStudentDetials)
        }
        binding.updateHostelNoticeButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_wardenAfterLogin_to_wardenUpdateNotice)
        }
        binding.checkAdminNoticeButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_wardenAfterLogin_to_checkAdminNotice)
        }
        //back pressed callback
        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_wardenAfterLogin_to_titleFragment2)
                }
            })
        return binding.root
    }

}