// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.google.gms.google.services) apply false
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.ksp)

}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        // Plugin untuk AGP, Kotlin, dan Compose Compiler
        classpath(libs.gradle)  // Versi Android Gradle Plugin (AGP)
        classpath(libs.kotlin.gradle.plugin)  // Versi Kotlin
    }
}
