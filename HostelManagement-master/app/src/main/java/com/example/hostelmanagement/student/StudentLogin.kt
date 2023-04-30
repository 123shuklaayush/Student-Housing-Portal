package com.example.hostelmanagement.student

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
import com.example.hostelmanagement.databinding.FragmentStudentLoginBinding

class StudentLogin : Fragment() {
    lateinit var viewModel: StudentViewModel
    lateinit var binding: FragmentStudentLoginBinding
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.fragment_student_login,
                container,
                false
        )
        //set on click listener
        binding.loginButton.setOnClickListener {
            if (loginSuccessful()) {
                val singleStudent = viewModel.singleStudent as Student
                it.findNavController().navigate(
                        StudentLoginDirections.actionStudentLoginToAfterLogin(singleStudent)
                )
            }
        }
        val application = requireNotNull(activity).application
        viewModel = StudentViewModel(application)
        return binding.root
    }

    private fun loginSuccessful(): Boolean {
        if (binding.usnEditext.text.toString() == "") {
            Toast.makeText(context, "Empty USN Field", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.nameEditext.text.toString() == "") {
            Toast.makeText(context, "Empty NAME Field", Toast.LENGTH_SHORT).show()
            return false
        } else {

            viewModel.verifyLogin(binding.nameEditext.text.toString(), binding.usnEditext.text.toString())
            if (viewModel.singleStudent?.USN == binding.usnEditext.text.trim().toString() && viewModel.singleStudent?.name == binding.nameEditext.text.trim().toString()) {
                Toast.makeText(context, "Welcome ${viewModel.singleStudent!!.name}", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return false
    }


}




