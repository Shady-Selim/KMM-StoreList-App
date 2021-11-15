package com.shady.kmm.android.ui.composable.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import com.shady.kmm.entity.DataModel

@Composable
fun VerticalGrid(
    nColumns: Int,
    scope: MutableList<Unit>,
    modifier: Modifier = Modifier,
    child: @Composable (dataModal: Unit) -> Unit
) {
    val rows = (scope.size + nColumns - 1) / nColumns
    Column(
        modifier = modifier
    ) {
        repeat(rows) { rowIndex ->
            Row(modifier = Modifier.background(Color.Green)) {
                for (columnIndex in 0 until nColumns) {
                    val itemIndex = rowIndex * nColumns + columnIndex
                    if (itemIndex < scope.size) {
                        Box(
                            modifier = Modifier.background(Color.Blue)
                                .weight(1f, fill = true)
                                ,
                            propagateMinConstraints = true
                        ) {
                            //Text(text = itemIndex.toString())
                            /*Surface(modifier = Modifier.background(Color.Red)) {
                                scope[itemIndex]
                            }*/

                        }
                    } else {
                        Spacer(Modifier.weight(1f, fill = true))
                    }
                }
            }
        }
    }
}