package uk.co.harnick.composemptemplate.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
actual fun exampleTheme(content: @Composable () -> Unit) {
    MaterialTheme { content() }
}
