package com.example.post

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class commentRvAdapter(var commentList:List<Post>):RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
       var itemView=LayoutInflater.from(parent.context).inflate(R.layout.post_list_items,parent,false)
        return CommentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentPost=commentList.get(position)
        holder.tvName.text=currentPost.name
        holder.tvEmail.text=currentPost.email
        holder.tvCommentBody.text=currentPost.commentBody


    }

    override fun getItemCount(): Int {
      return commentList.size
    }
}
class CommentViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var cvComments=itemView.findViewById<CardView>(R.id.cvComments)
    var tvName=itemView.findViewById<TextView>(R.id.tvName)
    var tvEmail=itemView.findViewById<TextView>(R.id.tvEmail)
    var tvCommentBody=itemView.findViewById<TextView>(R.id.tvCommentBody)
}