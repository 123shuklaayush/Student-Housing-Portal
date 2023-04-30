package com.example.hostelmanagement

import android.app.Application
import android.content.res.Resources
import android.graphics.BitmapFactory
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.hostelmanagement.database.HostelDatabase
import com.example.hostelmanagement.database.Student
import com.example.hostelmanagement.database.StudentRepository
import kotlinx.coroutines.launch

class TitleViewModel(application: Application, private val resources: Resources) : AndroidViewModel(application) {

    private val studentRepository: StudentRepository

    init {
        val studentDao = HostelDatabase.getDatabase(application).getStudentDao()
        studentRepository = StudentRepository(studentDao)
    }

    fun insert(student: Student) {
        viewModelScope.launch {
            studentRepository.insert(student)
        }
    }

    fun prepopulate() {
        val AYUSH = Student("Ankush Rai", "18BBTCS012", 726, "Seoni M.P.", "bt21ece017@iiitn.ac.in",
                9109547055, 65, BitmapFactory.decodeResource(resources, R.drawable.ankush))
        val ARYAN = Student("Aryan Maurya", "BT21ECE001", 819, "Kolkate W.B.", "bt21ece001@iiitn.ac.in",
                9425727070, 89, BitmapFactory.decodeResource(resources, R.drawable.aryan))
        val SACHIN = Student("Sachin Yadav", "BT21ECE032", 702, "Patna Bihar", "bt21ece032@iiitn.ac.in",
                9425898785, 78, BitmapFactory.decodeResource(resources, R.drawable.adarsh))
        val SAURABH = Student("Saurabh Kushwaha", "BT21ECE062", 756, "Bangalore Karnataka", "bt21ece062@iiitn.ac.in",
                9109569592, 55, BitmapFactory.decodeResource(resources, R.drawable.ayush))
        insert(AYUSH)
        insert(ARYAN)
        insert(SACHIN)
        insert(SAURABH)
    }

}