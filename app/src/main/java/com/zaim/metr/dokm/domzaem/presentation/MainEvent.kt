package com.zaim.metr.dokm.domzaem.presentation

import com.zaim.metr.dokm.domzaem.domain.model.StatusApplication
import com.zaim.metr.dokm.domzaem.domain.model.basedto.BaseState


sealed class MainEvent {
    object Reconnect: MainEvent()

    class OnChangeStatusApplication(val statusApplication: StatusApplication): MainEvent()
    class OnChangeBaseState(val baseState: BaseState): MainEvent()

    class OnGoToWeb(
        val urlOffer: String,
        val nameOffer: String
        ): MainEvent()
}
