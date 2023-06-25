package com.example.myrecordkeeperapp.cycling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import com.example.myrecordkeeperapp.databinding.ActivityEditCyclingRecordsBinding

class EditCyclingRecordsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditCyclingRecordsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditCyclingRecordsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dist = intent.getStringExtra("cyclingtype")
        title ="$dist Record "

        binding.saveButtonId.setOnClickListener {
            saverecord(dist)
            finish()
        }

        binding.clearButtonId.setOnClickListener {
            deleterecord(dist)
            finish()
        }


        displayrecord(dist)

    }

    private fun deleterecord(dist: String?) {
        val cyclingprefrences = getSharedPreferences("cyclingPreferences", MODE_PRIVATE)
        cyclingprefrences.edit {
            remove("$dist record")
            remove("$dist date")
        }
    }

    private fun saverecord(dist: String?) {

        val value = binding.recordInputId.text.toString()
        val date = binding.dateTextId.text.toString()

        val cyclingprefrences = getSharedPreferences("cyclingPreferences", MODE_PRIVATE)
        cyclingprefrences.edit {
            putString("$dist record", value)
            putString("$dist date", date)
        }
    }

    private fun displayrecord(dist: String?) {
        val cyclingprefrences = getSharedPreferences("cyclingPreferences", MODE_PRIVATE)
        binding.recordInputId.setText(cyclingprefrences.getString("$dist record", "NO RECORD SET"))
        binding.dateTextId.setText(cyclingprefrences.getString("$dist date", "NO date SET"))
    }
}