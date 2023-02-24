package ro.alexmamo.recognizetextinimages.presentation.components

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp

@Composable
fun ImageContent(
    bitmap: Bitmap
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            modifier = Modifier.padding(
                top = 32.dp,
                start = 16.dp,
                end = 16.dp
            ),
            bitmap = bitmap.asImageBitmap(),
            contentDescription = null
        )
    }
}