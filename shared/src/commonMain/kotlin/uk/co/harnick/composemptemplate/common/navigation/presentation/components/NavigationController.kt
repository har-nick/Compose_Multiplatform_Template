package uk.co.harnick.composemptemplate.common.navigation.presentation.components

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import uk.co.harnick.composemptemplate.common.navigation.domain.Screens.Screen1
import uk.co.harnick.composemptemplate.features.example.domain.ExampleScreenParams

@Composable
fun NavigationController() {
    Navigator(screen = Screen1.screenProvider(ExampleScreenParams())) { navigator ->
        NavigationComponent {
            FadeTransition(navigator) { screen -> screen.Content() }
        }
    }
}
