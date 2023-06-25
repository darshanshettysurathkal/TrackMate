package com.example.myrecordkeeperapp

import com.example.myrecordkeeperapp.running.RunningFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.commit
import com.example.myrecordkeeperapp.cycling.CyclingFragment
import com.example.myrecordkeeperapp.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportFragmentManager.commit {
            add(R.id.frame_id, RunningFragment())
        }
        binding.bottomnavbarid.setOnItemSelectedListener(this)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.reset_running_id -> {
//
//            }
//
//            R.id.reset_cycling_id -> {
//
//            }
//
//            R.id.reset_all_id -> {
//
//            }
//
//
//        }
//
//        return super.onOptionsItemSelected(item)
//    }

    private fun cyclingclicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_id, CyclingFragment())
        }
    }

    private fun runningclicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_id, RunningFragment())
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.bottomnav_running_id -> {
                runningclicked()
                true

            }

            R.id.bottomnav_cycling_id -> {
                cyclingclicked()
                true

            }

            else -> {
                false

            }
        }

    }


}