package com.example.prctica1.models

import android.os.Parcel
import android.os.Parcelable

data class Punto(var A : String?, var B : String?, var x : String?, var y : String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(A)
        parcel.writeString(B)
        parcel.writeString(x)
        parcel.writeString(y)
    }

    companion object CREATOR : Parcelable.Creator<Punto> {
        override fun createFromParcel(parcel: Parcel): Punto {
            return Punto(parcel)
        }

        override fun newArray(size: Int): Array<Punto?> {
            return arrayOfNulls(size)
        }
    }
}
