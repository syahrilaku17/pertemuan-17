package com.example.myapplication.data.data_net

import com.example.myapplication.data.data_model.Book

class BookListInfo{
    companion object {
        var bookList = initBookList()

        /**
         * add dummy data
         */

        private fun initBookList() : MutableList<Book>{
            var po_books = mutableListOf<Book>()
            po_books.add(
                Book(
                    "Ketika Cinta Bertasbih I",
                    "habiburahman El Shirazy",
                    "2017",
                    "Percetakan Kwitang",
                    "Percintaan seorang santri mesir",
                    1))
            po_books.add(
                Book(
                    "Ketika Cinta Bertasbih II",
                    "habiburahman El Shirazy",
                    "2018",
                    "Percetakan Kwitang",
                    "Percintaan seorang santri mesir",
                    2))
            po_books.add(
                Book(
                    "Ketika Cinta Bertasbih III",
                    "habiburahman El Shirazy",
                    "2019",
                    "Percetakan Kwitang",
                    "Percintaan seorang santri mesir",
                    3))

            return po_books
        }
    }
}