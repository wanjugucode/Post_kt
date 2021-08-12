package com.example.post

import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
        @GET("post")
        fun getPosts(): Call<List<Post>>
        @GET("posts/{id}")//placeholder is id
        fun getPostById(@Path("id")postId:Int):Call<Post>
        @GET("post/comments")
        fun getComments(@Path("Comments")comment: String):Call<Comment>

        }