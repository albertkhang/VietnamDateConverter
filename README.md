# VietnamDateConverter

## Features
- Get **Lunar Date** from **Solar Date** / Tính Ngày Âm Lịch

- Get **Solar Date** from **Lunar Date** / Tính Ngày Dương Lịch

- Get **Can-Chi Date** from **Solar/Lunar Date** / Tính Ngày Theo Can Chi
```
Example: NgàyTân Hợi, Tháng Bính Dần, Năm Kỷ Mão
```
- Get **Weekdays** / Tính Thứ Trong Tuần
```
Example: Chủ Nhật
```
- Get **Can-Chi Hour** (24-hour) / Tính Giờ Theo Can Chi
```
Example: Giờ Bính Tuất
```
- Get **Solar Term** / Tính Tiết Khí
```
Example: Xuân Phân
```
- Get **Zodiac Hour** / Tính Giờ Hoàng Đạo
```
Example: Bính Tý (23h-1h), Đinh Sửu (1h-3h), Kỷ Mão (5h-7h), Nhâm Ngọ (11h-13h), Giáp Thân (15h-17h), Ất Dậu (17h-19h)
```

## Limitation
- VietnamDateConvert can only convert dates between 1800 and 2199. It will return date is 0 if the date is not between 1800 and 2199.
> I suggest the period should smaller than limitation. For example, between 1805 and 2195.
- Unless the developer has to handle the input to make sure it valid, it will return the wrong date.
> For example, if the Solar Date input (day, month, year) is 30, 2, 2020, it will return the wrong date.

## Download
[![](https://jitpack.io/v/albertkhang/VietnamDateConverter.svg)](https://jitpack.io/#albertkhang/VietnamDateConverter)
### Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
### Step 2. Add the dependency
```
dependencies {
  implementation 'com.github.albertkhang:VietnamDateConverter:v0.1.0'
}
```

## How to use
There are 2 ways to initiate the instance of the library.
### 1. Create one time when initial
```
private lateinit var vdConverter: VietnamDateConverter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vdConverter = VietnamDateConverter.getInstance()
    }
```
Then, every time you want to use a function, just use
```
vdConverter.getLunarDate()
vdConverter.getCanChiDate()
```
### 2. Create each use
Instead of using as above, using like this way
```
val vdConverter = VietnamDateConverter.getInstance().getLunarDate()
```
## Documentation

## Contribute
This library can only get better if you make code contributions. Found a bug? Report it. Have a feature idea you'd love to see in VietnamDateConverter? Contribute to the project! All pull requests are welcome.

## Algorithm Copyright
- Copyright (c) 2006 Ho Ngoc Duc. All Rights Reserved.
- Astronomical algorithms from the book "Astronomical Algorithms" by Jean Meeus, 1998
- Permission to use, copy, modify, and redistribute this software and its documentation for personal, non-commercial use is hereby granted provided that this copyright notice and appropriate documentation appears in all copies.
- Author: http://www.informatik.uni-leipzig.de/~duc/
- Lunisolar Calendar: http://www.informatik.uni-leipzig.de/~duc/amlich/

## License
```
Copyright (C) 2020 Albert Khang.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
