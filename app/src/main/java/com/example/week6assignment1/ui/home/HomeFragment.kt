package com.example.week6assignment1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week6assignment1.R
import com.example.week6assignment1.adapter.StudentAdapter
import com.example.week6assignment1.model.Students

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private var lstStudents = ArrayList<Students>()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it

            recyclerView = root.findViewById(R.id.recyclerView)

            loadStudents()
            val adapter = StudentAdapter(lstStudents,requireContext())
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = adapter
        })
        return root
    }

    private fun loadStudents(){
        lstStudents.add(Students(1,
            "Sanjay",
            "https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg",
            22,"Male","Kathmandu"))

        lstStudents.add(Students(2,
            "Sanjay",
            "https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg",
            22,"Male","Kathmandu"))
        lstStudents.add(Students(3,
            "Sanjay",
            "https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg",
            22,"Male","Kathmandu"))
        lstStudents.add(Students(4,
            "Sanjay",
            "https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg",
            22,"Male","Kathmandu"))
    }
}
