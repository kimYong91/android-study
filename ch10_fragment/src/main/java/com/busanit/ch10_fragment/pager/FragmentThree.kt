package com.busanit.ch10_fragment.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.busanit.ch10_fragment.databinding.FragmentThreeBinding

class FragmentThree : Fragment() {

    lateinit var binding: FragmentThreeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

}