package ro.alexmamo.recognizetextinimages.di

import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizer
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ro.alexmamo.recognizetextinimages.data.repository.PlateNumberRepositoryImpl
import ro.alexmamo.recognizetextinimages.domain.repository.PlateNumberRepository

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideTextRecognizer() = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

    @Provides
    fun provideImageRepository(
        recognizer: TextRecognizer
    ): PlateNumberRepository = PlateNumberRepositoryImpl(
        recognizer = recognizer
    )
}