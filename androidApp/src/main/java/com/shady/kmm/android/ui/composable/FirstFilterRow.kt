package com.shady.kmm.android.ui.composable

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.shady.kmm.android.ui.composable.component.GridView
import com.shady.kmm.entity.MainScreenList

@Composable
fun FirstFilterRow(data: MainScreenList) {
    GridView(cols = data.row_count, list = data.data, rowModifier = Modifier.fillMaxWidth().background(color = Color(240, 240, 240, 255))) {
        Column(modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Surface(contentColor = Color(0xFFFFFFFF),
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
                    .padding(4.dp),
                shape = CircleShape,
                elevation = 8.dp,) {
                Image(painter = rememberImagePainter(data = it.image),
                    contentDescription = it.name,
                    modifier = Modifier
                        .height(40.dp)
                        .padding(16.dp)
                )
            }

            Text(text = it.name!!, style = typography.caption)
        }
    }
}