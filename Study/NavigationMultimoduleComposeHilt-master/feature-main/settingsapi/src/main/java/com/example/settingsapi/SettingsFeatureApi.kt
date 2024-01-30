package com.example.settingsapi


import com.example.feature_api.FeatureApi

interface SettingsFeatureApi: FeatureApi {

    val settingsRoute: String
}