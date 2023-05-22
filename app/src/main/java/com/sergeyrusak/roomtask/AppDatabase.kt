package com.sergeyrusak.roomtask

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ResultEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun resultsDao(): ResultsDao
}