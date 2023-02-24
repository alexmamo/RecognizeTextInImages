package ro.alexmamo.recognizetextinimages.domain.repository

import com.google.mlkit.vision.common.InputImage
import ro.alexmamo.recognizetextinimages.domain.model.Response

typealias PlateNumberResponse = Response<String>

interface PlateNumberRepository {
    suspend fun getPlateNumber(image: InputImage): PlateNumberResponse
}