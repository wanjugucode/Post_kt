package com.example.post

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
        @GET("post")
        fun getPosts(): Call<List<Post>>
}