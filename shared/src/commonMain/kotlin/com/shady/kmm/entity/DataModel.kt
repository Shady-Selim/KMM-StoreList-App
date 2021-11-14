package com.shady.kmm.entity

import kotlinx.serialization.Serializable

@Serializable
data class DataModel (
    val group_id : Int? = -1,
    val filters : List<FilterData>? = emptyList(),
    val name : String? = "",
    val image : String,
    val cover : String? = "",
    val deep_link : String? = ""
)
