package com.example.homework17

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.homework17.databinding.ItemnoteBinding

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private val listOfNotes = mutableListOf<NoteModel>()
    fun updateList(newList: List<NoteModel>) {
        listOfNotes.clear()
        listOfNotes.addAll(newList)
        notifyDataSetChanged()
    }

    private var click: Clicking? = null
    fun setNote(clickListener: Clicking) {
        click = clickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemnoteBinding.inflate(inflater, parent, false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listOfNotes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(listOfNotes[position], click)
    }

    inner class NoteViewHolder(private var binding: ItemnoteBinding) : ViewHolder(binding.root) {
        fun bind(data: NoteModel, click: Clicking?) {
//            val randomColor = listOfColors.random()
            binding.cvNote.setBackgroundResource(data.color)
            binding.tvTitle.text = data.title
            binding.cvNote.setOnClickListener {
                click?.clickNote(data)
            }
        }
    }
}


