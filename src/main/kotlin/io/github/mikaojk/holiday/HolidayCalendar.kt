package io.github.mikaojk.holiday

import java.time.DayOfWeek
import java.time.LocalDate

interface Holiday {
    val name: String
    val date: LocalDate
}

interface HolidayCalendar {
    fun holidays(year: Int): List<Holiday>

    fun isHoliday(date: LocalDate): Boolean = holidays(date.year).any { it.date == date }

    fun isWorkingDay(date: LocalDate): Boolean =
        date.dayOfWeek != DayOfWeek.SATURDAY &&
            date.dayOfWeek != DayOfWeek.SUNDAY &&
            !isHoliday(date)
}
