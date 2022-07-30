import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


group = "io.github.MikAoJk"
version = "1.0.0"

val junitJupiterVersion = "5.8.2"
val kotlinVersion = "1.7.10"
val javaVersion = "17"

plugins {
    kotlin("jvm") version "1.7.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = javaVersion
    }

    withType<Javadoc> {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }

    withType<Test> {
        useJUnitPlatform()
        testLogging {
            showStandardStreams = true
        }
    }
}
