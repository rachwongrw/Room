package com.example.room

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class AddValueActivity : AppCompatActivity() {
    private lateinit var editValueView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_value)

        editValueView = findViewById(R.id.edit_value)

        val button = findViewById<Button>(R.id.button_save)

        button.setOnClickListener {
            val replyIntent = Intent()

            if(TextUtils.isEmpty(editValueView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                replyIntent.putExtra(EXTRA_REPLY, editValueView.text.toString())
                setResult(Activity.RESULT_OK, replyIntent)
            }
        }
    }


    companion object {
        const val EXTRA_REPLY = "EXTRA_REPLY"
    }

}

