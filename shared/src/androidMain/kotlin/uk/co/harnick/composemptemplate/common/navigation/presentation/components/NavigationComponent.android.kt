package uk.co.harnick.composemptemplate.common.navigation.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Companion.Compact
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import uk.co.harnick.composemptemplate.common.navigation.presentation.components.drawer.NavDrawer
import uk.co.harnick.composemptemplate.common.navigation.presentation.components.rail.NavRail

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
actual fun NavigationComponent(content: @Composable () -> Unit) {
    val windowWidth = calculateWindowSizeClass().widthSizeClass

    if (windowWidth == Compact) {
        NavDrawer(content)
    } else {
        Row {
            NavRail()
            content()
        }
    }
}
