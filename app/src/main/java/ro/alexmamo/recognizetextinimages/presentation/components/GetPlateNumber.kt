package ro.alexmamo.recognizetextinimages.presentation.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.recognizetextinimages.components.ProgressBar
import ro.alexmamo.recognizetextinimages.core.Utils.Companion.print
import ro.alexmamo.recognizetextinimages.domain.model.Response.*
import ro.alexmamo.recognizetextinimages.presentation.PlateNumberViewModel

@Composable
fun GetPlateNumber(
    viewModel: PlateNumberViewModel = hiltViewModel(),
    showNumber: @Composable (number: String) -> Unit
) {
    when(val plateNumberResponse = viewModel.plateNumberResponse) {
        is Loading -> ProgressBar()
        is Success -> plateNumberResponse.data?.let { plateNumber ->
            showNumber(plateNumber)
        }
        is Failure -> print(plateNumberResponse.e)
    }
}