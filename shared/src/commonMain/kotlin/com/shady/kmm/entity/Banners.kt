package com.shady.kmm.entity

import kotlinx.serialization.Serializable

@Serializable
data class Banners(
    val result : List<BannersList>,
    val status : Boolean
)
