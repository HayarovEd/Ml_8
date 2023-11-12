package com.zaim.metr.dokm.domzaem.data

import com.zaim.metr.dokm.domzaem.domain.model.basedto.BaseDto
import retrofit2.http.GET

interface ApiServer {
    @GET ("525/db.json")
    suspend fun getDataDb () : BaseDto
}