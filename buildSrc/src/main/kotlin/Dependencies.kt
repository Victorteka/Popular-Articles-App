object Versions {
    // Material and androidX
    const val material = "1.4.0"
    const val appCompat = "1.3.0-alpha02"
    const val constraintLayout = "2.0.1"

    // Kotlin
    const val kotlinVersion = "1.5.20"
    const val coreKtx = "1.6.0"

    //Navigation
    const val navigationVersion = "2.3.5"

    //retrofit
    const val retrofit = "2.9.0"

    //OkHttp
    const val okhttp = "4.9.1"

    //Glide
    const val glide = "4.12.0"

    //Hilt
    const val hilt_version = "2.37"

    //Livedata
    const val livedata = "2.3.1"

    //

    // Room db
    const val room_version = "2.3.0"

    // Lifecycle
    const val lifecycle = "2.3.0-alpha07"

    // Coroutines
    const val coroutines = "1.3.9"
    const val coroutinesAndroid = "1.5.0"

    // Logging - debug builds
    const val timber = "4.7.1"
    const val leakCanary = "2.4"

    // tests
    const val junit = "4.+"
    const val espresso = "3.4.0"
    const val androidXJUnit = "1.1.3"
}

object BuildPlugins {
    //All the build plugins are added here
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val kotlinAndroidExtensions = "org.jetbrains.kotlin.android.extensions"
    const val androidLibrary = "com.android.library"
    const val kapt = "kotlin-kapt"
}

object Libraries {
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val coreKtx = "androidx.test.ext:junit:${Versions.androidXJUnit}"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.livedata}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.livedata}"
    const val glideProcessor = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt_version}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt_version}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room_version}"
    const val roomAndroid = "androidx.room:room-ktx:${Versions.room_version}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room_version}"
    const val retrofitLib = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttpLib = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val androidNav = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
}

object TestingLibraries {
    const val jUnit = "junit:junit:${Versions.junit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val androidXJUnit = "androidx.test.ext:junit:${Versions.androidXJUnit}"
}

object BuildModules {
    const val coreModule = ":core"
    const val dataModule = ":data"
    const val domainModule = ":domain"
}