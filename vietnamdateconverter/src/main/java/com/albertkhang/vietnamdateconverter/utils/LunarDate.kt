package com.albertkhang.vietnamdateconverter.utils

class LunarDate {
    private var _day: Int = 13
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

    private var _month: Int = 1
    var month: Int
        get() {
            return _month
        }
        set(value) {
            if (value > 0) {
                _month = value
            } else {
                println("Tháng phải từ một trở lên")
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

    private var _leap: Int = 0
    internal var leap: Int
        get() {
            return _leap
        }
        set(value) {
            _leap = value
        }

    constructor(day: Int, month: Int, year: Int) {
        _day = day
        _month = month
        _year = year
    }

    internal constructor(day: Int, month: Int, year: Int, leap: Int, jd: Int) {
        _day = day
        _month = month
        _year = year
        _leap = leap
        _jd = jd
    }

    override fun toString(): String {
        return "LunarDate[day=$_day, month=$_month, year=$_year, _jd: $_jd, _leap: $_leap]"
    }
}