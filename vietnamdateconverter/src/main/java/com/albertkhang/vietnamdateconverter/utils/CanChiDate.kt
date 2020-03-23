package com.albertkhang.vietnamdateconverter.utils

class CanChiDate {
    private var _canChiDay: String = "Tân Hợi"
    var canChiDay: String = _canChiDay
        get() {
            return _canChiDay
        }
        private set

    private var _canChiMonth: String = "Bính Thân"
    var canChiMonth: String = _canChiMonth
        get() {
            return _canChiMonth
        }
        private set

    private var _canChiYear: String = "Kỷ Mão"
    var canChiYear: String = _canChiYear
        get() {
            return _canChiYear
        }
        private set

    internal constructor(day: String, month: String, year: String) {
        _canChiDay = day
        _canChiMonth = month
        _canChiYear = year
    }

    override fun toString(): String {
        return "LunarDate[day=$canChiDay, month=$canChiMonth, year=$canChiYear]"
    }
}