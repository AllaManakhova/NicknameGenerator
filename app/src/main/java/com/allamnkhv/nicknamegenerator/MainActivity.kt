package com.allamnkhv.nicknamegenerator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.main_toolbar))
    }

    fun startGenerating(view: View) {
        val addRecordsIntent = Intent(this, Generator::class.java)
        startActivity(addRecordsIntent)
    }
}
