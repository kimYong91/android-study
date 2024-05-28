package com.busanit.ch11_persistence.ex_todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.busanit.ch11_persistence.databinding.ItemTodoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// 6. 어뎁터 만들기
class TodoAdapter(
    val dao: TodoDao,       // 매개변수로 DAO 전달
    private val deleteClickHandler: (Todo) -> Unit   // 매개변수로 함수를 전달 (데이터 삭제를 위해 데이터를 연결하는 매개체)
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private var todoList = listOf<Todo>()    // 데이터
    /*
    -RecyclerView 만 할 때는 TodoAdapter에 todoList를 TodoAdapter(val todoList: mutableListOf<Todo>) 식으로
    생성 하였지만 그 이유는 메인 실행 엑티비티에 TodoAdapter를 불러와 메인 실행 엑티비티에 있는 리스트를 가지고 데이터를 저장하고
    목록을 만들었지만 Room을 활용한 이번에는 리스트를 채울 데이터가 TodoDao에 있기 때문에 엑티비티에서 리스트를 만들지 않아서
    궅이 그렇게 할 필요 없음
     */

    // 뷰홀더
    inner class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)    {
        fun bind(todo: Todo) {
            binding.textView.text = todo.task
            binding.buttonDelete.setOnClickListener {
                //deleteClickHandler(todo)  // 전달 받은 이벤트 핸들러
                deleteTodo(todo)

            }
        }

        // 어댑터 내부에서 이벤트 핸들링
        fun deleteTodo(todo: Todo) {
            // 코루틴 스콥 생성 (Dispatchers.IO 입출력에 해당)
            CoroutineScope(Dispatchers.IO).launch {
                dao.delete(todo)        // DB에서 해당 항목 삭제
                todoList = dao.getAllTodos()       // DB에서 모든 항목을 조회하여 데이터 추가

                // 안드로이드에서 UI변경은 반드시 메인 스레드에서 수행되어야 함
                CoroutineScope(Dispatchers.Main).launch {
                    notifyDataSetChanged()  // 변경사항 반영 (UI변경 작업)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todoList[position])
    }

    override fun getItemCount(): Int = todoList.size


    // 데이터베이스 데이터 설정
    fun setTodoList(todoList: MutableList<Todo>) {
        this.todoList = todoList
        notifyDataSetChanged()
    }
}
