package com.example.myapplication.views.views_list

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.example.myapplication.MainActivity
import com.example.myapplication.data.data_model.Book

class BookListViewModel(application : Application) : AndroidViewModel(application) {
    private val bookRepo = getApplication<MainActivity>().getBookRepo()
    private val bookList = MediatorLiveData<List<Book>>()

    init {
        getAllBook()
    }

    fun getBookList() : LiveData<List<Book>> {
        return bookList
    }

    fun getAllBook(){
        bookList.addSource(bookRepo.getAllBook()){
                bookles -> bookList.postValue(bookles)
        }
    }


}