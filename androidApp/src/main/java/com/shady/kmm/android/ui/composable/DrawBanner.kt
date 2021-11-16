package com.shady.kmm.android.ui.composable

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.*
import com.shady.kmm.entity.BannersList
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@ExperimentalPagerApi
@Composable
fun DrawBanner(banners: List<BannersList>?, context: Context) {
    if (!banners.isNullOrEmpty()){
        val pagerState = rememberPagerState(pageCount = banners.size)

        LaunchedEffect(Unit){
            while (true){
                yield()
                delay(2000)
                pagerState.animateScrollToPage(
                    page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                    animationSpec = tween(600)
                )
            }
        }
        Box(modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(20.dp))) {
            HorizontalPager(state = pagerState) { page ->
                val banner = banners[page]

                Image(painter = rememberImagePainter(data = banner.image),
                    contentDescription = banner.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .clickable {
                            Toast
                                .makeText(context, banner.link, Toast.LENGTH_LONG)
                                .show()
                        },
                    contentScale = ContentScale.Crop)
            }

            HorizontalPagerIndicator(pagerState = pagerState, modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp), activeColor = Color.White)
        }
    } else {
        Column(modifier = Modifier.height(800.dp).width(600.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = "loading ....", )
        }
    }
}