package com.example.pw_36

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorInt

import com.example.pw_36.databinding.FragmentColorListBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val values: Array<String>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {
    var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener{
        fun onItemClick(item:Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int, ): ViewHolder {

        return ViewHolder(
            FragmentColorListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            parent.context
        )


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        val colors = arrayListOf(
            "#FF0000".toColorInt(),
            "#FAB14B".toColorInt(),
            "#F88A68".toColorInt(),
            "#FF5722".toColorInt(),
            )
        holder.colorName.text = item
        holder.colorName.setBackgroundColor(colors[position])
    }

    override fun getItemCount(): Int = values.size


    inner class ViewHolder(binding: FragmentColorListBinding, context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        val colorName: TextView = binding.ColorId

        val cont:Context = context

        init{
            binding.root.setOnClickListener{
                onItemClickListener?.onItemClick(absoluteAdapterPosition)
            }
        }
        override fun toString(): String {
            return super.toString() + " '" + colorName.text + "'"
        }
    }

}