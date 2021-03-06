package com.example.demooop_ktx

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demooop_ktx.firedb.ListData
import kotlinx.android.synthetic.main.item_todolist.view.*

class TodoAdapter(
    var todos : List<ListData>
):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    inner class TodoViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_todolist,parent,false)
        view.setOnClickListener{
            var txt :String = "view.context.getText()"
            Log.d("Anirut",txt )
        }
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.apply {
            this.setOnClickListener{
                Log.d("Anirut",it.tag.toString())
            }
            this.tag = todos[position].id
            itemTodo.text = todos[position].title
            cbitem.isChecked = todos[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}