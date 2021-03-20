package com.example.demooop_ktx.firedb

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

public class Db {
    companion object {
        val db = Firebase.firestore
        fun uploadList(data:ListData) {
            db.collection("TodoApp").document("testUser").collection("todoList")
                .add(data)
                .addOnSuccessListener { Log.d("Anirut", "DocumentSnapshot successfully written!") }
                .addOnFailureListener { e -> Log.w("Anirut", "Error writing document", e) }
        }
    }
}