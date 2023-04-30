package com.example.hostelmanagement.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Student::class, StudentNotice::class], version = 1, exportSchema = false)
@TypeConverters(Convertors::class)
abstract class HostelDatabase : RoomDatabase() {

    abstract fun getStudentDao(): StudentDao
    abstract fun getNoticeDao(): NoticeDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: HostelDatabase? = null

        fun getDatabase(context: Context): HostelDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HostelDatabase::class.java,
                    "hostel_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}