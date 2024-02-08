package uk.co.harnick.composemptemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import uk.co.harnick.composemptemplate.core.App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { App() }
    }
}
