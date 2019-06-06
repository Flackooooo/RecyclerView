package com.example.recycleview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.recyclerview.MainActivity
import com.example.recyclerview.R


import kotlinx.android.synthetic.main.fragment_item.view.*

class MyItemRecyclerViewAdapter(
    private val activity: MainActivity,
    private val mValues: ArrayList<HashMap<String, Any>>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        holder.mContentView.text = item.get("name").toString()
        holder.mPower.text = item.get("power").toString()
        holder.mGenger.text = item.get("gender").toString()
        Glide.with(activity).load(item["image"]).into(holder.mImage)
        holder.mView.setOnClickListener {
            Toast.makeText(activity, item.get("name").toString(), Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mContentView: TextView = mView.name
        val mGenger: TextView = mView.gender
        val mPower: TextView = mView.power
        val mImage: ImageView = mView.imageView
    }
}
