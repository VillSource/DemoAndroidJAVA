package com.example.demooop_ktx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.forEachIndexed
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demooop_ktx.firedb.Db
import com.example.demooop_ktx.firedb.ListData
import com.google.firebase.firestore.DocumentChange
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        btnUploadTodoList.setOnClickListener {
            var isChecked : Boolean = false
            var title : String = etTodoTitle.text.toString()
            var detail : String = ""
            var group: Int =0
            if (title.isEmpty())
                Toast.makeText(this,"no title",Toast.LENGTH_SHORT).show()
            else
                Db.uploadList(ListData(isChecked, title, detail, group))
        }

        Db.getListToRV(rvListTodo,this)

    }
}