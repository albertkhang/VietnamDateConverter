package com.albertkhang.vietnamdateconverter

import com.albertkhang.vietnamdateconverter.utils.CanChiDate
import com.albertkhang.vietnamdateconverter.utils.LunarDate
import com.albertkhang.vietnamdateconverter.utils.SolarDate
import java.util.*
import kotlin.math.floor
import kotlin.math.sin

class VietnamDateConverter {
    private val TK19 = arrayOf(
        0x30baa3,
        0x56ab50,
        0x422ba0,
        0x2cab61,
        0x52a370,
        0x3c51e8,
        0x60d160,
        0x4ae4b0,
        0x376926,
        0x58daa0,
        0x445b50,
        0x3116d2,
        0x562ae0,
        0x3ea2e0,
        0x28e2d2,
        0x4ec950,
        0x38d556,
        0x5cb520,
        0x46b690,
        0x325da4,
        0x5855d0,
        0x4225d0,
        0x2ca5b3,
        0x52a2b0,
        0x3da8b7,
        0x60a950,
        0x4ab4a0,
        0x35b2a5,
        0x5aad50,
        0x4455b0,
        0x302b74,
        0x562570,
        0x4052f9,
        0x6452b0,
        0x4e6950,
        0x386d56,
        0x5e5aa0,
        0x46ab50,
        0x3256d4,
        0x584ae0,
        0x42a570,
        0x2d4553,
        0x50d2a0,
        0x3be8a7,
        0x60d550,
        0x4a5aa0,
        0x34ada5,
        0x5a95d0,
        0x464ae0,
        0x2eaab4,
        0x54a4d0,
        0x3ed2b8,
        0x64b290,
        0x4cb550,
        0x385757,
        0x5e2da0,
        0x4895d0,
        0x324d75,
        0x5849b0,
        0x42a4b0,
        0x2da4b3,
        0x506a90,
        0x3aad98,
        0x606b50,
        0x4c2b60,
        0x359365,
        0x5a9370,
        0x464970,
        0x306964,
        0x52e4a0,
        0x3cea6a,
        0x62da90,
        0x4e5ad0,
        0x392ad6,
        0x5e2ae0,
        0x4892e0,
        0x32cad5,
        0x56c950,
        0x40d4a0,
        0x2bd4a3,
        0x50b690,
        0x3a57a7,
        0x6055b0,
        0x4c25d0,
        0x3695b5,
        0x5a92b0,
        0x44a950,
        0x2ed954,
        0x54b4a0,
        0x3cb550,
        0x286b52,
        0x4e55b0,
        0x3a2776,
        0x5e2570,
        0x4852b0,
        0x32aaa5,
        0x56e950,
        0x406aa0,
        0x2abaa3,
        0x50ab50
    ) /* Years 1800-1899 */
    private val TK20 = arrayOf(
        0x3c4bd8,
        0x624ae0,
        0x4ca570,
        0x3854d5,
        0x5cd260,
        0x44d950,
        0x315554,
        0x5656a0,
        0x409ad0,
        0x2a55d2,
        0x504ae0,
        0x3aa5b6,
        0x60a4d0,
        0x48d250,
        0x33d255,
        0x58b540,
        0x42d6a0,
        0x2cada2,
        0x5295b0,
        0x3f4977,
        0x644970,
        0x4ca4b0,
        0x36b4b5,
        0x5c6a50,
        0x466d50,
        0x312b54,
        0x562b60,
        0x409570,
        0x2c52f2,
        0x504970,
        0x3a6566,
        0x5ed4a0,
        0x48ea50,
        0x336a95,
        0x585ad0,
        0x442b60,
        0x2f86e3,
        0x5292e0,
        0x3dc8d7,
        0x62c950,
        0x4cd4a0,
        0x35d8a6,
        0x5ab550,
        0x4656a0,
        0x31a5b4,
        0x5625d0,
        0x4092d0,
        0x2ad2b2,
        0x50a950,
        0x38b557,
        0x5e6ca0,
        0x48b550,
        0x355355,
        0x584da0,
        0x42a5b0,
        0x2f4573,
        0x5452b0,
        0x3ca9a8,
        0x60e950,
        0x4c6aa0,
        0x36aea6,
        0x5aab50,
        0x464b60,
        0x30aae4,
        0x56a570,
        0x405260,
        0x28f263,
        0x4ed940,
        0x38db47,
        0x5cd6a0,
        0x4896d0,
        0x344dd5,
        0x5a4ad0,
        0x42a4d0,
        0x2cd4b4,
        0x52b250,
        0x3cd558,
        0x60b540,
        0x4ab5a0,
        0x3755a6,
        0x5c95b0,
        0x4649b0,
        0x30a974,
        0x56a4b0,
        0x40aa50,
        0x29aa52,
        0x4e6d20,
        0x39ad47,
        0x5eab60,
        0x489370,
        0x344af5,
        0x5a4970,
        0x4464b0,
        0x2c74a3,
        0x50ea50,
        0x3d6a58,
        0x6256a0,
        0x4aaad0,
        0x3696d5,
        0x5c92e0
    ) /* Years 1900-1999 */
    private val TK21 = arrayOf(
        0x46c960,
        0x2ed954,
        0x54d4a0,
        0x3eda50,
        0x2a7552,
        0x4e56a0,
        0x38a7a7,
        0x5ea5d0,
        0x4a92b0,
        0x32aab5,
        0x58a950,
        0x42b4a0,
        0x2cbaa4,
        0x50ad50,
        0x3c55d9,
        0x624ba0,
        0x4ca5b0,
        0x375176,
        0x5c5270,
        0x466930,
        0x307934,
        0x546aa0,
        0x3ead50,
        0x2a5b52,
        0x504b60,
        0x38a6e6,
        0x5ea4e0,
        0x48d260,
        0x32ea65,
        0x56d520,
        0x40daa0,
        0x2d56a3,
        0x5256d0,
        0x3c4afb,
        0x6249d0,
        0x4ca4d0,
        0x37d0b6,
        0x5ab250,
        0x44b520,
        0x2edd25,
        0x54b5a0,
        0x3e55d0,
        0x2a55b2,
        0x5049b0,
        0x3aa577,
        0x5ea4b0,
        0x48aa50,
        0x33b255,
        0x586d20,
        0x40ad60,
        0x2d4b63,
        0x525370,
        0x3e49e8,
        0x60c970,
        0x4c54b0,
        0x3768a6,
        0x5ada50,
        0x445aa0,
        0x2fa6a4,
        0x54aad0,
        0x4052e0,
        0x28d2e3,
        0x4ec950,
        0x38d557,
        0x5ed4a0,
        0x46d950,
        0x325d55,
        0x5856a0,
        0x42a6d0,
        0x2c55d4,
        0x5252b0,
        0x3ca9b8,
        0x62a930,
        0x4ab490,
        0x34b6a6,
        0x5aad50,
        0x4655a0,
        0x2eab64,
        0x54a570,
        0x4052b0,
        0x2ab173,
        0x4e6930,
        0x386b37,
        0x5e6aa0,
        0x48ad50,
        0x332ad5,
        0x582b60,
        0x42a570,
        0x2e52e4,
        0x50d160,
        0x3ae958,
        0x60d520,
        0x4ada90,
        0x355aa6,
        0x5a56d0,
        0x462ae0,
        0x30a9d4,
        0x54a2d0,
        0x3ed150,
        0x28e952
    ) /* Years 2000-2099 */
    private val TK22 = arrayOf(
        0x4eb520,
        0x38d727,
        0x5eada0,
        0x4a55b0,
        0x362db5,
        0x5a45b0,
        0x44a2b0,
        0x2eb2b4,
        0x54a950,
        0x3cb559,
        0x626b20,
        0x4cad50,
        0x385766,
        0x5c5370,
        0x484570,
        0x326574,
        0x5852b0,
        0x406950,
        0x2a7953,
        0x505aa0,
        0x3baaa7,
        0x5ea6d0,
        0x4a4ae0,
        0x35a2e5,
        0x5aa550,
        0x42d2a0,
        0x2de2a4,
        0x52d550,
        0x3e5abb,
        0x6256a0,
        0x4c96d0,
        0x3949b6,
        0x5e4ab0,
        0x46a8d0,
        0x30d4b5,
        0x56b290,
        0x40b550,
        0x2a6d52,
        0x504da0,
        0x3b9567,
        0x609570,
        0x4a49b0,
        0x34a975,
        0x5a64b0,
        0x446a90,
        0x2cba94,
        0x526b50,
        0x3e2b60,
        0x28ab61,
        0x4c9570,
        0x384ae6,
        0x5cd160,
        0x46e4a0,
        0x2eed25,
        0x54da90,
        0x405b50,
        0x2c36d3,
        0x502ae0,
        0x3a93d7,
        0x6092d0,
        0x4ac950,
        0x32d556,
        0x58b4a0,
        0x42b690,
        0x2e5d94,
        0x5255b0,
        0x3e25fa,
        0x6425b0,
        0x4e92b0,
        0x36aab6,
        0x5c6950,
        0x4674a0,
        0x31b2a5,
        0x54ad50,
        0x4055a0,
        0x2aab73,
        0x522570,
        0x3a5377,
        0x6052b0,
        0x4a6950,
        0x346d56,
        0x585aa0,
        0x42ab50,
        0x2e56d4,
        0x544ae0,
        0x3ca570,
        0x2864d2,
        0x4cd260,
        0x36eaa6,
        0x5ad550,
        0x465aa0,
        0x30ada5,
        0x5695d0,
        0x404ad0,
        0x2aa9b3,
        0x50a4d0,
        0x3ad2b7,
        0x5eb250,
        0x48b540,
        0x33d556
    ) /* Years 2100-2199 */

