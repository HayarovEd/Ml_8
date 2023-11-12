package com.zaim.metr.dokm.domzaem.domain.model.basedto


import com.google.gson.annotations.SerializedName

data class BaseDto(
    @SerializedName("app_config")
    val appConfig: AppConfig,
    @SerializedName("loans")
    val loans: List<Loan> = emptyList()
)