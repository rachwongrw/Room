package com.example.room

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener{
            val intent = Intent(this@MainActivity, AddValueActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(AddValueActivity.EXTRA_REPLY)?.let { reply ->
                // add to db
                val value = reply
                // get from db
            }
        } else {
            Toast.makeText(applicationContext, "Must provide valid value", Toast.LENGTH_LONG).show()
        }
    }
}