    private val CAN =
        arrayOf("Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ", "Canh", "Tân", "Nhâm", "Quý")
    private val CHI =
        arrayOf("Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi")
    private val TUAN =
        arrayOf("Chủ nhật", "Thứ hai", "Thứ ba", "Thứ tư", "Thứ năm", "Thứ sáu", "Thứ bảy")
    private val GIO_HD = arrayOf(
        "110100101100",
        "001101001011",
        "110011010010",
        "101100110100",
        "001011001101",
        "010010110011"
    )
    private val TIETKHI = arrayOf(
        "Xuân phân",
        "Thanh minh",
        "Cốc vũ",
        "Lập hạ",
        "Tiểu mãn",
        "Mang chủng",
        "Hạ chí",
        "Tiểu thử",
        "Đại thử",
        "Lập thu",
        "Xử thử",
        "Bạch lộ",
        "Thu phân",
        "Hàn lộ",
        "Sương giáng",
        "Lập đông",
        "Tiểu tuyết",
        "Đại tuyết",
        "Đông chí",
        "Tiểu hàn",
        "Đại hàn",
        "Lập xuân",
        "Vũ Thủy",
        "Kinh trập"
    )

    private fun INT(n: Number): Double {
        return floor(n.toDouble())
    }

    private var _instance: VietnamDateConverter? = null

