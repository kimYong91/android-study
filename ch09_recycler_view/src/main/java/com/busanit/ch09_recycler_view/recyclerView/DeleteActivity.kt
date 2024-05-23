package com.busanit.ch09_recycler_view.recyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.busanit.ch09_recycler_view.databinding.ActivityDeleteBinding
import com.busanit.ch09_recycler_view.databinding.StudentDeleteItemBinding


// 연습문제 : InsertActivity의 리사이클러뷰에서
// 각 아이템마다 `삭제` 버튼을 추가합니다.
// 아이템의 `삭제`버튼이 클릭될 때 해당 아이템이 리사이클러뷰에서 삭제되도록 구현하세요.
class DeleteActivity : AppCompatActivity() {

    data class Student(val name: String, val age: Int, val grade: Int)

    private lateinit var binding: ActivityDeleteBinding
    private val studentList = mutableListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 가상 데이터
        studentList.add(Student("홍길동", 30, 80))
        studentList.add(Student("임꺽정", 40, 70))
        studentList.add(Student("전우치", 25, 75))

        // 리사이클러뷰 구성요소 준비
        val myAdapter = StudentAdapter(studentList)
        val myLayoutManager =
            LinearLayoutManager(this@DeleteActivity)
        val myItemDecoration =
            DividerItemDecoration(this@DeleteActivity, DividerItemDecoration.VERTICAL)

        // 리사이클러 뷰 설정
        binding.recyclerView.apply {
            adapter = myAdapter
            layoutManager = myLayoutManager
            addItemDecoration(myItemDecoration)
        }

        binding.addButton.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val age = binding.editTextAge.text.toString().toInt()
            val grade = binding.editTextGrade.text.toString().toInt()

            val student = Student(name, age, grade)
            studentList.add(student)
            myAdapter.notifyItemInserted(studentList.size - 1)

            binding.editTextName.text.clear()
            binding.editTextAge.text.clear()
            binding.editTextGrade.text.clear()
        }
    }

    inner class StudentAdapter(
        private val studentList: MutableList<Student>
    ) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

        inner class StudentViewHolder(private val binding: StudentDeleteItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(student: Student) {
                binding.textViewName.text = student.name
                binding.textViewAge.text = "${student.age}세"
                binding.textViewGrade.text = "${student.grade}점"

                binding.deleteButton.setOnClickListener {
                    val position = adapterPosition
                    studentList.removeAt(position)
                    notifyItemRemoved(position)
                    //notifyDataSetChanged()

                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
            val binding =
                StudentDeleteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return StudentViewHolder(binding)
        }

        override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
            holder.bind(studentList[position])
        }

        override fun getItemCount(): Int = studentList.size
    }
}