package com.example.a1119retrofitmvvm.View

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a1119retrofitmvvm.Model.Users
import com.example.a1119retrofitmvvm.R
import kotlinx.android.synthetic.main.row_adapter.view.*

class MyAdapter (var mContext:Context , var mList:ArrayList<Users>):RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_adapter, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var users = mList[position]
        holder.bind(users)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setData(l:ArrayList<Users>){
        mList =l
        notifyDataSetChanged()
    }


    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun bind(users:Users){
            itemView.text_view_names.text = users.name
        }
    }
}