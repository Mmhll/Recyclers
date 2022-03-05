package com.example.myapplication.ui.grid_recycler

import android.app.AlertDialog
import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.myapplication.R

class GridRecyclerAdapter(val list : List<GridItem>, val context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image : ImageView = itemView.findViewById(R.id.recycler_image)
        val text : TextView = itemView.findViewById(R.id.recycler_text)
    }

    class AddItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.add_item_image)
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        return if (list.lastIndex < position){
            1
        } else
            0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            0 ->  return GridViewHolder(LayoutInflater.from(context).inflate(R.layout.grid_recycler_item, parent, false))
            else -> return AddItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.add_grid_recycler_item, parent, false))
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType){
            0 -> {
                holder as GridViewHolder
                Glide
                    .with(context)
                    .load(list[position].image)
                    .transform(RoundedCorners(15))
                    .into(holder.image)
                holder.text.text = list[position].time_text
            }
            1 -> {
                holder as AddItemViewHolder
                holder.image.setOnClickListener {
                    AlertDialog.Builder(context)
                        .setTitle("Выберите действие")
                        .setMessage("Откуда вы хотите загрузить фотографию")
                        .setPositiveButton("OK", null)
                        .create()
                        .show()
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return list.size + 1
    }
}