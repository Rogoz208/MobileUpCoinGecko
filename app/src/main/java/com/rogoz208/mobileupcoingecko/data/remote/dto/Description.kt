package com.rogoz208.mobileupcoingecko.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Description(
    @SerializedName("en")
    val en: String,
    @SerializedName("ru")
    val ru: String
)