package uk.co.harnick.composemptemplate.features.example.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import uk.co.harnick.composemptemplate.features.example.domain.ExampleScreenParams

data class ExampleScreen(
    override val key: ScreenKey,
    val params: ExampleScreenParams
) : Screen {
    @Composable
    override fun Content() {
        val exampleVM = rememberScreenModel { ExampleViewModel() }
        val state by exampleVM.state.collectAsState()

        Scaffold { scaffoldPadding ->
            Column(
                Modifier
                    .padding(scaffoldPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
            ) {
                Text(key)
                Text(params.greetingText)
            }
        }
    }
}
