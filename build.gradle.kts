// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    dependencies {
        val nav_version = "2.7.7"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}

plugins {
    id("com.android.application") version "8.4.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.google.gms.google-services") version "4.3.15" apply false
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
}