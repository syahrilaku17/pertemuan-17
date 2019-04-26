package com.example.myapplication.data

import android.app.Application
import android.arch.lifecycle.LiveData
import com.example.myapplication.data.data_model.Book
import com.example.myapplication.data.db_only.BookDAO
import com.example.myapplication.data.db_only.BookDB

class BookRepo (application: Application) {

    private val bookDao : BookDAO

    init {
        val peopleDatabase = BookDB.getInstance(application)
        bookDao = peopleDatabase.bookDao()
    }

    /**
     * menampilkan data tapi secara descending
     */
    fun getAllBook() : LiveData<List<Book>> {
//        val allpeople = PeopleListInfo.peopleList
//        return allpeople.reversed()
        return bookDao.getAll()
    }

    fun insertBook(people: Book){
//        PeopleListInfo.peopleList.add(people)
        bookDao.insert(people)
    }

    fun findBook(id : Int): LiveData<Book> {
//        for (people in PeopleListInfo.peopleList){
//            if(people.id == id){
//                return people
//            }
//        }
//        return null
        return bookDao.find(id)
    }

}