package com.example.week6assignment1.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.week6assignment1.R

class AddstudentFragment : Fragment() {

    private lateinit var addstudentViewModel: AddstudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addstudentViewModel =
            ViewModelProvider(this).get(AddstudentViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_addstudent, container, false)
//        val textView: TextView = root.findViewById(R.id.a)
        addstudentViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
        })
        return root
    }
}