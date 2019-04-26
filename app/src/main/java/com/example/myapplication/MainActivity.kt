package com.example.myapplication

import android.app.Application
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.data.BookRepo


class MainActivity : Application(){
    fun getBookRepo() = BookRepo(this)
}