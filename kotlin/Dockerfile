# Stage 1: Build with Gradle
FROM eclipse-temurin:17-jdk-jammy AS builder

# Set working directory
WORKDIR /home/gradle/project

# Copy only Gradle-related files first to leverage caching
COPY --chown=gradle:gradle build.gradle.kts settings.gradle.kts gradlew ./
COPY --chown=gradle:gradle gradle ./gradle

# Download dependencies (cached unless build.gradle changes)
RUN ./gradlew dependencies --no-daemon

# Copy the rest of the project files
COPY --chown=gradle:gradle . .

# Build the project, excluding tests if not needed, and skip daemon
RUN ./gradlew clean test jacocoTestReport sonarqube --no-daemon
