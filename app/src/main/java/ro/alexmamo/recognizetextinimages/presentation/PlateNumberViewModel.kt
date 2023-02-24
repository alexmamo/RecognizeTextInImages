package ro.alexmamo.recognizetextinimages.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.mlkit.vision.common.InputImage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ro.alexmamo.recognizetextinimages.domain.model.Response
import ro.alexmamo.recognizetextinimages.domain.model.Response.Loading
import ro.alexmamo.recognizetextinimages.domain.model.Response.Success
import ro.alexmamo.recognizetextinimages.domain.repository.PlateNumberRepository
import javax.inject.Inject

@HiltViewModel
class PlateNumberViewModel @Inject constructor(
    private val repo: PlateNumberRepository
): ViewModel() {
    var plateNumberResponse by mutableStateOf<Response<String>>(Success(null))
        private set

    fun getPlateNumber(image: InputImage) = viewModelScope.launch {
        plateNumberResponse = Loading
        plateNumberResponse = repo.getPlateNumber(image)
    }
}