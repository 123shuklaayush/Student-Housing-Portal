package com.example.hostelmanagement.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.hostelmanagement.R
import com.example.hostelmanagement.database.Student
import com.example.hostelmanagement.databinding.FragmentAttendenceBinding

class Attendence : Fragment() {
    lateinit var student: Student
    lateinit var binding: FragmentAttendenceBinding
    lateinit var viewModel: StudentViewModel
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_attendence, container, false)
        //On Click Listeners
        binding.submitAttendenceButton.setOnClickListener {
            onSubmitAttendence()
        }
        binding.returnToHomeButton.setOnClickListener {
            returnToHome()
        }
        student = AttendenceArgs.fromBundle(requireArguments()).singleStudent
        //to displaya attendece in textbox
        displayAttendence()
        val applicationn = requireNotNull(activity).application
        viewModel = StudentViewModel(applicationn)
        return binding.root

    }

    private fun displayAttendence() {
        binding.AttendenceTextView.text = student.attendence.toString()
    }

    private fun returnToHome() {
        binding.attendanceMarkedSuccessfulllyTextview.visibility = View.GONE
        binding.returnToHomeButton.visibility = View.GONE
        binding.attendenceSuccessfulImageview.visibility = View.GONE
        binding.TotalAttendenceMarkedTextview.visibility = View.VISIBLE
        binding.attendenceTextbox.visibility = View.VISIBLE
        binding.submitAttendenceButton.visibility = View.VISIBLE
        binding.AttendenceTextView.visibility = View.VISIBLE
        displayAttendence()
    }

    private fun onSubmitAttendence() {
        if (binding.attendenceTextbox.isChecked) {
            binding.attendanceMarkedSuccessfulllyTextview.visibility = View.VISIBLE
            binding.returnToHomeButton.visibility = View.VISIBLE
            binding.attendenceSuccessfulImageview.visibility = View.VISIBLE
            binding.TotalAttendenceMarkedTextview.visibility = View.GONE
            binding.attendenceTextbox.visibility = View.GONE
            binding.submitAttendenceButton.visibility = View.GONE
            binding.AttendenceTextView.visibility = View.GONE

            //incrementing attendence
            incrementingAttendenct(student)

        } else Toast.makeText(context, "Check Box not checked", Toast.LENGTH_SHORT).show()

    }

    private fun incrementingAttendenct(student: Student) {
        student.attendence += 1
        viewModel.updateAttendence(student)
    }


}