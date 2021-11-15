package com.shady.kmm.android.ui.composable.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun <T> GridView(
    cols: Int = 1,
    list: List<T>,
    rowModifier: Modifier = Modifier,
    colModifier: Modifier = Modifier,
    child: @Composable (dataModal: T) -> Unit
) {

    val rows = (list.size / cols) + (if (list.size % cols > 0) 1 else 0)

    Column(modifier = colModifier) {

        for (r in 0 until rows) {
            Row(modifier = rowModifier, horizontalArrangement = Arrangement.SpaceAround) {
                for (cell in 0 until cols) {
                    val i = (r * cols) + cell
                    if (i < list.size) { child(list[i]) } else { break }
                }
            }
        }
    }

}