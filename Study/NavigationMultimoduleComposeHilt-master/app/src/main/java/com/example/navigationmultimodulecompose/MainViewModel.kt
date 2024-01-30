package com.example.navigationmultimodulecompose

import androidx.lifecycle.ViewModel
import com.example.homeapi.HomeFeatureApi
import com.example.settingsapi.SettingsFeatureApi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() :ViewModel(){

    @Inject
    lateinit var homeFeatureApi: HomeFeatureApi

    @Inject
    lateinit var settingsFeatureApi: SettingsFeatureApi

}