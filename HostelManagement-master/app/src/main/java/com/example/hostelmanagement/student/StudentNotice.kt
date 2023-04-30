package com.example.hostelmanagement.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hostelmanagement.Adapters.NoticeAdapterWithDelete
import com.example.hostelmanagement.Adapters.NoticeDeleteAdapterClick
import com.example.hostelmanagement.R
import com.example.hostelmanagement.database.StudentNotice
import com.example.hostelmanagement.databinding.FragmentStudentNoticeBinding

class StudentNotice : Fragment(), NoticeDeleteAdapterClick {
    lateinit var binding: FragmentStudentNoticeBinding
    lateinit var viewModel: StudentViewModel
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_student_notice, container, false)
        val application = requireNotNull(activity).application
        viewModel = StudentViewModel(application)


        //setting the layoutmanager
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
//        val adapter = NoticeAdapter()
        val adapter = NoticeAdapterWithDelete(requireContext(), this)
        binding.recyclerView.adapter = adapter
        viewModel.allNotice.observe(viewLifecycleOwner, { list ->
            list?.let {
                adapter.submitList(it)
            }
        })


        return binding.root
    }

    override fun ondelteClick(notice: StudentNotice) {
        Toast.makeText(context, "Only Warden Can Delete Notice!!!", Toast.LENGTH_SHORT).show()
    }

}