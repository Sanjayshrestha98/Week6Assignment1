package com.example.week6assignment1.model

val listStudents = mutableListOf<Students>()

class Database {
    fun appendStudent(students: Students) {
        listStudents.add(students)
    }

    fun returnStudent(): MutableList<Students> {
        return listStudents
    }
}