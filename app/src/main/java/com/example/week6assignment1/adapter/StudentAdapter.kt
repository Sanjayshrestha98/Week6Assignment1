package com.example.week6assignment1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week6assignment1.R
import com.example.week6assignment1.model.Database
import com.example.week6assignment1.model.Students
import de.hdodenhof.circleimageview.CircleImageView

private var database = Database()
private var listStudents = database.returnStudent()

class StudentAdapter(
    val lstStudents: ArrayList<Students>,
    val context: Context): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    class StudentViewHolder(view:View): RecyclerView.ViewHolder(view){
        val imgProfile : CircleImageView
        val tvFullname:TextView
        val tvAddress:TextView
        val tvage:TextView
        val tvGender:TextView
        val btndelete:Button

        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            tvFullname = view.findViewById(R.id.tvFullname)
            tvAddress = view.findViewById(R.id.tvaddress)
            tvage = view.findViewById(R.id.tvage)
            tvGender = view.findViewById(R.id.tvgender)
            btndelete = view.findViewById(R.id.btndelete)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.student_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val info = lstStudents[position]
        holder.tvFullname.text = info.name
        holder.tvAddress.text = info.address
        holder.tvGender.text = info.gender
        holder.tvage.text = info.age.toString()
        println(info)
        holder.btndelete.setOnClickListener(View.OnClickListener {
            listStudents.remove(info)
            notifyItemRemoved(position)
            Toast.makeText(context, "Student Deleted", Toast.LENGTH_LONG).show()
        })

        Glide.with(context)
            .load(info?.imageURL)
            .into(holder.imgProfile)
    }

    override fun getItemCount(): Int {
        return lstStudents.size
    }
}