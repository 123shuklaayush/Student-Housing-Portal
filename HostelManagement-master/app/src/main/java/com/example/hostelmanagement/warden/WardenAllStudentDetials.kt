package com.example.hostelmanagement.warden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hostelmanagement.Adapters.AllStudentsAdapter
import com.example.hostelmanagement.R
import com.example.hostelmanagement.databinding.FragmentWardenAllStudentDetialsBinding


class WardenAllStudentDetials : Fragment() {

    lateinit var binding: FragmentWardenAllStudentDetialsBinding
    lateinit var viewModel: WardenViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_warden_all_student_detials,
            container,
            false
        )
        viewModel = WardenViewModel(requireNotNull(activity).application)
        val adapter = AllStudentsAdapter()
        binding.allstudentRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.allstudentRecyclerView.adapter = adapter


        viewModel.allstudents.observe(viewLifecycleOwner, { list ->
            list.let {
                adapter.submitList(it)
            }
        })
        return binding.root
    }

}