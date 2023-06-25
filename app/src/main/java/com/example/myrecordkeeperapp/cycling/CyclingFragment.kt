package com.example.myrecordkeeperapp.cycling

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myrecordkeeperapp.databinding.FragmentCyclingBinding

class CyclingFragment : Fragment() {
    private lateinit var binding: FragmentCyclingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCyclingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setonclicklistners()
    }

    override fun onResume() {
        super.onResume()
        diplayrecords()
    }

    private fun diplayrecords() {
        val cyclingPrefrences = requireContext().getSharedPreferences("cyclingPreferences", Context.MODE_PRIVATE)

        binding.longestRideTxtViewValue.text = cyclingPrefrences.getString("Longest Ride record", "No Record Set")
        binding.longestRideDate.text = cyclingPrefrences.getString("Longest Ride date", "No date Set")

        binding.biggestClimbTxtViewValue.text = cyclingPrefrences.getString("Biggest Climb record", "No Record Set")
        binding.biggestClimbDate.text = cyclingPrefrences.getString("Biggest Climb date", "No date Set")

        binding.averageSpeedValue.text = cyclingPrefrences.getString(" Best Average Speed record", "No Record Set")
        binding.averageSpeedDate.text = cyclingPrefrences.getString(" Best Average Speed date", "No date Set")
    }

    private fun setonclicklistners() {
        binding.longestRideConstraintId.setOnClickListener {
            launchNewCyclingActivity("Longest Ride")
        }
        binding.biggestClimbConstraintId.setOnClickListener {
            launchNewCyclingActivity("Biggest Climb")
        }
        binding.averageSpeedConstraintId.setOnClickListener {
            launchNewCyclingActivity(" Best Average Speed")
        }

    }

    private fun launchNewCyclingActivity(cyclingtype: String) {
        val intent = Intent(context, EditCyclingRecordsActivity::class.java)
        intent.putExtra("cyclingtype",cyclingtype )
        startActivity(intent)
    }
}