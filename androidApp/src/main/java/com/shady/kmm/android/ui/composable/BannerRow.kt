package com.shady.kmm.android.ui.composable

import android.media.Image
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.shady.kmm.android.ui.composable.component.GridView
import com.shady.kmm.android.ui.composable.component.VerticalGrid
import com.shady.kmm.entity.MainScreenList

@ExperimentalFoundationApi
@Composable
fun BannerRow(data: MainScreenList) {
    /*val items = mutableListOf<Unit>()
    data.data.forEach {
        items.add(
            Image(painter = rememberImagePainter(data = it.image),
                contentDescription = it.image,
                modifier = Modifier.height(100.dp),
                contentScale = ContentScale.Fit,
                )
        )
    }
    VerticalGrid(nColumns = data.row_count, scope = items){
        Image(painter = rememberImagePainter(data = data.data[0].image),
            contentDescription = data.data[0].image,
            modifier = Modifier.height(200.dp),
            contentScale = ContentScale.Fit,
        )
    }*/
    GridView(cols = data.row_count, list = data.data, rowModifier = Modifier.fillMaxWidth()) {
        Image(painter = rememberImagePainter(data = it.image),
            contentDescription = it.image,
            modifier = Modifier.height(100.dp),
            contentScale = ContentScale.Fit,
        )
    }
}