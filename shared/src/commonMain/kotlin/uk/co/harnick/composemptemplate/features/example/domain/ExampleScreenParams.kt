package uk.co.harnick.composemptemplate.features.example.domain

import uk.co.harnick.composemptemplate.common.navigation.domain.ScreenParams

data class ExampleScreenParams(
    val greetingText: String = LocalisationExample.greeting()
) : ScreenParams
