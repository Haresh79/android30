package com.example.smartygadgets

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/products")
    fun getGadgets(): Call<gadgets>
}
