package com.example.week6assignment1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week6assignment1.R
import com.example.week6assignment1.adapter.StudentAdapter
import com.example.week6assignment1.model.Database
import com.example.week6assignment1.model.Students

class HomeFragment : Fragment() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<StudentAdapter.StudentViewHolder>? = null
    private lateinit var homeViewModel: HomeViewModel
    private var lstStudents = ArrayList<Students>()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = root.findViewById(R.id.recyclerView)
        val db = Database()
        val adapter = context?.let { StudentAdapter(db.returnStudent() as ArrayList<Students>, it) }
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        return root
    }
}
