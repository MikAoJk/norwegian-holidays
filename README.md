# norwegian-holidays
A simple repo that finds the norwegian holidays for a given year

[![Build and test](https://github.com/MikAoJk/norwegian-holidays/actions/workflows/build-and-test.yml/badge.svg?branch=main)](https://github.com/MikAoJk/norwegian-holidays/actions/workflows/build-and-test.yml)
[![Validate Gradle Wrapper](https://github.com/MikAoJk/norwegian-holidays/actions/workflows/gradle-wrapper-validation.yml/badge.svg?branch=main)](https://github.com/MikAoJk/norwegian-holidays/actions/workflows/gradle-wrapper-validation.yml)

## Technologies used
* Kotlin
* Gradle
* JDK 17

#### Build and run tests
To build locally and run the integration tests you can simply run `./gradlew clean build` or on windows
`gradlew.bat clean build`

### Upgrading the gradle wrapper
Find the newest version of gradle here: https://gradle.org/releases/ Then run this command:

```./gradlew wrapper --gradle-version $gradleVersjon```

### Usage
```
val year = 2022
val easterDay = getNorwegianHolidays(year).find { it.name == "1. påskedag" }?.date

println("Easter day for 2022 is: $easterDay")
```

### Contact

Questions and/or feature requests? Please create an [issue](https://github.com/MikAoJk/norwegian-holidays/issues).