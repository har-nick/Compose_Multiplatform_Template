import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import uk.co.harnick.composemptemplate.core.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Bulwark",
        state = rememberWindowState(width = 1400.dp, height = 800.dp)
    ) {
        App()
    }
}
