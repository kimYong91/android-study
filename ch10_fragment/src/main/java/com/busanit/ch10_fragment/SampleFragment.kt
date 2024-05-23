package com.busanit.ch10_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class SampleFragment : Fragment() {

    // Fragement의 뷰를 생성하고 반환하는 메서드 (생명주기)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // fragment_sample.XML 레이아웃을 뷰 객체로 반환
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample, container, false)
    }

}