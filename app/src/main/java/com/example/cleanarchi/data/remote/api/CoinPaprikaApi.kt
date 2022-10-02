package com.example.cleanarchi.data.remote.api

import com.example.cleanarchi.data.remote.dto.CoinDetailDto
import com.example.cleanarchi.data.remote.dto.CoinDto
import retrofit2.http.GET

interface CoinPaprikaApi {

    @GET("/v1/coins")
    fun getCoins() : List<CoinDto>

    @GET("/v1/coins/{coinId}")
    fun getCoinById(coinId : String) : CoinDetailDto

}