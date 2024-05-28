package com.busanit.ch11_persistence.ex_todo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// 3. 데이터베이스 클래스 생성
@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao() : TodoDao

    // 싱글턴 패턴으로 DB 생성
    // (DB객체는 생성비용이 크고, 2개이상 생성될 필요 없음)
    // (생성시, 메인 스레드(UI 스레드가 멈추지 않게 비동기 구현)
    companion object {
        private var INSTANCE: TodoDatabase? = null

        fun getDatabase(context: Context): TodoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java,
                    "todo_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}