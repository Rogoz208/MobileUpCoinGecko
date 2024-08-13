package com.rogoz208.mobileupcoingecko.data.remote.dto

import kotlin.enums.EnumEntries

enum class Currency {
    USD, RUB
}

fun <T : Enum<T>> EnumEntries<T>.names() = this.map { it.name }