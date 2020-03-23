package com.albertkhang.vietnamdateconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.albertkhang.vietnamdateconverter.utils.SolarDate

class MainActivity : AppCompatActivity() {
    private val GET_LUNAR_LOG = "getLunarDateLog"
    private lateinit var btnConvert: Button
    private lateinit var vietnamDateConverter: VietnamDateConverter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addControl()
        addEvent()
    }

    private fun addControl() {
        btnConvert = findViewById(R.id.btnConvert)
        vietnamDateConverter = VietnamDateConverter().getInstance()
    }

    private fun addEvent() {
        btnConvert.setOnClickListener {
            val solarDate = SolarDate()
            Log.d(GET_LUNAR_LOG, solarDate.toString())

            val ld1 = vietnamDateConverter.getLunarDate()
            Log.d(GET_LUNAR_LOG, "getLunarDate(): $ld1")

            val ld2 = vietnamDateConverter.getLunarDate(solarDate)
            Log.d(GET_LUNAR_LOG, "getLunarDate(solarDate): $ld2")

            val ld3 = vietnamDateConverter.getLunarDate(23, 3, 2020)
            Log.d(GET_LUNAR_LOG, "getLunarDate(day, month, year): $ld3")
        }
    }
}
