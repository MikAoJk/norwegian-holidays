package io.github.mikaojk.holiday

class NorwegianHolidayCalendar : HolidayCalendar {
    override fun holidays(year: Int): List<NorwegianHoliday> = getNorwegianHolidays(year)
}
