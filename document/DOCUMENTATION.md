# VietnamDateConverter Documentation
There are two parts to this document. The first is "**Object Classes**" which only have a unique function to hold data. The second is a "**Converter**" to convert between those object classes.
## Object Classes
We have 4 object to hold data and public functions are:
1. LunarDate / Ngày Âm Lịch
```
+ day: Int
    getter/setter
+ month: Int
    getter/setter
+ year: Int
    getter/setter
    
+ constructor(day: Int, month: Int, year: Int)
```

2. SolarDate / Ngày Dương Lịch
```
+ day: Int
    getter/setter
+ month: Int
    getter/setter
+ year: Int
    getter/setter
    
+ constructor(day: Int, month: Int, year: Int)
```

3. CanChiDate / Ngày Can Chi
```
+ getDay(): String
+ getMonth(): String
+ getYear(): String
```

4. ZodiacHour / Giờ Can Chi
```
+ getStartHour(): Int
+ getEndHour(): Int
+ getHourName(): String
```

## Converter
VietnamDateConverter is divided into 7 public methods groups.
### 1. GetLunarDate Group
+ getLunarDate(): LunarDate
> return Lunar Date from current Solar Date.

+ getLunarDate(solarDate: SolarDate): LunarDate
> return Lunar Date from Solar Date in parameter.

+ getLunarDate(solarDay: Int, solarMonth: Int, solarYear: Int): LunarDate
> return Lunar Date from Solar Date have day, month, year in parameters.

### 2. GetSolarDate Group
+ getSolarDate(lunarDate: LunarDate): SolarDate
> return Solar Date from  Lunar Date in parameter.

+ getSolarDate(lunarDay: Int, lunarMonth: Int, lunarYear: Int): SolarDate
> return Solar Date from Lunar Date have day, month, year in parameters.

### 3. GetCanChiDate Group
+ getCanChiDate(): CanChiDate
> return Can Chi Date from current Solar Date.

+ getCanChiDate(lunarDate: LunarDate): CanChiDate
> return Can Chi Date from Lunar Date in parameter.

+ getCanChiDate(solarDate: SolarDate): CanChiDate
> return Can Chi Date from Solar Date in parameter.

+ getCanChiDate(solarDay: Int, solarMonth: Int, solarYear: Int): CanChiDate
> return Can Chi Date from Solar Date have day, month, year in parameters.

### 4. GetWeekdays Group
+ getWeekdays(): String
> return current Weekday.

+ getWeekdays(solarDate: SolarDate): String
> return Weekday from Solar Date in parameter. 

+ getWeekdays(lunarDate: LunarDate): String
> return Weekday from Lunar Date in parameter.

+ getWeekdays(solarDay: Int, solarMonth: Int, solarYear: Int): String
> return Weekday fromn Solar Date have day, month, year in parameters.

### 5. GetCanChiHour Group
+ getCanChiHour(): String
> return Can Chi Hour of current Hour and current Solar Date.

+ getCanChiHour(hour: Int, minute: Int): String
> return Can Chi Hour from hour, minute from parameters and current Solar Date.

+ getCanChiHour(hour: Int, minute: Int, solarDate: SolarDate): String
> return Can Chi Hour from hour, minute, Solar Date in parameters.

+ getCanChiHour(hour: Int, minute: Int, lunarDate: LunarDate): String
>  > return Can Chi Hour from hour, minute, Lunar Date in parameters.

+ getCanChiHour(hour: Int, minute: Int, solarDay:Int, solarMonth: Int, solarYear: Int): String
> > return Can Chi Hour from hour, minute, day, month, year in parameters.

### 6. GetSolarTerm Group
+ getSolarTerm(): String
> return Solar Term from current Solar Date. 

+ getSolarTerm(solarDate: SolarDate): String
> return Solar Term from Solar Date in parameter.

+ getSolarTerm(lunarDate: LunarDate): String
> return Solar Term from Lunar Date in parameter. 

+ getSolarTerm(solarDay:Int, solarMonth: Int, solarYear: Int): String
> return Solar Term from Solar Date have day, month, year in parameters.

### 7. GetZodiacHour Group
+ getZodiacHour(): MutableList<ZodiacHour>
> return a list of Zodiac Hour from current Solar Date. 

+ getZodiacHour(solarDate: SolarDate): MutableList<ZodiacHour>
> return a list of Zodiac Hour from Solar Date in parameter.

+ getZodiacHour(lunarDate: LunarDate): MutableList<ZodiacHour>
> return a list of Zodiac Hour from Luanr Date in parameter.

+ getZodiacHour(solarDay:Int, solarMonth: Int, solarYear: Int): MutableList<ZodiacHour>
> return a list of Zodiac Hour from day, month, year in parameters.
