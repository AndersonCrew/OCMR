package com.example.ocmr

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ocmr.utils.Constants

@Database(entities = [], version = Constants.DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

}