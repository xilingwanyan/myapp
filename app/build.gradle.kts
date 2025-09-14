plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.myapp"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.example.myapp"
        minSdk = 28
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        vectorDrawables { useSupportLibrary = true }

    }
    signingConfigs {
        create("release") {
            storeFile = file("${key.release}") // 密钥库路径
            storePassword = "${key.release.password}" // 密钥库密码
            keyAlias = "${key.release.alias}" // 密钥别名
            keyPassword = "${key.release.password}" // 密钥密码（与storePassword相同）
            enableV1Signing = false
            enableV2Signing = true
            enableV3Signing = true
        }
        create("debugs") {
            storeFile = file("${key.debug}") // 密钥库路径
            storePassword = "${key.debug.password}" // 密钥库密码
            keyAlias = "${key.debug.alias}" // 密钥别名
            keyPassword = "${key.debug.password}" // 密钥密码（与storePassword相同）
            enableV1Signing = false
            enableV2Signing = true
            enableV3Signing = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = true
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
            
        }
        debug {
            signingConfig = signingConfigs.getByName("debugs")
            isMinifyEnabled = false 
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
        }
    }

    buildFeatures { compose = true }
    composeOptions {
        // kotlinCompilerExtensionVersion = "1.5.15"
    }
    packaging { resources { excludes += "/META-INF/{AL2.0,LGPL2.1}" } }
}

/*tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "17"
}*/
kotlin { compilerOptions { jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17) } }

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.2.10")
    implementation("androidx.appcompat:appcompat:1.7.1")

    implementation(platform("androidx.compose:compose-bom:2025.08.00"))

    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.ui:ui")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.activity:activity-compose:1.10.1")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.2")
    implementation("androidx.core:core-ktx:1.16.0")
}
