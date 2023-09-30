package uk.co.harnick.composemptemplate.common.navigation.presentation.components.rail

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uk.co.harnick.composemptemplate.common.navigation.domain.ScreenParams
import uk.co.harnick.composemptemplate.common.navigation.domain.Screens

@Composable
fun <T : Screen, S : ScreenParams> Screens<T, S>.toNavRailItem(
    params: S,
    modifier: Modifier = Modifier
) {
    val navigator = LocalNavigator.currentOrThrow

    val isSelected by mutableStateOf(label == navigator.lastItem.key)
    val imageVector by derivedStateOf { if (isSelected) activeIcon else inactiveIcon }

    NavigationRailItem(
        selected = isSelected,
        onClick = { navigator.replaceAll(screenProvider(params)) },
        modifier = modifier,
        icon = { Icon(imageVector = imageVector, contentDescription = null) },
        label = { Text(label) },
        alwaysShowLabel = false
    )
}
