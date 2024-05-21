package com.busanit.ch09_recycler_view.recyclerView

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.busanit.ch09_recycler_view.R
import com.busanit.ch09_recycler_view.databinding.ActivityRecyclerViewBinding
import com.busanit.ch09_recycler_view.databinding.CarItemBinding

class RecyclerViewActivity : AppCompatActivity() {
    data class Car(val name: String, val maker: String)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터 준비
        val carList = mutableListOf<Car>()
        for (i in 1..100) {
            carList.add(Car("자동차 $i", "제조사 $i"))
        }

        // 어뎁터 설정 (필수)
        binding.recyclerView.adapter = RecyclerViewAdapter(carList)

        // 레이아웃 매니저 설정 (필수)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        //binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        //binding.recyclerView.layoutManager = GridLayoutManager(this, 2)

        // 항목 사이를 꾸며주는 도구 (선택)
        // 기본 구분선
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.recyclerView.addItemDecoration(itemDecoration)

        // 커스텀 데코레이션
        class CustomItemDecoration(val space: Int) : RecyclerView.ItemDecoration() {
            // 아이템 항목 간 간격
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.top = space
                outRect.left = space
                outRect.right = space
                outRect.bottom = space
            }
        }
    }
}

class RecyclerViewAdapter(val carList: MutableList<RecyclerViewActivity.Car>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // 뷰 홀더 클래스를 정의 (필수)
    inner class ViewHolder(val binding: CarItemBinding) : RecyclerView.ViewHolder(binding.root) {
        // 뷰 홀더를 클릭했을 때 이벤트 리스너 설정
        init {
            binding.root.setOnClickListener{
                val carName = binding.carNameTextView.text.toString()
                val carMaker = binding.carMakerTextView.text.toString()
                Log.d("mylog", "$carName, $carMaker 선택하였습니다.")
            }
        }
    }

    // 아이템 뷰를 생성해서 뷰 홀더에 바인딩
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // car_item.xml 레이아웃을 인플레이트
        val binding = CarItemBinding.inflate(
            LayoutInflater.from(parent.context),     // layoutInflater를 부모 Context에서 가져옴
            parent,
            false
        )
        // 뷰홀더 반환
        return ViewHolder(binding)
    }

    // 뷰홀더에 데이터를 바인딩
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val car = carList[position]  // 데이터 목록에서 해당 위치 데이터 가져오기

        val binding = (holder as ViewHolder).binding    // 뷰홀더에서 binding 정보 가져오기

        // 뷰에 데이터 바인딩
        binding.run {
            carImageView.setImageResource(R.mipmap.ic_launcher)
            carNameTextView.text = car.name
            carMakerTextView.text = car.maker
        }
    }

    // 항목의 총 개수 반환
    override fun getItemCount(): Int = carList.size
}