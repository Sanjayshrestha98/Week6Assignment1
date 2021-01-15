package com.example.week6assignment1.model

import android.os.Parcel
import android.os.Parcelable

data class Students(
    val name:String?=null,
    val age:Int?=null,
    val gender:String?=null,
    val address:String?=null,
    val imageURL:String?=null
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeValue(age)
        parcel.writeString(gender)
        parcel.writeString(address)
        parcel.writeString(imageURL)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Students> {
        override fun createFromParcel(parcel: Parcel): Students {
            return Students(parcel)
        }

        override fun newArray(size: Int): Array<Students?> {
            return arrayOfNulls(size)
        }
    }
}