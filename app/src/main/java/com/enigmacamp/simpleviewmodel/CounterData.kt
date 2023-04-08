package com.enigmacamp.simpleviewmodel

import android.os.Parcel
import android.os.Parcelable

// Parcelable itu sebuah interface, yg memungkinkan object untuk di konversi ke bentuk transfer data atau transfer antar component.
// selain parceable ada apa? ada serialize, tapi parcelalbe diatas serialize
data class CounterData(var counter : Int = 0) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(counter)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CounterData> {
        override fun createFromParcel(parcel: Parcel): CounterData {
            return CounterData(parcel)
        }

        override fun newArray(size: Int): Array<CounterData?> {
            return arrayOfNulls(size)
        }
    }
}

