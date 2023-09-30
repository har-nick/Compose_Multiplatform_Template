package uk.co.harnick.composemptemplate.common.navigation.presentation.components

import androidx.compose.runtime.Composable

@Composable
expect fun NavigationComponent(content: @Composable () -> Unit)
