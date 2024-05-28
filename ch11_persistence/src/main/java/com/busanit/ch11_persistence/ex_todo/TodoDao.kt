package com.busanit.ch11_persistence.ex_todo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

// 2. DAO 인터페이스 생성
@Dao
interface TodoDao {
    @Insert
    suspend fun insert(todo: Todo)

    @Query("SELECT*FROM todo_table")
    suspend fun getAllTodos(): List<Todo>

    @Delete
    suspend fun delete(todo: Todo)
}