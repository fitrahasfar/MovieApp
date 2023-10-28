package com.fitrah.mysubmission

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val home: ImageView = findViewById(R.id.back_profile)
        home.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.back_profile) {
            val intent = Intent(this@ProfileActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}