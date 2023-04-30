package com.example.hostelmanagement.database

import android.graphics.Bitmap
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity
data class Student(
        val name: String,
        @PrimaryKey val USN: String,
        val room_no: Int,
        val home_address: String,
        val e_mail: String,
        val mobile_no: Long,
        var attendence: Int,
        var image: Bitmap
) : Parcelable

@Entity
data class StudentNotice(
        val notice: Bitmap,
        @PrimaryKey(autoGenerate = true) var _id: Int = 0
)

