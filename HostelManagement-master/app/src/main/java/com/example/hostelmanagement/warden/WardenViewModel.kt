package com.example.hostelmanagement.warden

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.hostelmanagement.database.*
import kotlinx.coroutines.launch

class WardenViewModel(application: Application) : AndroidViewModel(application) {
    private val studentRepository: StudentRepository
    private val noticeRepository: NoticeRepository
    var allstudents: LiveData<List<Student>>
    var allNotice: LiveData<List<StudentNotice>>

    init {
        val studentDao = HostelDatabase.getDatabase(application).getStudentDao()
        studentRepository = StudentRepository(studentDao)
        val noticeDao = HostelDatabase.getDatabase(application).getNoticeDao()
        noticeRepository = NoticeRepository(noticeDao)
        allstudents = studentRepository.getStudentDetails()
        allNotice = noticeRepository.getAllNotice()
    }

    fun insertNotice(notice: StudentNotice) {
        viewModelScope.launch {
            noticeRepository.insertNotice(notice)
        }
    }

    fun deleteNotice(notice: StudentNotice) {
        viewModelScope.launch {
            noticeRepository.delteNotice(notice)
        }
    }
}