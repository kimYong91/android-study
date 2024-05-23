package com.busanit.ch10_fragment.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.busanit.ch10_fragment.databinding.FragmentTwoBinding

class FragmentTwo : Fragment() {

    lateinit var binding: FragmentTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

}