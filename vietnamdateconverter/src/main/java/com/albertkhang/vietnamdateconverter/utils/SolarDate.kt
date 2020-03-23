package com.albertkhang.vietnamdateconverter.utils

import java.util.*

class SolarDate {
    private var _day: Int = 28
    var day: Int
        get() {
            return _day
        }
        set(value) {
            if (value > 0) {
                _day = value
            } else {
                println("Ngày phải từ 1 trở lên")
                throw IllegalArgumentException()
            }
        }

    private var _month: Int = 2
    var month: Int
        get() {
            return _month
        }
        set(value) {
            if (value > 0) {
                _month = value
            } else {
                println("Tháng phải từ 1 trở lên")
                throw IllegalArgumentException()
            }
        }

    private var _year: Int = 1999
    var year: Int
        get() {
            return _year
        }
        set(value) {
            if (value > 0) {
                _year = value
            } else {
                println("Năm phải từ 1800 trở lên")
                throw IllegalArgumentException()
            }
        }

    private var _jd: Int = 0
    internal var jd: Int
        get() {
            return _jd
        }
        set(value) {
            _jd = value
        }

    init {
        day = 28
        month = 2
        year = 1999
        jd = 0
    }

    constructor() {
        _day = Calendar.getInstance().get(Calendar.DATE)
        _month = Calendar.getInstance().get(Calendar.MONTH) + 1
        _year = Calendar.getInstance().get(Calendar.YEAR)
    }

    constructor(day: Int, month: Int, year: Int) {
        _day = day
        _month = month
        _year = year
    }

    internal constructor(day: Int, month: Int, year: Int, jd: Int) {
        _day = day
        _month = month
        _year = year
        _jd = jd
    }

    override fun toString(): String {
        return "SolarDate[day=$day, month=$month, year=$year]"
    }
}