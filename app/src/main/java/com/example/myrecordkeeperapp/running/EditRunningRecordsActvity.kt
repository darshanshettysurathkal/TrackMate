package com.example.myrecordkeeperapp.running

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import com.example.myrecordkeeperapp.databinding.ActivityEditRunningRecordsActvityBinding

class EditRunningRecordsActvity : AppCompatActivity() {
    private lateinit var binding: ActivityEditRunningRecordsActvityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRunningRecordsActvityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dist = intent.getStringExtra("Distance")
        title ="$dist Record "
        displayRecord(dist)

        binding.saveButtonId.setOnClickListener {
            saverecord(dist)
            finish()
        }

        binding.clearButtonId.setOnClickListener {
            deleterecord(dist)
            finish()
        }


    }

    private fun deleterecord(dist: String?) {
        val runningPreferences = getSharedPreferences("RunningPreference", MODE_PRIVATE)
        runningPreferences.edit {
            remove("$dist record")
            remove("$dist date")
        }
    }

    private fun displayRecord(dist: String?) {
        val runningPreferences = getSharedPreferences("RunningPreference", MODE_PRIVATE)
        binding.recordInputId.setText(runningPreferences.getString("$dist record", "No Record Found"))
        binding.dateTextId.setText(runningPreferences.getString("$dist date", "No date Found"))
    }

    private fun saverecord(dist: String?) {
        val record_best = binding.recordInputId.text.toString()
        val date = binding.dateTextId.text.toString()

        val runningPreferences = getSharedPreferences("RunningPreference", MODE_PRIVATE)
        runningPreferences.edit {
            putString("$dist record", record_best)
            putString("$dist date", date)
        }
    }
}