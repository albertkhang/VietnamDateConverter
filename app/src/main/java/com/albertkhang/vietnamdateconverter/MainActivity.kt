package com.albertkhang.vietnamdateconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.albertkhang.vietnamdateconverter.utils.LunarDate
import com.albertkhang.vietnamdateconverter.utils.SolarDate
import java.util.*

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
//            testGetWeekdays()
//            testGetCanChiHour()
            testGetSolarTerm()
        }
        btnConvert.callOnClick()
    }

    private fun testGetSolarTerm() {
        val GET_SOLARTERM_LOG = "testGetSolarTermLog"

        val solarDate = SolarDate()
        Log.d(GET_SOLARTERM_LOG, solarDate.toString())

        val lunarDate = vietnamDateConverter.getLunarDate(solarDate)
        Log.d(GET_SOLARTERM_LOG, lunarDate.toString())

        val st1 = vietnamDateConverter.getSolarTerm()
        Log.d(GET_SOLARTERM_LOG, "st1: $st1")

        val st2 = vietnamDateConverter.getSolarTerm(solarDate)
        Log.d(GET_SOLARTERM_LOG, "st2: $st2")

        val st3 = vietnamDateConverter.getSolarTerm(lunarDate)
        Log.d(GET_SOLARTERM_LOG, "st3: $st3")

        val st4 = vietnamDateConverter.getSolarTerm(23, 3, 2020)
        Log.d(GET_SOLARTERM_LOG, "st4: $st4")
    }

    private fun testGetCanChiHour() {
        val GET_CANCHIHOUR_LOG = "testGetCanChiHourLog"

        val solarDate = SolarDate()
        Log.d(GET_CANCHIHOUR_LOG, solarDate.toString())

        val lunarDate = vietnamDateConverter.getLunarDate(solarDate)
        Log.d(GET_CANCHIHOUR_LOG, lunarDate.toString())

        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        //TODO: using HOUR_OF_DAY not HOUR
        Log.d(GET_CANCHIHOUR_LOG, hour.toString())

        val minute = Calendar.getInstance().get(Calendar.MINUTE)
        Log.d(GET_CANCHIHOUR_LOG, minute.toString())

        val cch1 = vietnamDateConverter.getCanChiHour()
        Log.d(GET_CANCHIHOUR_LOG, "cch1: $cch1")

        val cch2 = vietnamDateConverter.getCanChiHour(hour, minute)
        Log.d(GET_CANCHIHOUR_LOG, "cch2: $cch2")

        val cch3 = vietnamDateConverter.getCanChiHour(hour, minute, solarDate)
        Log.d(GET_CANCHIHOUR_LOG, "cch3: $cch3")

        val cch4 = vietnamDateConverter.getCanChiHour(hour, minute, lunarDate)
        Log.d(GET_CANCHIHOUR_LOG, "cch4: $cch4")

        val cch5 = vietnamDateConverter.getCanChiHour(hour, minute, 23, 3, 2020)
        Log.d(GET_CANCHIHOUR_LOG, "cch5: $cch5")
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
