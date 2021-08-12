package com.example.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.post.databinding.ActivityMainBinding
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var binding: ActivityMainBinding
class ViewCommentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_comment)

    }
    fun getComment(){
        var retrofit=ApiClient.buildService(ApiInterface::class.java)
        var request=retrofit.getComments("comment")
        request.enqueue(object :Callback<Comment> {
            override fun onResponse(call: Call<Comment>, response: Response<Comment>) {
                if (response.isSuccessful){

                }

            }

            override fun onFailure(call: Call<Comment>, t: Throwable) {

            }

        })
    }

}