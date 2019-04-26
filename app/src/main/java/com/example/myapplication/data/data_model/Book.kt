package com.example.myapplication.data.data_model
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
class Book (
    var judul : String = "",
    var pengarang : String = "",
    var terbit : String = "",
    var penerbit : String = "",
    var deskripsi : String = "",
    @PrimaryKey(autoGenerate = true) var id : Int = 0
)