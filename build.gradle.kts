plugins {
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.compose.multiplatform).apply(false)
    alias(libs.plugins.i18n4k).apply(false)
    alias(libs.plugins.kotlin.android).apply(false)
    alias(libs.plugins.kotlin.multiplatform).apply(false)
    alias(libs.plugins.sqldelight).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
