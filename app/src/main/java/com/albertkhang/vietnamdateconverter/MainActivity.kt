package com.albertkhang.vietnamdateconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.albertkhang.vietnamdateconverter.utils.CanChiDate
import com.albertkhang.vietnamdateconverter.utils.LunarDate
import com.albertkhang.vietnamdateconverter.utils.SolarDate
import com.albertkhang.vietnamdateconverter.utils.ZodiacHour

class MainActivity : AppCompatActivity() {
    private lateinit var vietnamDateConverter: VietnamDateConverter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vietnamDateConverter = VietnamDateConverter()


    }
}
