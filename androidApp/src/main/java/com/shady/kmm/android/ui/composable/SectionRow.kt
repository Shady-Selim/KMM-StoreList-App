package com.shady.kmm.android.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.shady.kmm.android.ui.composable.component.GridView
import com.shady.kmm.entity.MainScreenList

@Composable
fun SectionRow(data: MainScreenList) {
    Text(text = data.title, style = typography.h4, modifier = Modifier.padding(8.dp, 8.dp, 0.dp, 0.dp), fontWeight = FontWeight.Bold)
    GridView(cols = data.row_count, list = data.data, rowModifier = Modifier.fillMaxWidth()) {
        Image(painter = rememberImagePainter(data = it.image),
            contentDescription = it.image,
            modifier = Modifier.height(100.dp),
            contentScale = ContentScale.Fit,
        )
    }
}