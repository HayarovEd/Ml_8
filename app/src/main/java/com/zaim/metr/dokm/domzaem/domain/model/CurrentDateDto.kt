package com.zaim.metr.dokm.domzaem.domain.model

import com.google.gson.annotations.SerializedName

data class CurrentDateDto (
    @SerializedName("date")
    val date: String
)