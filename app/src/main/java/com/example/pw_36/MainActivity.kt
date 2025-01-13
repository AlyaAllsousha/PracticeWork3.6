package com.example.pw_36

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.ListFragment
import com.example.pw_36.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ColorListFragment.IChangeColor {
    private var color = "#FFFFFF".toColorInt()
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("Color", color)
        super.onSaveInstanceState(outState)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            color = savedInstanceState.getInt("Color")
        }
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        if(savedInstanceState == null)
        supportFragmentManager.beginTransaction().add(R.id.FrameChoose, ColorListFragment()).add(R.id.FrameColored, ColoredFragment.newInstance(color)).commit()

    }

    override fun changeColor(color: Int) {
       supportFragmentManager.beginTransaction().replace(R.id.FrameColored, ColoredFragment.newInstance(color)).commit()
    }
}