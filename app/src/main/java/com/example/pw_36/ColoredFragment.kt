package com.example.pw_36

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.databinding.DataBindingUtil
import com.example.pw_36.databinding.FragmentColoredBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ColoredFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ColoredFragment : Fragment() {
    private var colorId = "#FFFFFF".toColorInt()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            colorId = it.getInt("Color")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentColoredBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_colored, container, false)
        binding.ColoredTV.setBackgroundColor(colorId)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ColoredFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(colorId: Int) =
            ColoredFragment().apply {
                arguments = Bundle().apply {
                    putInt("Color", colorId)
                }
            }
    }
}