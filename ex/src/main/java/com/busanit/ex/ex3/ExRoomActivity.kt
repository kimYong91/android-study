package com.busanit.ex.ex3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.busanit.ex.databinding.ActivityExRoomBinding
import com.busanit.ex.databinding.ExRoomDataBinding

class ExRoomActivity : AppCompatActivity() {
    lateinit var binding: ActivityExRoomBinding
    val exRoomDataList = mutableListOf<ExRoomData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myAdapter = ExRoomDataAdapter(exRoomDataList)
        val myLayoutManager = LinearLayoutManager(this)
        val myItemDirection = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        binding.run {
            recyclerView.apply {
                adapter = myAdapter
                layoutManager = myLayoutManager
                addItemDecoration(myItemDirection)
            }
            buttonSave.setOnClickListener {
                val name = editName.text.toString()
                val age = editAge.text.toString().toInt()

                val exRoomData = ExRoomData(name, age)
                exRoomDataList.add(exRoomData)
                myAdapter.notifyItemInserted(exRoomDataList.size -1)
            }
        }
    }


}
class ExRoomDataAdapter(val exRoomDataList: MutableList<ExRoomData>) : RecyclerView.Adapter<ExRoomDataAdapter.ExRoomDataHolder>(){

    inner class ExRoomDataHolder(val binding: ExRoomDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(exRoomData: ExRoomData){
            binding.run {
                textName.text = exRoomData.name
                textAge.text = exRoomData.age.toString()

                deleteButton.setOnClickListener {
                    val position = adapterPosition
                    exRoomDataList.removeAt(position)
                    notifyItemRemoved(position)
                }


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExRoomDataHolder {
        val binding = ExRoomDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExRoomDataHolder(binding)
    }

    override fun getItemCount(): Int = exRoomDataList.size

    override fun onBindViewHolder(holder: ExRoomDataHolder, position: Int) {
        holder.bind(exRoomDataList[position])
    }

}