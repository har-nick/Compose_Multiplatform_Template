package uk.co.harnick.composemptemplate.common.navigation.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import uk.co.harnick.composemptemplate.common.navigation.presentation.components.rail.NavRail

@Composable
actual fun NavigationComponent(content: @Composable () -> Unit) {
    Row {
        NavRail()
        content()
    }
}
