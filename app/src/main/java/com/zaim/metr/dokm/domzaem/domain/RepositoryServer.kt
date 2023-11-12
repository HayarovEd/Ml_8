package com.zaim.metr.dokm.domzaem.domain

import com.zaim.metr.dokm.domzaem.data.Resource
import com.zaim.metr.dokm.domzaem.domain.model.basedto.BaseDto

interface RepositoryServer {
    suspend fun getDataDb() : Resource<BaseDto>
}