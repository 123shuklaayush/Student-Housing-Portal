package com.example.hostelmanagement.student

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.hostelmanagement.database.*
import com.example.hostelmanagement.database.StudentNotice
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentViewModel(application: Application) : AndroidViewModel(application) {
    private val studentRepository: StudentRepository
    private val noticeRepository: NoticeRepository
    var allstudents: LiveData<List<Student>>
    var allNotice: LiveData<List<StudentNotice>>
    var singleStudent: Student? = null


    init {
        val studentDao = HostelDatabase.getDatabase(application).getStudentDao()
        studentRepository = StudentRepository(studentDao)
        val noticeDao = HostelDatabase.getDatabase(application).getNoticeDao()
        noticeRepository = NoticeRepository(noticeDao)
        allstudents = studentRepository.getStudentDetails()
        allNotice = noticeRepository.getAllNotice()
    }

    fun verifyLogin(name: String, usn: String) {
        viewModelScope.launch {
            val student = studentRepository.verifyLogin(name, usn)
            withContext(Dispatchers.Main) {
                singleStudent = student
            }
        }
    }


    fun updateAttendence(student: Student) {
        viewModelScope.launch {
            studentRepository.updateAttendence(student)
        }
    }


}