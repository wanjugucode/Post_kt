package com.example.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class ViewCommentActivity : AppCompatActivity() {
    lateinit var rvComment:RecyclerView
    lateinit var tvName: TextView
    lateinit var tvEmail:TextView
    lateinit var tvCommentbody:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_comment)



    }
    fun castView(){
    tvName.findViewById<TextView>(R.id.tvName)
        tvCommentbody.findViewById<TextView>(R.id.tvCommentBody)

    }
    fun getComment(){
        val retrofit=ApiClient.buildService(ApiInterface::class.java)
        val request=retrofit.getComments("comment")
        request.enqueue(object :Callback<Comment> {
            override fun onResponse(call: Call<Comment>, response: Response<Comment>) {
                if (response.isSuccessful){
                    val commentList=response.body()
                if (commentList!=null){
                    val commentsAdapter=commentRvAdapter(commentList,baseContext)
                    rvComment.findViewById<RecyclerView>(R.id.rvComments)
                    rvComment.layoutManager=LinearLayoutManager(baseContext)
                    rvComment.adapter=commentsAdapter
                }
                }

            }

            override fun onFailure(call: Call<Comment>, t: Throwable) {

            }

        })
    }

}