package io.github.mikaojk.holiday

import java.time.LocalDate


fun getNorwegianHolidays(year: Int): List<NorwegianHoliday> {
    val easterDay = NorwegianHoliday(name = "1. påskedag", date = getEasterDay(year))
    val secoundEasterDay = NorwegianHoliday(name = "1. påskedag", date = easterDay.date.plusDays(1))

    // TODO get the rest of the norwegian holidays
    return listOf(easterDay, secoundEasterDay)

}

fun getEasterDay(year: Int): LocalDate {
    val a = year % 19
    val b = year / 100
    val c = year % 100
    val d = b / 4
    val e = b % 4
    val f = (b + 8) / 25
    val g = (b - f + 1) / 3
    val h = (19 * a + b - d - g + 15) % 30
    val i = c / 4
    val k = c % 4
    val l = (32 + 2 * e + 2 * i - h - k) % 7
    val m = (a + 11 * h + 22 * l) / 451

    val month = (h + l - 7 * m + 114) / 31
    val day = ((h + l - 7 * m + 114) % 31) + 1
    return LocalDate.of(year, month, day)
}

data class NorwegianHoliday(
    val name: String,
    val date: LocalDate
)
