package com.example.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rvPost: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchApi()
    }
    fun fetchApi(){
        val retrofit=ApiClient.buildService(ApiInterface::class.java)
        val request=retrofit.getPosts()
        request.enqueue(object : Callback<List<Post>>
        {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
               if (response.isSuccessful){
                   val postList=response.body()!!
                    rvPost=findViewById(R.id.rvPost)
                   rvPost.layoutManager=LinearLayoutManager(baseContext)
                   val postAdapter=PostRvAdapter(baseContext,postList)
                   rvPost.adapter=postAdapter
                   Toast.makeText(baseContext, postList.size.toString(),Toast.LENGTH_LONG).show()
               }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
             Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
}
































