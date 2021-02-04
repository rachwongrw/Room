package com.example.room.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "value_table")

data class Value (@PrimaryKey @ColumnInfo(name = "value") val value: String)

data class SimpleDataClass(val simpleProperty: String)