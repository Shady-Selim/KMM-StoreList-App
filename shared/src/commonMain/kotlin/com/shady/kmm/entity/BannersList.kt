package com.shady.kmm.entity

import kotlinx.serialization.Serializable

@Serializable
data class BannersList (
    val id : Int,
    val title : String,
    val description : String,
    val button_text : String,
    val expiry_status : Boolean,
    val created_at : String,
    val start_date : String,
    val expiry_date : String,
    val image : String,
    val priority : Int,
    val photo : String,
    val link : String,
    val level : String,
    val is_available : Boolean,
    val branch : Int? = 0
)
