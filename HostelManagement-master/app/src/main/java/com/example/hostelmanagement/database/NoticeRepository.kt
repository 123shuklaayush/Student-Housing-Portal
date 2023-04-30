package com.example.hostelmanagement.database

import androidx.lifecycle.LiveData

class NoticeRepository(private val noticeDao: NoticeDao) {

    fun getAllNotice(): LiveData<List<StudentNotice>> {
        return noticeDao.getAllNotice()
    }

    suspend fun insertNotice(notice: StudentNotice) {
        noticeDao.insertNotice(notice)
    }

    suspend fun delteNotice(notice: StudentNotice) {
        noticeDao.deleteNotice(notice)
    }
}