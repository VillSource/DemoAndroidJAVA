package com.example.demooop_ktx.firedb

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demooop_ktx.TodoAdapter
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_list.*
import java.security.AccessControlContext

class Db {
    companion object {
        val db = Firebase.firestore
        fun uploadList(data:ListData) {
            db.collection("TodoApp").document("testUser").collection("todoList")
                .add(data)
                .addOnSuccessListener { Log.d("Anirut", "DocumentSnapshot successfully written!") }
                .addOnFailureListener { e -> Log.w("Anirut", "Error writing document", e) }
        }
        fun getListToRV(rvListTodo:RecyclerView,context: Context){


            var todolist = mutableListOf<ListData>()
            val adapter = TodoAdapter(todolist)
            rvListTodo.adapter = adapter
            rvListTodo.layoutManager = LinearLayoutManager(context)
            adapter.notifyDataSetChanged()

            Db.db.collection("TodoApp").document("testUser").collection("todoList")
                .addSnapshotListener { snapshot, e ->
                    if (e != null) {
                        Log.w("Anirut", "Listen failed.", e)
                        return@addSnapshotListener
                    }

                    if (snapshot != null && !snapshot.isEmpty) {
                        Log.d("Anirut", "Current data: ${snapshot.toString()}")
                        for (doc in snapshot.documentChanges){
                            val data  =ListData(group = 0,title = doc.document.get("title").toString(),id = doc.document.id)
                            when(doc.type){
                                DocumentChange.Type.ADDED -> todolist.add(data)
                            }
                        }
                        adapter.notifyDataSetChanged()
                    } else {
                        Log.d("Anirut", "Current data: null")
                    }
                }

        }
    }
}