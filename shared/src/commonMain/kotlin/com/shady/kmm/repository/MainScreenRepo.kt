package com.shady.kmm.repository

import com.shady.kmm.dummyData.BannerData
import com.shady.kmm.entity.BannersList
import com.shady.kmm.entity.MainScreenList
import com.shady.kmm.network.ApiImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainScreenRepo {
    suspend fun getMainScreenData(baseUrl: String, token: String) = withContext(Dispatchers.Default) {
        val response = ApiImpl().getMainScreenData(baseUrl, token)
        if (response.message == "fetched successfully")
            response.result
        else
            emptyList<MainScreenList>()
    }

    suspend fun getBanners(baseUrl: String, token: String) = withContext(Dispatchers.Default) {
        val response = ApiImpl().getBanners(baseUrl, token)
        if (response.status && response.result.isNotEmpty())
            response.result
        else
            BannerData.getDummyBanners()
    }
}