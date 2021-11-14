package com.shady.kmm.network

import com.shady.kmm.entity.Banners
import com.shady.kmm.entity.MainScreen

interface Api {
    suspend fun getMainScreenData(baseUrl: String, token: String): MainScreen

    suspend fun getBanners(baseUrl: String, token: String): Banners

}