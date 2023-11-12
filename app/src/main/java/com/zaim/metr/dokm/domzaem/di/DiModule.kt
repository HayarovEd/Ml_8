package com.zaim.metr.dokm.domzaem.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.zaim.metr.dokm.domzaem.data.RepositoryAnalyticImpl
import com.zaim.metr.dokm.domzaem.data.RepositoryServerImpl
import com.zaim.metr.dokm.domzaem.data.ServiceImpl
import com.zaim.metr.dokm.domzaem.data.SharedKeeperImpl
import com.zaim.metr.dokm.domzaem.domain.RepositoryAnalytic
import com.zaim.metr.dokm.domzaem.domain.RepositoryServer
import com.zaim.metr.dokm.domzaem.domain.Service
import com.zaim.metr.dokm.domzaem.domain.SharedKepper
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule {

    @Binds
    @Singleton
    abstract fun bindService(service: ServiceImpl): Service

    @Binds
    @Singleton
    abstract fun bindKeeper(sharedKeeper: SharedKeeperImpl): SharedKepper

    @Binds
    @Singleton
    abstract fun bindRepositoryAnalytic(repository: RepositoryAnalyticImpl): RepositoryAnalytic

    @Binds
    @Singleton
    abstract fun bindRepositoryServer(repository: RepositoryServerImpl): RepositoryServer

}