    fun getInstance(): VietnamDateConverter {
        if (_instance == null) {
            synchronized(VietnamDateConverter::class) {
                if (_instance == null) {
                    _instance = VietnamDateConverter()
                }
            }
        }

        return _instance!!
    }

    private val FIRST_DAY = jdn(25, 1, 1800)// Tết âm lịch 1800
    private val LAST_DAY = jdn(31, 12, 2199)

    //========== Ngày âm ==========//

    //Trả về ngày âm của ngày dương hiện tại.
    fun getLunarDate(): LunarDate {
        val currentDay = Calendar.getInstance().get(Calendar.DATE)
        val currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)

        if (currentYear < 1800 || 2199 < currentYear) {
            return LunarDate(0, 0, 0)
        }
        var ly = getYearInfo(currentYear)
        val jd = jdn(currentDay, currentMonth, currentYear)
        if (jd < ly[0].jd) {
            ly = getYearInfo(currentYear - 1)
        }
        return findLunarDate(jd, ly)
    }

    //Trả về ngày âm với ngày dương là tham số truyền vào.
    fun getLunarDate(solarDate: SolarDate): LunarDate {
        if (solarDate.year < 1800 || 2199 < solarDate.year) {
            return LunarDate(0, 0, 0)
        }
        var ly = getYearInfo(solarDate.year)
        val jd = jdn(solarDate.day, solarDate.month, solarDate.year)
        if (jd < ly[0].jd) {
            ly = getYearInfo(solarDate.year - 1)
        }
        return findLunarDate(jd, ly)
    }

    //Trả về ngày âm với ngày, tháng, năm dương là tham số truyền vào.
    fun getLunarDate(solarDay: Int, solarMonth: Int, solarYear: Int): LunarDate {
        if (solarYear < 1800 || 2199 < solarYear) {
            return LunarDate(0, 0, 0)
        }
        var ly = getYearInfo(solarYear)
        val jd = jdn(solarDay, solarMonth, solarYear)
        if (jd < ly[0].jd) {
            ly = getYearInfo(solarYear - 1)
        }
        return findLunarDate(jd, ly)
    }

    //========== Ngày dương ==========//

    //Trả về ngày dương với ngày âm là tham số truyền vào.
    fun getSolarDate(lunarDate: LunarDate): SolarDate {
        if (lunarDate.year < 1800 || 2199 < lunarDate.year) {
            return SolarDate(0, 0, 0, 0)
        }

        val lunarDates = getYearInfo(lunarDate.year)
        val ld = lunarDates[lunarDate.month - 1]

        return jdToSolarDate(ld.jd + lunarDate.day - 1)
    }

    //Trả về ngày dương với ngày, tháng, năm âm là tham số truyền vào.
    fun getSolarDate(lunarDay: Int, lunarMonth: Int, lunarYear: Int): SolarDate {
        if (lunarYear < 1800 || 2199 < lunarYear) {
            return SolarDate(0, 0, 0, 0)
        }

        val lunarDates = getYearInfo(lunarYear)
        val lunarDate = lunarDates[lunarMonth - 1]

        return jdToSolarDate(lunarDate.jd + lunarDay - 1)
    }

    //========== Ngày Can Chi ==========//

    //Trả về ngày Can Chi của ngày dương hiện tại.
    fun getCanChiDate(): CanChiDate {
        val lunarDate = getLunarDate()

        val dayName = CAN[(lunarDate.jd + 9) % 10] + " " + CHI[(lunarDate.jd + 1) % 12]
        var monthName =
            CAN[(lunarDate.year * 12 + lunarDate.month + 3) % 10] + " " + CHI[(lunarDate.month + 1) % 12]
        if (lunarDate.leap == 1) {
            monthName += " (Nhuận)"
        }

        val yearName = CAN[(lunarDate.year + 6) % 10] + " " + CHI[(lunarDate.year + 8) % 12]

        return CanChiDate(dayName, monthName, yearName)
    }

    //Trả về ngày Can Chi của ngày âm là tham số truyền vào.
    fun getCanChiDate(lunarDate: LunarDate): CanChiDate {
        val dayName = CAN[(lunarDate.jd + 9) % 10] + " " + CHI[(lunarDate.jd + 1) % 12]
        var monthName =
            CAN[(lunarDate.year * 12 + lunarDate.month + 3) % 10] + " " + CHI[(lunarDate.month + 1) % 12]
        if (lunarDate.leap == 1) {
            monthName += " (Nhuận)"
        }

        val yearName = CAN[(lunarDate.year + 6) % 10] + " " + CHI[(lunarDate.year + 8) % 12]

        return CanChiDate(dayName, monthName, yearName)
    }

    //Trả về ngày Can Chi của ngày duongw là tham số truyền vào.
    fun getCanChiDate(solarDate: SolarDate): CanChiDate {
        val lunarDate = getLunarDate(solarDate)

        val dayName = CAN[(lunarDate.jd + 9) % 10] + " " + CHI[(lunarDate.jd + 1) % 12]
        var monthName =
            CAN[(lunarDate.year * 12 + lunarDate.month + 3) % 10] + " " + CHI[(lunarDate.month + 1) % 12]
        if (lunarDate.leap == 1) {
            monthName += " (Nhuận)"
        }

        val yearName = CAN[(lunarDate.year + 6) % 10] + " " + CHI[(lunarDate.year + 8) % 12]

        return CanChiDate(dayName, monthName, yearName)
    }

    //Trả về ngày Can Chi của ngày, tháng, năm là tham số truyền vào.
    fun getCanChiDate(solarDay: Int, solarMonth: Int, solarYear: Int): CanChiDate {
        val solarDate = SolarDate(solarDay, solarMonth, solarYear)
        return getCanChiDate(solarDate)
    }

    //========== Thứ ==========//

    //Trả về thứ của ngày hiện tại.
    fun getWeekdays(): String {
        val lunarDate = getLunarDate()
        return TUAN[(lunarDate.jd + 1) % 7]
    }

    //Trả về thứ của ngày dương là tham số truyền vào.
    fun getWeekdays(solarDate: SolarDate): String {
        val lunarDate = getLunarDate(solarDate)

        return TUAN[(lunarDate.jd + 1) % 7]
    }

    //Trả về thứ của ngày âm là tham số truyền vào.
    fun getWeekdays(lunarDate: LunarDate): String {
        return TUAN[(lunarDate.jd + 1) % 7]
    }

    //Trả về thứ của ngày, tháng, năm là tham số truyền vào.
    fun getWeekdays(solarDay: Int, solarMonth: Int, solarYear: Int): String {
        val lunarDate = getLunarDate(solarDay, solarMonth, solarYear)
        return TUAN[(lunarDate.jd + 1) % 7]
    }

    //==========Giờ can chi
