package ro.alexmamo.recognizetextinimages.data.repository

import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognizer
import kotlinx.coroutines.tasks.await
import ro.alexmamo.recognizetextinimages.domain.model.Response.Failure
import ro.alexmamo.recognizetextinimages.domain.model.Response.Success
import ro.alexmamo.recognizetextinimages.domain.repository.PlateNumberRepository
import ro.alexmamo.recognizetextinimages.domain.repository.PlateNumberResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlateNumberRepositoryImpl @Inject constructor(
    private val recognizer: TextRecognizer
): PlateNumberRepository {
    override suspend fun getPlateNumber(image: InputImage): PlateNumberResponse {
        return try {
            val text = recognizer.process(image).await().text
            Success(text)
        } catch (e: Exception) {
            Failure(e)
        }
    }
}