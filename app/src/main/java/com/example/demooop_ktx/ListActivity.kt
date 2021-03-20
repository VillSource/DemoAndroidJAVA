package com.example.demooop_ktx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demooop_ktx.firedb.Db
import com.example.demooop_ktx.firedb.ListData

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        var isChecked : Boolean = false
        var title : String = "New Task"
        var detail : String = ""
        var group: Int =0

//        Db.uploadList(ListData(
//            isChecked,
//            title,
//            detail,
//            group
//        ))
    }
}