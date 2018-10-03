plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(27)
    buildToolsVersion = "27.0.3"
    defaultConfig {
        applicationId = "com.pvasilev.uplabs"
        minSdkVersion(23)
        targetSdkVersion(27)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jre7:1.2.60")
    implementation("com.android.support:appcompat-v7:27.1.1")
    implementation("com.android.support:cardview-v7:27.1.1")
    implementation("com.android.support.constraint:constraint-layout:1.1.3")
    implementation("io.reactivex.rxjava2:rxjava:2.2.2")
    implementation("io.reactivex.rxjava2:rxkotlin:2.2.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.0")
    implementation("com.jakewharton.rxbinding2:rxbinding-kotlin:2.1.1")
    implementation("com.jakewharton.rxbinding2:rxbinding-support-v4-kotlin:2.1.1")
    implementation("com.jakewharton.rxbinding2:rxbinding-design-kotlin:2.1.1")
    implementation("com.squareup.retrofit2:retrofit:2.4.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.4.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.4.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.7.0")
    implementation("com.squareup.okhttp3:logging-interceptor:3.11.0")
    implementation("com.github.stephanenicolas.toothpick:toothpick-runtime:1.1.3")
    implementation("com.github.stephanenicolas.toothpick:smoothie:1.1.3")
    kapt("com.github.stephanenicolas.toothpick:toothpick-compiler:1.1.3")
    implementation("android.arch.lifecycle:viewmodel:1.1.1")
    implementation("android.arch.lifecycle:extensions:1.1.1")
    implementation("ru.terrakok.cicerone:cicerone:3.0.0")
    implementation("com.jakewharton.timber:timber:4.7.1")
    implementation("com.jakewharton.threetenabp:threetenabp:1.1.0")
    implementation("com.github.bumptech.glide:glide:4.8.0")
    implementation("de.hdodenhof:circleimageview:2.2.0")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")
}

configurations.all {
    resolutionStrategy {
        force("com.android.support:design:27.1.1")
    }
}



