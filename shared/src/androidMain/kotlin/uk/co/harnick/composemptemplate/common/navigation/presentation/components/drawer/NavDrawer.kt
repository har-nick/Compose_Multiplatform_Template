package uk.co.harnick.composemptemplate.common.navigation.presentation.components.drawer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import uk.co.harnick.composemptemplate.common.navigation.domain.Screens.Screen1
import uk.co.harnick.composemptemplate.common.navigation.domain.Screens.Screen2
import uk.co.harnick.composemptemplate.features.example.domain.ExampleScreenParams

@Composable
fun NavDrawer(content: @Composable () -> Unit) {
    val drawerState = rememberDrawerState(initialValue = Closed)

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    Modifier
                        .width(300.dp)
                        .padding(horizontal = 12.dp)
                ) {
                    Screen1.toNavDrawerItem(ExampleScreenParams())
                    Screen2.toNavDrawerItem(ExampleScreenParams())
                }
            }
        },
        modifier = Modifier.zIndex(1F),
        drawerState = drawerState,
        content = content
    )
}
