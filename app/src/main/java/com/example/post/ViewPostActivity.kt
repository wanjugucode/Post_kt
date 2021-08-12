package com.example.post

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.post.databinding.ActivityViewPostBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewPostActivity : AppCompatActivity() {
    var postId=0
    lateinit var binding:ActivityViewPostBinding //finding view by id
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding= ActivityViewPostBinding.inflate(layoutInflater)
        postId=intent.getIntExtra("POST_Id",0)
        setSupportActionBar(binding.toolbar2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        getPost()

    }
    fun getPost(){
        val retrofit=ApiClient.buildService(ApiInterface::class.java)
        val request=retrofit.getPostById(postId)
        request.enqueue(object:Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
               if (response.isSuccessful){
        binding.tvPost.text=response.body()?.body
        binding.tvPostBody.text=response.body()?.body         //accessing without findViewById by view binding

                   }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {

            }

        })



    }
}