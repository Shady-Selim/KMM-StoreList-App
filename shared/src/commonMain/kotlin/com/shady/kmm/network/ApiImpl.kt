package com.shady.kmm.network

import com.shady.kmm.entity.Banners
import com.shady.kmm.entity.MainScreen
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.*
import io.ktor.http.*

class ApiImpl: Api {
    private val httpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
                coerceInputValues = true
            })//
        }
    }

    override suspend fun getMainScreenData(baseUrl: String, token: String): MainScreen {
        return httpClient.get("${baseUrl}baskets/76097/catalog"){
            headers {
                append("Device-Type", "android")
                append("App-Version", "3.1.1.0.0")
                append(HttpHeaders.Authorization, token)
                append(HttpHeaders.AcceptLanguage, "en")
            }
        }
    }


    override suspend fun getBanners(baseUrl: String, token: String): Banners {
        return httpClient.get("${baseUrl}v2.5.1/baskets/76097/banners"){
            headers {
                append("Device-Type", "android")
                append("App-Version", "3.1.1.0.0")
                append(HttpHeaders.Authorization, token)
                append(HttpHeaders.AcceptLanguage, "en")
            }
        }
    }

    /*companion object {
        private const val BASE_URL = ""
    }*/
}