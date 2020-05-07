package com.example.introsliderusingkotlin.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.introsliderusingkotlin.R
import kotlinx.android.synthetic.main.fragment_slider_.*

/**
 * A simple [Fragment] subclass.
 */
class Slider_Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slider_, container, false)
    }


}
