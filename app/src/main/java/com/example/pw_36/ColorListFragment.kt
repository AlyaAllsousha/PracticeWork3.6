package com.example.pw_36

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pw_36.databinding.FragmentColorListBinding

/**
 * A fragment representing a list of Items.
 */
class ColorListFragment : Fragment() {
    val colorsArray = arrayListOf(
        "#FF0000".toColorInt(),
        "#FAB14B".toColorInt(),
        "#F88A68".toColorInt(),
        "#FF5722".toColorInt(),
    )
    private var color:Int =0
    private lateinit var adapter: MyItemRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getInt("Color")?.let {
            color = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_color_list_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            adapter = MyItemRecyclerViewAdapter(resources.getStringArray(R.array.myColors))
            view.adapter = adapter
            adapter.onItemClickListener = object:MyItemRecyclerViewAdapter.OnItemClickListener{
                override fun onItemClick(item: Int) {
                    color = colorsArray[item]
                    Log.d("color", color.toString())
                    (activity as MainActivity).changeColor(color)
                }
            }
        }
        return view
    }
    interface IChangeColor{
        fun changeColor(color: Int){

        }
    }

    companion object {

            // TODO: Customize parameter argument names
            const val ARG_COLUMN_COUNT = "column-count"

            // TODO: Customize parameter initialization
            @JvmStatic
            fun newInstance(color: Int) =
                ColorListFragment().apply {
                    arguments = Bundle().apply {
                        putInt("Color", color)
                    }
                }
        }
    }