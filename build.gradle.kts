import org.jetbrains.kotlin.gradle.dsl.JvmTarget

group = "io.github.mikaojk"
version = System.getenv("NEW_VERSION") ?: "1.0.0"

val junitJupiterVersion = "6.0.1"
val kotlinVersion = "2.3.0-Beta2"

plugins {
    kotlin("jvm") version "2.3.0-Beta2"
    id("com.vanniktech.maven.publish") version "0.35.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")

    testImplementation("org.junit.jupiter:junit-jupiter:$junitJupiterVersion")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_25)
    }
}


mavenPublishing {
    publishToMavenCentral(automaticRelease = true)
    signAllPublications()

    coordinates(group.toString(), "norwegian-holidays", version.toString())

    pom {
        name.set("norwegian-holidays")
        description.set("Library for validating a norwegian holidays")
        url.set("https://github.com/MikAoJk/norwegian-holidays")
        inceptionYear.set("2024")
        licenses {
            license {
                name.set("MIT License")
                url.set("https://opensource.org/licenses/MIT")
                distribution.set("https://github.com/MikAoJk/norwegian-holidays.git")
            }
        }

        developers {
            developer {
                id.set("MikAoJk")
                name.set("Joakim Taule Kartveit")
                email.set("joakimkartveit@gmail.com")
                url.set("https://github.com/MikAoJk/")
            }
        }

        scm {
            connection.set("scm:git:git://github.com/MikAoJk/norwegian-holidays.git")
            developerConnection.set("scm:git:https://github.com/MikAoJk/norwegian-holidays.git")
            url.set("https://github.com/MikAoJk/norwegian-holidays")
        }
        version = System.getenv("NEW_VERSION")
    }

}


tasks {
    test {
        useJUnitPlatform {}
        testLogging {
            events("skipped", "failed")
            showStackTraces = true
            showExceptions = true
            showCauses = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
    }

}
