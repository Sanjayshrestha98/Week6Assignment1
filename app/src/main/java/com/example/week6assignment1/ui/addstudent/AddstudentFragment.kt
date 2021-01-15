package com.example.week6assignment1.ui.addstudent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.week6assignment1.R
import com.example.week6assignment1.model.Database
import com.example.week6assignment1.model.Students


class AddstudentFragment : Fragment() {

    private lateinit var addstudentViewModel: AddstudentViewModel
    private lateinit var etname: EditText
    private lateinit var etaddress: EditText
    private lateinit var etage: EditText
    private lateinit var rggender: RadioGroup
    private lateinit var btnsave: Button
    private lateinit var rbmale: RadioButton
    private lateinit var rbfemale: RadioButton
    private lateinit var rbothers: RadioButton
    private lateinit var etimage: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addstudentViewModel =
            ViewModelProvider(this).get(AddstudentViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_addstudent, container, false)

        etname = root.findViewById(R.id.etname)
        etaddress = root.findViewById(R.id.etaddress)
        etage = root.findViewById(R.id.etage)
        rggender = root.findViewById(R.id.rggender)
        btnsave = root.findViewById(R.id.btnsave)
        rbmale = root.findViewById(R.id.rbmale)
        rbfemale = root.findViewById(R.id.rbfemale)
        rbothers = root.findViewById(R.id.rbothers)
        etimage = root.findViewById(R.id.etimage)

        btnsave.setOnClickListener {

            if (isValid()) {
                val database = Database()

                val checkID = rggender.checkedRadioButtonId
                val checkedrb: RadioButton = root.findViewById(checkID)
                val gender = checkedrb.text.toString();
                database.appendStudent(
                    Students(
                        etname.text.toString(),
                        etage.text.toString().toInt(),
                        gender,
                        etaddress.text.toString(),
                        etimage.text.toString()
                    )
                )
                Toast.makeText(activity?.applicationContext, "Student Added", Toast.LENGTH_LONG)
                    .show()
                clearFields()
            }
            addstudentViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
            })
        }
        return root
    }

    private fun clearFields() {
        etname.setText("")
        etage.setText("")
        rggender.clearCheck()
        etaddress.setText("")
        etimage.setText("")
    }

    private fun isValid(): Boolean {
        var flag = true
        if (TextUtils.isEmpty(etname.text)) {
            etname.error = "Please enter Username"
            etname.requestFocus()
            flag = false
        } else if (TextUtils.isEmpty(etage.text)) {
            etage.error = "Please enter age"
            etage.requestFocus()
            flag = false
        } else if (TextUtils.isEmpty(etaddress.text)) {
            etaddress.error = "Please enter address"
            etaddress.requestFocus()
            flag = false
        } else if (TextUtils.isEmpty(etimage.text)) {
            etimage.error = "Please enter image URL"
            etimage.requestFocus()
            flag = false
        }
        return flag
    }

    fun onExit(selectionValue: String) {
        val intent = Intent()
        intent.putExtra("selection", selectionValue)
        targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_OK, intent)
    }
}