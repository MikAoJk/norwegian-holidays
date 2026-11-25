# norwegian-holidays
A simple library that finds the Norwegian holidays for a given year

[![Build and test](https://github.com/MikAoJk/norwegian-holidays/actions/workflows/build-and-test.yml/badge.svg?branch=main)](https://github.com/MikAoJk/norwegian-holidays/actions/workflows/build-and-test.yml)
[![Validate Gradle Wrapper](https://github.com/MikAoJk/norwegian-holidays/actions/workflows/gradle-wrapper-validation.yml/badge.svg?branch=main)](https://github.com/MikAoJk/norwegian-holidays/actions/workflows/gradle-wrapper-validation.yml)
[![GitHub Release](https://img.shields.io/github/v/release/MikAoJk/norwegian-holidays)](https://img.shields.io/maven-central/v/io.github.mikaojk/norwegian-holidays
)

## Technologies used
* Kotlin
* Gradle
* JDK 25

#### Build and run tests
To build locally and run the unit tests you can simply run `./gradlew clean build` or on windows
`gradlew.bat clean build`

## Using the library
### import
> **Note**
> Find the newest version of the libary here: https://central.sonatype.com/artifact/io.github.mikaojk/norwegian-holidays
> and swap it out with the version: 1.0.5 in the examples below

#### Gradle(Kotlin)
```
implementation("io.github.mikaojk:norwegian-holidays:1.0.5")
```

#### Apache Maven
```
<dependency>
  <groupId>io.github.mikaojk</groupId>
  <artifactId>norwegian-holidays</artifactId>
  <version>1.0.5</version>
</dependency>
```
### Example usage kotlin
```
import io.github.mikaojk.holiday.getNorwegianHolidays

val year = 2025
val easterDay2025 = getNorwegianHolidays(year).find { norwegianHoliday -> norwegianHoliday.name == "1. påskedag" }?.date

println("Easter day for 2022 is: easterDay2025")
```

### Calendar API
Use `HolidayCalendar` to work with a calendar independently of its implementation:

```kotlin
import io.github.mikaojk.holiday.HolidayCalendar
import io.github.mikaojk.holiday.NorwegianHolidayCalendar
import java.time.LocalDate

val calendar: HolidayCalendar = NorwegianHolidayCalendar()

val holidays = calendar.holidays(2025)
val isHoliday = calendar.isHoliday(LocalDate.of(2025, 4, 18)) // true (Good Friday)
val isWorkingDay = calendar.isWorkingDay(LocalDate.of(2025, 4, 22)) // true
```

`holidays(year)` returns the same twelve named holidays, in the same order, as
`getNorwegianHolidays(year)`. `isHoliday(date)` only checks those holidays; an ordinary
Saturday or Sunday is not a holiday. `isWorkingDay(date)` is `true` for Monday through
Friday unless the date is a holiday.

Custom calendars implement `HolidayCalendar.holidays(year)` and return a `List<Holiday>`.
`Holiday` exposes `name` and `date`; `NorwegianHoliday` implements this interface. The
default `isHoliday` and `isWorkingDay` implementations use the custom calendar's holidays.

### Upgrading the Gradle wrapper version to latest
``` bash
./gradlew :wrapper --gradle-version latest
```
### Contact

Questions and/or feature requests? Please create an [issue](https://github.com/MikAoJk/norwegian-holidays/issues).
