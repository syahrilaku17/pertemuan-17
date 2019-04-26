package com.example.myapplication.data.db_only

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.os.AsyncTask
import com.example.myapplication.data.data_model.Book
import com.example.myapplication.data.data_net.BookListInfo

@Database(entities = [Book::class], version = 1)
abstract class BookDB : RoomDatabase() {
    abstract fun bookDao() : BookDAO

    companion object {
        private val lock = Any()
        private const val DB_NAME = "book.db"
        private var INSTANCE: BookDB? = null

        fun getInstance(application: Application) : BookDB{
            synchronized(lock){
                if (BookDB.INSTANCE == null){
                    BookDB.INSTANCE =
                        Room.databaseBuilder(application,
                            BookDB::class.java, BookDB.DB_NAME)
                            .allowMainThreadQueries()
                            .addCallback(object : RoomDatabase.Callback(){
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                    BookDB.INSTANCE?.let{
                                        BookDB.prePopulated(it, BookListInfo.bookList)
                                    }
                                }
                            })
                            .build()
                }
                return INSTANCE!!
            }
        }

        fun prePopulated(database : BookDB, bookList : List<Book>){
            for (book in bookList){
                AsyncTask.execute { database.bookDao().insert(book) }
            }
        }
    }
}