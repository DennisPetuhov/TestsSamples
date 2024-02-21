package com.example.tests

import com.example.tests.api.BankInfoApi
import com.example.tests.api.ProductsRepository
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.inject.Inject
import javax.inject.Named


@HiltAndroidTest
class BankInfoApiTest {
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

//    @get:Rule(order = 1)
//    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Inject
    @Named("test_api")
    lateinit var bankInfoApi: BankInfoApi

    @Inject
    lateinit var repository: ProductsRepository
    private val gson = GsonBuilder()
        .serializeNulls()
        .setLenient()
        .create()

    @BeforeEach
    fun setUp() {
        hiltRule.inject()
        repository
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun getCards() {

        val response = runBlocking { bankInfoApi.getCards() }
//        val response = runBlocking { repository.fetchCards() }
        println("@@@@@@@@@@@@@@@@@@@@@@2" + response)
        val json = gson.toJson(response)
        val resultResponse = JsonParser.parseString(json)
//        val expectedResponse = JsonParser.parseString(mockedResponse)
//        println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
//                +resultResponse)
//        println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+expectedResponse)
//        Assert.assertNotNull(resultResponse)
//        Assert.assertEquals(resultResponse, expectedResponse)
    }
}