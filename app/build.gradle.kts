plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.ksp)
}

android {
    namespace = "com.alfajar.myapp12"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.alfajar.myapp12"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.firestore)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.androidx.ui)  // Sesuaikan dengan versi plugin Compose yang kamu pakai
    implementation (libs.androidx.material)
    implementation (libs.androidx.ui.tooling.preview)
    implementation(libs.firebase.analytics)
    implementation(platform(libs.firebase.bom))

    // Room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler.v261)
    implementation(libs.androidx.room.ktx)
    ksp(libs.dagger.hilt.compiler)


// Coroutine
    implementation(libs.kotlinx.coroutines.android)
}