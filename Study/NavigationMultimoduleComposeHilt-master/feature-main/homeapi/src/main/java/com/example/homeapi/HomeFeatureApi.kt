package com.example.homeapi


import com.example.feature_api.FeatureApi

interface HomeFeatureApi : FeatureApi {

    val homeRoute: String
}