package uk.co.harnick.composemptemplate.core.ui.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
actual fun ExampleTheme(content: @Composable () -> Unit) {
    MaterialTheme { content() }
}
