package com.example.hostelmanagement.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hostelmanagement.database.Student
import com.example.hostelmanagement.databinding.FragmentPersonalDetailsBinding

class AllStudentsAdapter :
    ListAdapter<Student, AllStudentsAdapter.AllStudentViewHolder>(diffCallback) {
    class AllStudentViewHolder(private val binding: FragmentPersonalDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
            binding.mobilenoTetview.text = student.mobile_no.toString()
            binding.fullnametextview.text = student.name
            binding.emailTextView.text = student.e_mail
            binding.USNtextview.text = student.USN
            binding.profilePhoto.setImageBitmap(student.image)
            binding.RoomnoTextView.text = student.room_no.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllStudentViewHolder {
        return AllStudentViewHolder(
            FragmentPersonalDetailsBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )

    }

    override fun onBindViewHolder(holder: AllStudentViewHolder, position: Int) {
        val currentStudent = getItem(position)
        holder.bind(currentStudent)
    }

    companion object diffCallback : DiffUtil.ItemCallback<Student>() {
        override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem.USN == newItem.USN
        }

    }
}