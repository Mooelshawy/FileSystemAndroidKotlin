package com.omran.accesssystemfile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.omran.accesssystemfile.R
import com.omran.accesssystemfile.model.DataModelElement
import java.util.*

class PostAdapter(private val context : Context) : RecyclerView.Adapter<PostAdapter.PostHolder>(){


    var PostArrayList = ArrayList<DataModelElement>()

    var ItemPostionInList = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val  view : View = LayoutInflater.from(context).inflate(R.layout.post_item , parent , false)
        return  PostHolder(view)
    }

    override fun getItemCount(): Int {
        return PostArrayList.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        ItemPostionInList = position
        val data = PostArrayList[position]
        holder.titleTextView.text = data.title
    }

    class PostHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var titleTextView : TextView

        init {
            titleTextView = itemView.findViewById(R.id.title)
        }
    }



}