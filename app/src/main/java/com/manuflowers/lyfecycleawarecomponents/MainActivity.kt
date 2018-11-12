package com.manuflowers.lyfecycleawarecomponents

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //The ViewModelStore provides a new ViewModel or one previously created:
        var chronometerViewModel : ChronometerViewModel = ViewModelProviders.of(this).get(ChronometerViewModel::class.java)

        //get the chronometer reference:
        val chronometer = findViewById<TextView>(R.id.chronometer) as Chronometer

        if(chronometerViewModel.startTime == null) {
            // if start date is not defined, it's a new viewModel so set it:
           var startTime : Long = SystemClock.elapsedRealtime()
            chronometerViewModel.setStartTime(startTime)
            chronometer.base = startTime
        } else {
            // Otherwise the viewModel has been retained, set the chronometer's base to the original startingTime
            chronometer.base = chronometerViewModel.startTime!!
        }

        chronometer.start()
    }
}
