package com.reift.core.domain.model.detail

import com.google.gson.annotations.SerializedName

data class Video(
    val name: String,
    val official: Boolean,
    val id: String,
    val key: String
)
