package com.example.hostelmanagement.Parents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.hostelmanagement.R
import com.example.hostelmanagement.databinding.FragmentParentsMainBinding

class ParentsMain : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentParentsMainBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_parents_main,
            container,
            false
        )

        //adding on click litenres
        binding.hostelNoticeButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_parentsMain_to_studentNotice)
        }
        binding.informationButtton.setOnClickListener {
            it.findNavController().navigate(R.id.action_parentsMain_to_parentsInformation)
        }

        return binding.root
    }

}