//    val canDateIndex = (lunarDate.jd + 9) % 10
//    val chiHourIndex = getChiHourIndex(
//        Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
//        Calendar.getInstance().get(Calendar.MINUTE)
//    )
//
//    val gioCanChi =
//        "Giờ CanChi: ${CAN[getCanHourIndex(
//            canDateIndex,
//            chiHourIndex
//        )]} ${CHI[chiHourIndex]}"

    private fun getChiHourIndex(hour: Int, minute: Int): Int {
        val time: Float = hour + minute / 60f

        if (time >= 23 || time < 1) {   //Tý
            return 0
        }
        if (time >= 1 && time < 3) {    //Sửu
            return 1
        }
        if (time >= 3 && time < 5) {    //Dần
            return 2
        }
        if (time >= 5 && time < 7) {    //Mão
            return 3
        }
        if (time >= 7 && time < 9) {    //Thìn
            return 4
        }
        if (time >= 9 && time < 11) {   //Tỵ
            return 5
        }
        if (time >= 11 && time < 13) {  //Ngọ
            return 6
        }
        if (time >= 13 && time < 15) {  //Mùi
            return 7
        }
        if (time >= 15 && time < 17) {  //Thân
            return 8
        }
        if (time >= 17 && time < 19) {  //Dậu
            return 9
        }
        if (time >= 19 && time < 21) {  //Tuất
            return 10
        } else {                          //Hợi
            return 11
        }
    }

    private fun getCanHourIndex(chiDate: Int, chiHourIndex: Int): Int {
        var baseIndex = 0

        when (chiDate) {
            0, 5 -> {   //Giáp - Kỷ
                baseIndex = 0   //Giáp
            }

            1, 6 -> {   //Ất - Canh
                baseIndex = 2   //Bính
            }

            2, 7 -> {   //Bính Tân
                baseIndex = 4   //Mậu
            }

            3, 8 -> {   //Đinh Nhâm
                baseIndex = 6   //Canh
            }

            4, 9 -> {   //Mậu Quý
                baseIndex = 8   //Nhâm
            }
        }
        val index = (baseIndex + chiHourIndex) % 10
        return index
    }

    //========== Tiết khí
    private fun getTietKhi(jd: Int): String {
        return TIETKHI[getSunLongitude(jd + 1)]
    }

    //========== Giờ hoàng đạo
    private fun getGioHoangDao(lunarDateJd: Int): String {
        val chiOfDay = (lunarDateJd + 1) % 12
        val gioHD =
            GIO_HD[chiOfDay % 6] // same values for Ty' (1) and Ngo. (6), for Suu and Mui etc.
        var ret = ""
        val canDateIndex = (lunarDateJd + 9) % 10
        var count = 0
        for (i in 0..11) {
            if (gioHD[i] == '1') {
                ret += "${CAN[getCanHourIndex(canDateIndex, i)]} ${CHI[i]}"
                ret += " (" + (i * 2 + 23) % 24 + " - " + (i * 2 + 1) % 24 + ")"
                if (count++ < 5) ret += ", "
            }
        }

        return ret
    }

    private fun findLunarDate(jd: Int, ly: MutableList<LunarDate>): LunarDate {
        if (jd > LAST_DAY || jd < FIRST_DAY || ly[0].jd > jd) {
            return LunarDate(0, 0, 0)
        }
        var i = ly.size - 1
        while (jd < ly[i].jd) {
            i--
        }
        val off = jd - ly[i].jd
        return LunarDate(ly[i].day + off, ly[i].month, ly[i].year, ly[i].leap, jd)
    }

    private fun getYearInfo(yyyy: Int): MutableList<LunarDate> {
        val yearCode: Int = when {
            yyyy < 1900 -> {
                TK19[yyyy - 1800]
            }
            yyyy < 2000 -> {
                TK20[yyyy - 1900]
            }
            yyyy < 2100 -> {
                TK21[yyyy - 2000]
            }
            else -> {
                TK22[yyyy - 2100]
            }
        }
        return decodeLunarYear(yyyy, yearCode)
    }

    private fun decodeLunarYear(yy: Int, k: Int): MutableList<LunarDate> {
        var j: Int
        var mm: Int
        val ly = mutableListOf<LunarDate>()

        val monthLengths = arrayOf(29, 30)
        val regularMonths = arrayOfNulls<Int>(12)
        val offsetOfTet = k shr 17
        val leapMonth = k and 0xf
        val leapMonthLength = monthLengths[k shr 16 and 0x1]
        val solarNY = jdn(1, 1, yy) as Int
        var currentJD = solarNY + offsetOfTet
        j = k shr 4

        var i = 0
        while (i < 12) {
            regularMonths[12 - i - 1] = monthLengths[j and 0x1]
            j = j shr 1
            i++
        }

        if (leapMonth == 0) {
            mm = 1
            while (mm <= 12) {
                ly.add(LunarDate(1, mm, yy, 0, currentJD))
                currentJD += regularMonths[mm - 1]!!
                mm++
            }
        } else {
            mm = 1
            while (mm <= leapMonth) {
                ly.add(LunarDate(1, mm, yy, 0, currentJD))
                currentJD += regularMonths[mm - 1]!!
                mm++
            }

            ly.add(LunarDate(1, leapMonth, yy, 1, currentJD))
            currentJD += leapMonthLength
            mm = leapMonth + 1

            while (mm <= 12) {
                ly.add(LunarDate(1, mm, yy, 0, currentJD))
                currentJD += regularMonths[mm - 1]!!
                mm++
            }
        }
        return ly
    }

    private fun jdn(dd: Int, mm: Int, yy: Int): Int {
        val a = INT((14 - mm) / 12)
        val y = yy + 4800 - a
        val m = mm + 12 * a - 3
        val jd =
            dd + INT((153 * m + 2) / 5) + 365 * y + INT(y / 4) - INT(y / 100) + INT(y / 400) - 32045
        return jd.toInt()
    }

    private fun jdToSolarDate(jd: Int): SolarDate {
        val a: Int
        val b: Int
        val c: Int

        if (jd > 2299160) { // After 5/10/1582, Gregorian calendar
            a = jd + 32044
            b = INT((4 * a + 3) / 146097).toInt()
            c = (a - INT((b * 146097) / 4)).toInt()
        } else {
            b = 0
            c = jd + 32082
        }
        val d = INT((4 * c + 3) / 1461).toInt()
        val e = (c - INT((1461 * d) / 4)).toInt()
        val m = (INT((5 * e + 2) / 153)).toInt()
        val day = (e - INT((153 * m + 2) / 5) + 1).toInt()
        val month = (m + 3 - 12 * INT(m / 10)).toInt()
        val year = (b * 100 + d - 4800 + INT(m / 10)).toInt()

        return SolarDate(day, month, year, jd)
    }

    private fun getSunLongitude(dayNumber: Int): Int {
        val jdn = dayNumber - 0.5 - 7 / 24
        val t = (jdn - 2451545.0) / 36525 // Time in Julian centuries from 2000-01-01 12:00:00 GMT
        val t2 = t * t
        val dr = Math.PI / 180 // degree to radian
        val m =
            357.52910 + 35999.05030 * t - 0.0001559 * t2 - 0.00000048 * t * t2 // mean anomaly, degree
        val l0 = 280.46645 + 36000.76983 * t + 0.0003032 * t2 // mean longitude, degree
        var dl = (1.914600 - 0.004817 * t - 0.000014 * t2) * sin(dr * m)
        dl += (0.019993 - 0.000101 * t) * sin(dr * 2 * m) + 0.000290 * sin(dr * 3 * m)
        var l = l0 + dl // true longitude, degree
        l *= dr
        l -= Math.PI * 2 * (INT(l / (Math.PI * 2))) // Normalize to (0, 2*PI)
        return INT(l / Math.PI * 12).toInt()
    }
}