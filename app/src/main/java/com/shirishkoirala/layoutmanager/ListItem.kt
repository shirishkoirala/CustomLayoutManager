package com.shirishkoirala.layoutmanager

import androidx.annotation.DrawableRes

data class ListItem(
    val id: Int,
    val name: String,
    val description: String,
    @DrawableRes val video: Int
)