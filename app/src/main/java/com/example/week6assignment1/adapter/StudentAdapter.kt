package com.example.week6assignment1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week6assignment1.R
import com.example.week6assignment1.model.Students
import de.hdodenhof.circleimageview.CircleImageView

class StudentAdapter(
    val lstStudents:ArrayList<Students>,
    val context: Context
): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    class StudentViewHolder(view:View): RecyclerView.ViewHolder(view){
        val imgProfile : CircleImageView
        val tvFullname:TextView
        val tvAddress:TextView
        val tvage:TextView
        val tvGender:TextView

        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            tvFullname = view.findViewById(R.id.tvFullname)
            tvAddress = view.findViewById(R.id.tvaddress)
            tvage = view.findViewById(R.id.tvage)
            tvGender = view.findViewById(R.id.tvgender)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.student_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val actor = lstStudents[position]
        holder.tvFullname.text = actor.fullname
        holder.tvAddress.text = actor.address
        holder.tvage.text = actor.age.toString()
        Glide.with(context).load(actor.studentImageURL).into(holder.imgProfile)
    }

    override fun getItemCount(): Int {
        return lstStudents.size
    }
}