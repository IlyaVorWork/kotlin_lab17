package com.ilyavorontsov.lab17

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class BooksInsideFragment(text: String) : Fragment() {

    private val tvText = text

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_books_inside, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvBooksInside = view.findViewById<TextView>(R.id.tvBooksInside)
        tvBooksInside.text = tvText
    }
}