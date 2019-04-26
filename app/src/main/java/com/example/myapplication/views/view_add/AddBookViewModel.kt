package com.example.myapplication.views.view_add

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.example.myapplication.MainActivity
import com.example.myapplication.data.data_model.Book

class AddBookViewModel (application: Application) : AndroidViewModel(application) {

    private val bookRepository = getApplication<MainActivity>().getBookRepo()

    fun addBook(book: Book) {
        bookRepository.insertBook(book)
    }
}
