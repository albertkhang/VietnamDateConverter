package com.albertkhang.vietnamdateconverter.utils

class ZodiacHour {
    private var _startHour: Int = 13
    var startHour: Int = _startHour
        get() {
            return _startHour
        }
        private set

    private var _endHour: Int = 13
    var endHour: Int = _endHour
        get() {
            return _endHour
        }
        private set

    private var _canChiHour: String = "Ngọ"
    var canChiHour: String = _canChiHour
        get() {
            return _canChiHour
        }
        private set

    internal constructor(startHour: Int, endHour: Int, canChiHour: String) {
        _startHour = startHour
        _endHour = endHour
        _canChiHour = canChiHour
    }

    override fun toString(): String {
        return "ZodiacHour[startHour: $_startHour, endHour: $_endHour, canChiHour: $_canChiHour]"
    }
}