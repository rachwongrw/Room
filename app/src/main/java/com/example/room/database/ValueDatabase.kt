package com.example.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Value::class], version = 1, exportSchema = false)
abstract class ValueDatabase: RoomDatabase() {
    abstract val valueDao: ValueDao
    companion object {
        @Volatile
        private var INSTANCE: ValueDatabase? = null

        fun getDatabase(context: Context) : ValueDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ValueDatabase::class.java,
                        "value_database"
                )
                        .build()
                INSTANCE = instance
                instance
            }
        }
    }
}