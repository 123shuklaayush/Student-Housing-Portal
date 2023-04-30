package com.example.hostelmanagement.Parents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.hostelmanagement.R
import com.example.hostelmanagement.database.Student
import com.example.hostelmanagement.databinding.FragmentParentsInformationBinding


class ParentsInformation : Fragment() {

    lateinit var viewModel: parentsViewModel
    lateinit var binding: FragmentParentsInformationBinding
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.fragment_parents_information,
                container,
                false
        )

        //setting on click listeners
        binding.searchButton.setOnClickListener {
            if (loginSuccessful()) {
                val singleStudent = viewModel.singleStudent as Student
                it.findNavController().navigate(ParentsInformationDirections.actionParentsInformationToPersonalDetails(singleStudent))
            }
        }
        viewModel = parentsViewModel(requireActivity().application)
        return binding.root
    }

    private fun loginSuccessful(): Boolean {
        if (binding.pareentsStudentUsnEditText.text.toString() == "") {
            Toast.makeText(context, "Empty USN Field", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.parentsSudentNameEditText.text.toString() == "") {
            Toast.makeText(context, "Empty NAME Field", Toast.LENGTH_SHORT).show()
            return false
        } else {

            viewModel.verifyLogin(binding.parentsSudentNameEditText.text.toString(), binding.pareentsStudentUsnEditText.text.toString())
            if (viewModel.singleStudent?.USN == binding.pareentsStudentUsnEditText.text.trim().toString() && viewModel.singleStudent?.name == binding.parentsSudentNameEditText.text.trim().toString()) {
                Toast.makeText(context, "Welcome ${viewModel.singleStudent!!.name}'s Parent", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return false
    }
}

