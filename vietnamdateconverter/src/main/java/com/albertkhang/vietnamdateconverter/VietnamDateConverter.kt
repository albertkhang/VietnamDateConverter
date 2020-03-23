package com.albertkhang.vietnamdateconverter

class VietnamDateConverter {
    private lateinit var _instance: VietnamDateConverter

    fun getInstance(): VietnamDateConverter {
        if (_instance == null) {
            synchronized(VietnamDateConverter::class) {
                if (_instance == null) {
                    _instance = VietnamDateConverter()
                }
            }
        }

        return _instance
    }
}