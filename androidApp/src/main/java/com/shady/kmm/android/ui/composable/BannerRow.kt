package com.shady.kmm.android.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.shady.kmm.android.ui.composable.component.GridView
import com.shady.kmm.entity.MainScreenList

@Composable
fun BannerRow(data: MainScreenList) {
    GridView(cols = data.row_count, list = data.data, rowModifier = Modifier.fillMaxWidth()) {
        Image(painter = rememberImagePainter(data = it.image),
            contentDescription = it.image,
            modifier = Modifier.height(100.dp),
            contentScale = ContentScale.Fit,
        )
    }
}