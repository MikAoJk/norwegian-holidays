package io.github.mikaojk.holiday

import java.time.LocalDate


fun getNorwegianHolidays(year: Int): List<NorwegianHoliday> {
    val firstNewYearsDay = NorwegianHoliday(name = "1. nyttårsdag", date = LocalDate.of(year, 1, 1))
    val easterDayDate = getEasterDay(year)
    val maundyThursday = NorwegianHoliday(name = "Skjærtorsdag", date = easterDayDate.minusDays(3))
    val goodFriday = NorwegianHoliday(name = "Langfredag", date = easterDayDate.minusDays(2))
    val easterDay = NorwegianHoliday(name = "1. påskedag", date = easterDayDate)
    val secoundEasterDay = NorwegianHoliday(name = "2. påskedag", date = easterDayDate.plusDays(1))
    val laborDay = NorwegianHoliday(name = "Arbeidernes dag", date = LocalDate.of(year, 5, 1))
    val constitutionDay = NorwegianHoliday(name = "Grunnlovsdagen", date = LocalDate.of(year, 5, 17))
    val christsAscension = NorwegianHoliday(name = "Kristi Himmelfartsdag", date = easterDayDate.plusDays(39))
    val firstdayOfPentecost = NorwegianHoliday(name = "1. pinsedag", date = easterDayDate.plusDays(49))
    val secounDayOfPentecost = NorwegianHoliday(name = "2. pinsedag", date = easterDayDate.plusDays(50))
    val firstofChristmas = NorwegianHoliday(name = "1. juledag", date = LocalDate.of(year, 12, 25))
    val secounofChristmas = NorwegianHoliday(name = "2. juledag", date = LocalDate.of(year, 12, 26))

    return listOf(
        firstNewYearsDay, maundyThursday, goodFriday, easterDay, secoundEasterDay, laborDay, constitutionDay,
        christsAscension, firstdayOfPentecost, secounDayOfPentecost, firstofChristmas, secounofChristmas
    )

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
