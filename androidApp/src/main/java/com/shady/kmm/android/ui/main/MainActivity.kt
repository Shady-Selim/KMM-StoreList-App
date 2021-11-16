package com.shady.kmm.android.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.shady.kmm.android.ui.composable.BannerRow
import com.shady.kmm.android.ui.composable.DrawBanner
import com.shady.kmm.android.ui.composable.FirstFilterRow
import com.shady.kmm.android.ui.composable.SectionRow
import com.shady.kmm.entity.MainScreenList
import com.shady.ourfirstcompose.ui.theme.StoreComposeTheme

class MainActivity : AppCompatActivity() {
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StoreComposeTheme {
                MyApp()
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
private fun MyApp(vm: MainViewModel = viewModel()) {
    val banners by vm.getBanners().observeAsState()
    val mainScreenData by vm.getMainScreenData().observeAsState()
    val context = LocalContext.current
    Column(Modifier.verticalScroll(state = ScrollState(0),enabled = true)) {
        DrawBanner(banners, context)
        DrawMainScreen(mainScreenData)
    }
}

@Composable
fun DrawMainScreen(mainScreenData: List<MainScreenList>?){
    mainScreenData?.forEach {
         when(it.data_type){
            "smart" -> FirstFilterRow(it)
            "group" -> SectionRow(it)
            "banner" -> BannerRow(it)
            else -> Text(text = "")
        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StoreComposeTheme {
        MyApp()
    }
}
