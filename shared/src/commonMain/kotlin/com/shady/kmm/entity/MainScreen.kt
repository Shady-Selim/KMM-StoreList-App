package com.shady.kmm.entity

import kotlinx.serialization.Serializable

@Serializable
data class MainScreen(
    val result : List<MainScreenList>,
   // val other : Other,
    val message : String,
    val status : Boolean
)
