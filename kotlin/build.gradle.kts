plugins {
    kotlin("jvm") version "1.9.10"
    application
    id("org.sonarqube") version "4.3.1.3277"
    jacoco
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
}

application {
    mainClass.set("AppKt")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests must run before generating the report

    reports {
        xml.required.set(true)   // enable XML report for SonarQube
        csv.required.set(false)
        html.required.set(true)  // HTML useful for local review
    }
}

sonarqube {
    properties {
        property("sonar.projectKey", "kotlin-gradle-docker")
        property("sonar.projectName", "Kotlin Gradle Docker Sample")
        property("sonar.host.url", "https://sonarqube")
        property("sonar.token", "sqa_57b6fa9ba352e90916f6be33907c13XXXXXXXXXX")
        property("sonar.sources", "src/main/kotlin")
        property("sonar.tests", "src/test/kotlin")
        property("sonar.test.inclusions", "**/*Test.kt")
        property("sonar.exclusions", "**/build/**")
        property("sonar.sourceEncoding", "UTF-8")
        property("sonar.junit.reportPaths", "${project.buildDir}/test-results/test")
        property("sonar.coverage.jacoco.xmlReportPaths", "${project.buildDir}/reports/jacoco/test/jacocoTestReport.xml")
    }
}

