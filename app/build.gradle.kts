plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    id("kotlin-kapt")

    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")

    id("kotlin-android")
    id("com.apollographql.apollo3").version("3.7.3")
}

apollo {
    service("service") {
        packageName.set("com.curiousapps")
    }
}


kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        release {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}
android {
    namespace = "com.curiousapps.calorie"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.curiousapps.calorie"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.manifest)
    coreLibraryDesugaring (libs.android.tools.desugar)

    //Apollo GraphQL
    implementation(libs.apollo.graph.ql)

    // OpenCSV
    implementation (libs.opencsv)

    // Compose dependencies
    implementation (libs.androidx.material.icons)
    implementation (libs.google.accompanist.flow)
    implementation (libs.google.accompanist.swipe)
    implementation(libs.androidx.lifecycle.runtime.compose.v270)
    implementation(libs.androidx.lifecycle.viewmodel.compose.v270)

    // Compose Nav Destinations
    implementation (libs.raamcosta.destinations.core)
    ksp (libs.raamcosta.destinations.ksp)

    // Coil Compose
    implementation(libs.coil.kt)

    // Dagger - Hilt
    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.android.compiler)
    kapt(libs.androidx.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
    //implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")

    // Paging
    implementation(libs.androidx.paging.runtime.ktx)
    implementation(libs.androidx.paging.compose)

    // Retrofit
    implementation(libs.retrofit2.retrofit)
    implementation(libs.retrofit2.converter.moshi)
    implementation(libs.retrofit2.converter.gson)
    implementation (libs.okhttp3.okhttp)
    implementation(libs.okhttp3.logging)

    // Room

    implementation (libs.xerial)
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler.ksp)
}

kapt{
    correctErrorTypes = true
}