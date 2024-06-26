package io.github.mikaojk.holiday

import java.time.LocalDate
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


internal class NorwegianHolidaysTest {

    @Test
    internal fun easterDay2021ShouldBe4April() {
        val expectedEasterDayFor2021 = LocalDate.of(2021, 4, 4)
        val easterDay = getEasterDay(2021)

        assertEquals(expectedEasterDayFor2021, easterDay)
    }

    @Test
    internal fun easterDay2022ShouldBe17april() {
        val expectedEasterDayFor2022 = LocalDate.of(2022, 4, 17)
        val easterDay = getNorwegianHolidays(2022).find { it.name == "1. påskedag" }?.date

        assertEquals(expectedEasterDayFor2022, easterDay)
    }

    @Test
    internal fun easterDay2024ShouldBe31march() {
        val expectedEasterDayFor2024 = LocalDate.of(2024, 3, 31)
        val easterDay = getNorwegianHolidays(2024).find { it.name == "1. påskedag" }?.date

        assertEquals(expectedEasterDayFor2024, easterDay)
    }

}