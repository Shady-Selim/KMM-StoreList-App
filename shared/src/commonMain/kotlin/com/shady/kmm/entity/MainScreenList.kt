package com.shady.kmm.entity

import kotlinx.serialization.Serializable

@Serializable
data class MainScreenList (
    val id : Int,
    val title : String,
    val subtitle : String,
    val data : List<DataModel>,
    val data_type : String,
    val show_title : Boolean,
    val ui_type : String,
    val row_count : Int,
    val show_more_enabled : Boolean,
    val excluded_business_segments : List<String>
)
