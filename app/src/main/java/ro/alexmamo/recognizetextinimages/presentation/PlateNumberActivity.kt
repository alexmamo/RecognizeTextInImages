package ro.alexmamo.recognizetextinimages.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import ro.alexmamo.recognizetextinimages.presentation.components.PlateNumberScreen

@AndroidEntryPoint
class PlateNumberActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlateNumberScreen()
        }
    }
}