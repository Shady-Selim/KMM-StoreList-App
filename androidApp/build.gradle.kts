plugins {
    id("com.android.application")
    kotlin("android")
    id ("com.google.secrets_gradle_plugin") version "0.4"
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    // Integration with activities
    implementation ("androidx.activity:activity-compose:1.4.0")
    // Compose Material Design
    implementation ("androidx.compose.material:material:1.0.5")
    // Animations
    implementation ("androidx.compose.animation:animation:1.0.5")
    // Tooling support (Previews, etc.)
    implementation ("androidx.compose.ui:ui:1.0.5")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.0.5")
    // Integration with ViewModels
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0")
    // Livedata
    implementation ("androidx.compose.runtime:runtime-livedata:1.1.0-beta02")
    // Lifecycle
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    // Coil Library for image loading
    implementation("io.coil-kt:coil-compose:1.3.2")
    // Pager for Compose
    implementation("com.google.accompanist:accompanist-pager:0.13.0")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.13.0")

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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.5"
    }
}