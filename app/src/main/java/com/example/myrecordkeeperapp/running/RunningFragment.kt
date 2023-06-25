package com.example.myrecordkeeperapp.running

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myrecordkeeperapp.databinding.FragmentRunningBinding

class RunningFragment : Fragment() {
    private lateinit var binding: FragmentRunningBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRunningBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()



    }

    override fun onResume() {

        super.onResume()
        displayRecords()
    }

    private fun displayRecords() {
        val runningPrefrences = requireContext().getSharedPreferences("RunningPreference", Context.MODE_PRIVATE)

        binding.valueId5km.text= runningPrefrences.getString("5km record", "No record set")
        binding.dateId5km.text=runningPrefrences.getString("5km date", "No date set")

        binding.valueId10km.text= runningPrefrences.getString("10km record", "No record set")
        binding.dateId10km.text=runningPrefrences.getString("10km date", "No date set")

        binding.valueIdHalfMarathon.text= runningPrefrences.getString("Half-Marathon record", "No record set")
        binding.dateIdHalfMarathon.text=runningPrefrences.getString("Half-Marathon date", "No date set")

        binding.valueIdMarathon.text= runningPrefrences.getString("Full-Marathon record", "No record set")
        binding.dateIdMarathonId.text=runningPrefrences.getString("Full-Marathon date", "No date set")

    }

    private fun setupClickListeners() {
        binding.constarintId5km.setOnClickListener {
            launchRunningRecordScreen("5km")
        }
        binding.constraintId10km.setOnClickListener {
            launchRunningRecordScreen("10km")
        }
        binding.constraintIdHalfMarathon.setOnClickListener {
            launchRunningRecordScreen("Half-Marathon")
        }
        binding.constraintIdMarathon.setOnClickListener {
            launchRunningRecordScreen("Full-Marathon")
        }
    }

    private fun launchRunningRecordScreen(distance: String) {
        val intent = Intent(context, EditRunningRecordsActvity::class.java)
        intent.putExtra("Distance", distance)
        startActivity(intent)
    }

}
