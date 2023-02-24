package ro.alexmamo.recognizetextinimages.presentation.components

import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.mlkit.vision.common.InputImage
import ro.alexmamo.recognizetextinimages.core.Constants.ALL_IMAGES
import ro.alexmamo.recognizetextinimages.core.Constants.DEPRECATION
import ro.alexmamo.recognizetextinimages.presentation.PlateNumberViewModel

@Composable
fun PlateNumberScreen(
    viewModel: PlateNumberViewModel = hiltViewModel()
) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current

    val galleryLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
        imageUri = it
    }

    Scaffold(
        content = { padding ->
            PlateNumberContent(
                padding = padding,
                openGallery = {
                    galleryLauncher.launch(ALL_IMAGES)
                }
            )
            imageUri?.let { imageUri ->
                val resolver = context.contentResolver
                val bitmap = if (Build.VERSION.SDK_INT < 28) {
                    @Suppress(DEPRECATION)
                    MediaStore.Images.Media.getBitmap(resolver, imageUri)
                } else {
                    val source = ImageDecoder.createSource(resolver, imageUri)
                    ImageDecoder.decodeBitmap(source)
                }
                ImageContent(bitmap)
                val image = InputImage.fromBitmap(bitmap, 0)
                viewModel.getPlateNumber(image)
            }
            GetPlateNumber(
                showNumber = { plateNumber ->
                    PlateNumber(plateNumber)
                }
            )
        }
    )
}