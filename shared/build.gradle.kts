import org.jetbrains.compose.desktop.application.dsl.TargetFormat.AppImage
import org.jetbrains.compose.desktop.application.dsl.TargetFormat.Exe

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.i18n4k)
    alias(libs.plugins.sqldelight)
}

kotlin {
    jvmToolchain(libs.versions.jdk.get().toInt())

    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = JavaVersion.toVersion(libs.versions.jdk.get()).majorVersion
        }
    }

    androidTarget {
        compilations.all {
            kotlinOptions.jvmTarget = JavaVersion.toVersion(libs.versions.jdk.get()).majorVersion
        }
    }

    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }

    // Put your debugImplementation dependencies here
    dependencies {
    }

    sourceSets {
        val desktopMain by getting

        commonMain.dependencies {
            implementation(libs.bundles.compose.multiplatform)
            implementation(libs.bundles.i18n4k)
            implementation(libs.bundles.voyager)

            implementation(libs.coroutines.core)
            implementation(libs.kamel)
            implementation(libs.sqldelight.coroutines)
            implementation(libs.windowsize)
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        androidMain.dependencies {
            dependencies {
                implementation(libs.androidx.compose.activity)
                implementation(libs.androidx.core.ktx)
                implementation(libs.coroutines.android)
                implementation(libs.sqldelight.driver.android)
            }
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.coroutines.jvm)
            implementation(libs.coroutines.swing)
            implementation(libs.sqldelight.driver.jvm)
        }
    }
}

android {
    namespace = "uk.co.harnick.composemptemplate"
    compileSdk = libs.versions.android.sdk.compile.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    buildFeatures.compose = true

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.android.get()
    }
    defaultConfig {
        applicationId = "uk.co.harnick.composemptemplate"
        minSdk = libs.versions.android.sdk.min.get().toInt()
        targetSdk = libs.versions.android.sdk.compile.get().toInt()
        versionCode = 1
        versionName = "0.1 - Alpha"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.jdk.get())
        targetCompatibility = JavaVersion.toVersion(libs.versions.jdk.get())
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1,versions/9/previous-compilation-data.bin}"
        }
    }
}

compose {
    kotlinCompilerPlugin = libs.versions.compose.compiler.jetbrains.get()

    desktop.application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(AppImage, Exe)
        }
    }
}

i18n4k {
    sourceCodeLocales = listOf("en")
}

sqldelight {
    databases {
        create("LocalStorage") {
            packageName.set("uk.co.harnick.ComposeMPTemplate")
        }
    }
}
