package com.example.myapplication.views.views_details

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.data.data_model.Book
import kotlinx.android.synthetic.main.fragment_details.*

class DetailFragment : Fragment() {
    private lateinit var viewModel: BookDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BookDetailsViewModel::class.java)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val peopleId = activity?.intent?.getIntExtra(getString(R.string.people_id), 0)
        val bookId = arguments?.getInt(getString(R.string.book_id))
        bookId?.let{
            viewModel.getBookDetails(bookId).observe(this, Observer { bookDetails ->
                populateBookDetails(bookDetails)
            })
        }
    }

    private fun populateBookDetails(book: Book?){
        textViewName.text = book?.judul
        textViewMet.text = book?.pengarang
        buttonContact.text = book?.terbit
        textViewEmail.text = book?.penerbit
        textViewFacebook.text = book?.deskripsi

    }
}