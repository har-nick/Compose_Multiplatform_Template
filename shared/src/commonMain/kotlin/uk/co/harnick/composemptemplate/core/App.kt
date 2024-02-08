package uk.co.harnick.composemptemplate.core

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import uk.co.harnick.composemptemplate.common.navigation.presentation.components.NavigationController
import uk.co.harnick.composemptemplate.core.ui.presentation.ExampleTheme

object App {
    @Composable
    operator fun invoke() {
        ExampleTheme {
            Scaffold { NavigationController() }
        }
    }
}
