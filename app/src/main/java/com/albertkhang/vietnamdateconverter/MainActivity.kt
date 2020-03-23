package com.albertkhang.vietnamdateconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.albertkhang.vietnamdateconverter.utils.LunarDate
import com.albertkhang.vietnamdateconverter.utils.SolarDate

class MainActivity : AppCompatActivity() {
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
//            testGetLunarDate()
//            testGetSolarDate()
//            testGetCanChiDate()
            testGetWeekdays()
        }
        btnConvert.callOnClick()
    }

    private fun testGetWeekdays() {
        val GET_WEEKDAYS_LOG = "testGetWeekdaysLog"

        val solarDate = SolarDate()
        Log.d(GET_WEEKDAYS_LOG, solarDate.toString())

        val lunarDate = vietnamDateConverter.getLunarDate(solarDate)
        Log.d(GET_WEEKDAYS_LOG, lunarDate.toString())

        val wd1 = vietnamDateConverter.getWeekdays()
        Log.d(GET_WEEKDAYS_LOG, "wd1: $wd1")

        val wd2 = vietnamDateConverter.getWeekdays(solarDate)
        Log.d(GET_WEEKDAYS_LOG, "wd2: $wd2")

        val wd3 = vietnamDateConverter.getWeekdays(lunarDate)
        Log.d(GET_WEEKDAYS_LOG, "wd3: $wd3")

        val wd4 = vietnamDateConverter.getWeekdays(23, 3, 2020)
        Log.d(GET_WEEKDAYS_LOG, "wd4: $wd4")
    }

    private fun testGetCanChiDate() {
        val GET_CANCHI_LOG = "testGetCanChiDateLog"

        val solarDate = SolarDate()
        Log.d(GET_CANCHI_LOG, solarDate.toString())

        val lunarDate = vietnamDateConverter.getLunarDate(solarDate)
        Log.d(GET_CANCHI_LOG, lunarDate.toString())

        val cd1 = vietnamDateConverter.getCanChiDate()
        Log.d(GET_CANCHI_LOG, "cd1: $cd1")

        val cd2 = vietnamDateConverter.getCanChiDate(lunarDate)
        Log.d(GET_CANCHI_LOG, "cd2: $cd2")

        val cd3 = vietnamDateConverter.getCanChiDate(solarDate)
        Log.d(GET_CANCHI_LOG, "cd3: $cd3")

        val cd4 = vietnamDateConverter.getCanChiDate(solarDate.day, solarDate.month, solarDate.year)
        Log.d(GET_CANCHI_LOG, "cd4: $cd4")
    }

    private fun testGetSolarDate() {
        val GET_SOLAR_LOG = "testGetSolarDateLog"

        val lunarDate = LunarDate(30, 2, 2020)
        Log.d(GET_SOLAR_LOG, lunarDate.toString())

        val sd1 = vietnamDateConverter.getSolarDate(lunarDate)
        Log.d(GET_SOLAR_LOG, "sd1: $sd1")

        val sd2 = vietnamDateConverter.getSolarDate(30, 2, 2020)
        Log.d(GET_SOLAR_LOG, "sd2: $sd2")
    }

    private fun testGetLunarDate() {
        val GET_LUNAR_LOG = "testGetLunarDateLog"

        val solarDate = SolarDate()
        Log.d(GET_LUNAR_LOG, solarDate.toString())

        val ld1 = vietnamDateConverter.getLunarDate()
        Log.d(GET_LUNAR_LOG, "ld1: $ld1")

        val ld2 = vietnamDateConverter.getLunarDate(solarDate)
        Log.d(GET_LUNAR_LOG, "ld2: $ld2")

        val ld3 = vietnamDateConverter.getLunarDate(23, 3, 2020)
        Log.d(GET_LUNAR_LOG, "ld3: $ld3")
    }
}
