package com.example.navigationmultimodulecompose.di

import com.example.homeapi.HomeFeatureApi
import com.example.homeimpl.navigation.HomeFeatureImpl
import com.example.settingsapi.SettingsFeatureApi
import com.example.settingsimpl.navigation.SettingsFeatureImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MainModule {
    @Binds
    abstract fun homeImpl(homeFeatureImpl: HomeFeatureImpl): HomeFeatureApi

    @Binds
    abstract fun settingsImpl(settingsFeatureImpl: SettingsFeatureImpl): SettingsFeatureApi


}