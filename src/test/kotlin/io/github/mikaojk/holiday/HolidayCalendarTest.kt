package io.github.mikaojk.holiday

import java.time.LocalDate
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class HolidayCalendarTest {
    private val calendar: HolidayCalendar = NorwegianHolidayCalendar()

    @Test
    internal fun holidaysFor2025ShouldContainAllTwelveNamedHolidays() {
        val expected =
            listOf(
                NorwegianHoliday("1. nyttårsdag", LocalDate.of(2025, 1, 1)),
                NorwegianHoliday("Skjærtorsdag", LocalDate.of(2025, 4, 17)),
                NorwegianHoliday("Langfredag", LocalDate.of(2025, 4, 18)),
                NorwegianHoliday("1. påskedag", LocalDate.of(2025, 4, 20)),
                NorwegianHoliday("2. påskedag", LocalDate.of(2025, 4, 21)),
                NorwegianHoliday("Arbeidernes dag", LocalDate.of(2025, 5, 1)),
                NorwegianHoliday("Grunnlovsdagen", LocalDate.of(2025, 5, 17)),
                NorwegianHoliday("Kristi Himmelfartsdag", LocalDate.of(2025, 5, 29)),
                NorwegianHoliday("1. pinsedag", LocalDate.of(2025, 6, 8)),
                NorwegianHoliday("2. pinsedag", LocalDate.of(2025, 6, 9)),
                NorwegianHoliday("1. juledag", LocalDate.of(2025, 12, 25)),
                NorwegianHoliday("2. juledag", LocalDate.of(2025, 12, 26)),
            )

        assertEquals(expected, calendar.holidays(2025))
        for ((name, date) in expected) {
            assertTrue(calendar.isHoliday(date), name)
            assertFalse(calendar.isWorkingDay(date), name)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "2025-06-02, false, true",
        "2025-06-03, false, true",
        "2025-06-04, false, true",
        "2025-06-05, false, true",
        "2025-06-06, false, true",
        "2025-06-07, false, false",
        "2025-06-15, false, false",
        "2025-05-17, true, false",
        "2025-04-20, true, false",
        "2024-03-29, true, false",
        "2025-03-29, false, false",
        "2026-04-03, true, false",
        "2024-12-31, false, true",
        "2025-01-01, true, false",
        "2025-01-02, false, true",
        "2025-12-31, false, true",
        "2026-01-01, true, false",
        "2024-02-29, false, true",
    )
    internal fun datesShouldDistinguishHolidaysWeekendsAndWorkingDays(
        date: LocalDate,
        expectedHoliday: Boolean,
        expectedWorkingDay: Boolean,
    ) {
        assertEquals(expectedHoliday, calendar.isHoliday(date))
        assertEquals(expectedWorkingDay, calendar.isWorkingDay(date))
    }

    @Test
    internal fun customCalendarsShouldUseTheirOwnHolidaysAndTheRequestedYear() {
        val customCalendar =
            object : HolidayCalendar {
                override fun holidays(year: Int): List<Holiday> =
                    listOf(
                        object : Holiday {
                            override val name = "Custom holiday"
                            override val date = LocalDate.of(year, 6, 3)
                        }
                    )
            }

        for (year in listOf(2025, 2026)) {
            assertTrue(customCalendar.isHoliday(LocalDate.of(year, 6, 3)))
            assertFalse(customCalendar.isWorkingDay(LocalDate.of(year, 6, 3)))
            assertFalse(customCalendar.isHoliday(LocalDate.of(year, 6, 4)))
            assertTrue(customCalendar.isWorkingDay(LocalDate.of(year, 6, 4)))
        }
        assertFalse(customCalendar.isHoliday(LocalDate.of(2025, 1, 1)))
        assertTrue(customCalendar.isWorkingDay(LocalDate.of(2025, 1, 1)))
        assertFalse(customCalendar.isWorkingDay(LocalDate.of(2025, 6, 7)))
        assertFalse(customCalendar.isWorkingDay(LocalDate.of(2025, 6, 8)))
    }
}
