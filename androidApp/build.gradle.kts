plugins {
    id("com.android.application")
    kotlin("android")
    id ("com.google.secrets_gradle_plugin") version "0.4"
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    // Lifecycle
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    // Coil Library for image loading
    implementation("io.coil-kt:coil:1.4.0")
    // Coroutines Library
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")

}

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "com.shady.kmm.android"
        minSdkVersion(25)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}