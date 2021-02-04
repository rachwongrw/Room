package com.example.room.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ValueDao {

    @Insert
    fun insert(value: Value)

    @Query("SELECT * FROM value_table ORDER BY value DESC LIMIT 1")
    fun getValue(): Value?
}