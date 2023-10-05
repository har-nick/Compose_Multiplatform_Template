package uk.co.harnick.composemptemplate.core.ui.theme

import android.app.Activity
import android.graphics.Color
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
actual fun ExampleTheme(content: @Composable () -> Unit) {
    val view = LocalView.current
    val window = (view.context as Activity).window

    window.statusBarColor = Color.TRANSPARENT
    window.navigationBarColor = Color.TRANSPARENT

    WindowCompat.setDecorFitsSystemWindows(window, false)
    WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = isSystemInDarkTheme()

    MaterialTheme { content() }
}
