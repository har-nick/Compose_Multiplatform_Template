import org.jetbrains.compose.desktop.application.dsl.TargetFormat.AppImage
import org.jetbrains.compose.desktop.application.dsl.TargetFormat.Exe
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.sqldelight)
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "17"
        }
    }

    androidTarget {
        compilations.all {
            kotlinOptions.jvmTarget = "17"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.bundles.compose.multiplatform)
                implementation(libs.bundles.voyager)

                implementation(libs.sqldelight.coroutines)
                implementation(libs.coroutines.core)
                implementation(libs.windowsize)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.core.ktx)
                implementation(libs.coroutines.android)
                implementation(libs.sqldelight.driver.android)
            }
        }
        val androidUnitTest by getting {
            dependencies {
                dependsOn(commonTest)
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(libs.coroutines.jvm)
                implementation(libs.coroutines.swing)
                implementation(libs.sqldelight.driver.jvm)
            }
        }
        val jvmTest by getting {
            dependencies {
                dependsOn(commonTest)
            }
        }
    }
}

android {
    namespace = "uk.co.harnick.composemptemplate"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

compose {
    desktop.application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(AppImage, Exe)
        }
    }
}

sqldelight {
    databases {
        create("LocalStorage") {
            packageName.set("uk.co.harnick.ComposeMPTemplate")
        }
    }
}
