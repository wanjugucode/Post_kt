package com.example.post

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class commentRvAdapter(var commentList:List<Post>, var context: Context):RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
       var itemView=LayoutInflater.from(parent.context).inflate(R.layout.post_list_items,parent,false)
        return CommentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComment=commentList.get(position)
        holder.tvName.text=currentComment.name
        holder.tvEmail.text=currentComment.email
        holder.tvCommentBody.text=currentComment.commentBody
       holder.cvComments.setOnClickListener {
           var intent=Intent(context,ViewPostActivity::class.java)
           intent.putExtra("NAME",currentComment.name)
           intent.putExtra("EMAIL",currentComment.email)
           intent.putExtra("BODY",currentComment.commentBody)
           intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
           context.startActivity(intent)
       }

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