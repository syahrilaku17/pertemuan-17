package com.example.myapplication.data.db_only

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.myapplication.data.data_model.Book

@Dao
interface BookDAO {
    @Query("select * from book order by id desc")
    fun getAll() : LiveData<List<Book>>

    //query insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(book: Book)

    //query delete
    @Query("delete from book")
    fun deleteAll()

    //query select by id
    @Query("select * from book where id = :id")
    fun find(id : Int): LiveData<Book>
}