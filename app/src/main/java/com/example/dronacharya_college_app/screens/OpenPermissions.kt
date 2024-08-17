package com.example.dronacharya_college_app.screens

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dronacharya_college_app.R

class OpenPermissions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_open_permissions)

        val permissions  = arrayOf("android.permission.READ_EXTERNAL_STORAGE","android.permission.CALL_PHONE")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val button = findViewById<Button>(R.id.button)

            button.setOnClickListener {
                requestPermissions(permissions,1)
            }
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    @Override
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == 1){
            Toast.makeText(this,"Download File",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Download Cancel",Toast.LENGTH_SHORT).show()

        }
    }
}