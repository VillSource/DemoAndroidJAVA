package com.example.demooop_ktx.firedb

data class ListData(
    var isChecked : Boolean = false,
    var title : String = "New Task",
    var detail : String = "",
    var group: Int,
    var id :String = ""
)
