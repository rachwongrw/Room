package com.example.room

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.room.database.Value
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val valueViewModel: ValueViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, AddValueActivity::class.java)
            startActivityForResult(intent, 1)
        }

        valueViewModel.getAllValues()
        valueViewModel.values.observe(this, Observer {  values ->
            values ?: return@Observer
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(AddValueActivity.EXTRA_REPLY)?.let { reply ->
                // add to db
                val value = Value(reply)
                valueViewModel.insert(value)
                // get from db
//                valueViewModel.getAllValues()
                // show user the value we just added to db in a toast
                Toast.makeText(applicationContext, "Added value", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(applicationContext, "Must provide valid value", Toast.LENGTH_LONG).show()
        }
    }
}