package com.zaim.metr.dokm.domzaem

import android.app.Application
import com.my.tracker.MyTracker
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import com.zaim.metr.dokm.domzaem.data.APP_METRICA
import com.zaim.metr.dokm.domzaem.data.MY_TRACKER
import com.zaim.metr.dokm.domzaem.data.USER_X
import dagger.hilt.android.HiltAndroidApp
import pro.userx.UserX

@HiltAndroidApp
class Ml8App: Application() {
    override fun onCreate() {
        super.onCreate()

        val config = YandexMetricaConfig.newConfigBuilder(APP_METRICA).build()


        MyTracker.initTracker(MY_TRACKER, this)
        YandexMetrica.activate(applicationContext, config)
        YandexMetrica.enableActivityAutoTracking(this)
        UserX.init(USER_X)
    }
}