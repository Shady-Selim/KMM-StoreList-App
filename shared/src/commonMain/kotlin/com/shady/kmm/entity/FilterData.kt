package com.shady.kmm.entity

import kotlinx.serialization.Serializable

@Serializable
data class FilterData (
    val filter_id: Int,
    val name: String
)