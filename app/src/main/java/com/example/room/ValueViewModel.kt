package com.example.room

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.room.database.Value
import com.example.room.database.ValueDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ValueViewModel(val db: ValueDao) : ViewModel(), LifecycleObserver {
    val values = MutableLiveData<List<Value>>()

    fun getAllValues() = GlobalScope.launch(Dispatchers.Main) {
        val dbValues = db.getAllValues()
        if (dbValues != null) {
            values.value = dbValues
        }
    }

    fun insert(value: Value) = GlobalScope.launch(Dispatchers.Main) {
        db.insert(value)
    }
}