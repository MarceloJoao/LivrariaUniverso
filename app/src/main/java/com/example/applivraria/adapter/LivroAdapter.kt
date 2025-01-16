package com.example.applivraria.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applivraria.model.Livro
import com.example.applivraria.R

class LivroAdapter(val livroList: List<Livro>): RecyclerView.Adapter<LivroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return LivroViewHolder(layoutInflater.inflate(R.layout.item_livro, parent, false))
    }

    override fun getItemCount(): Int {
        return livroList.size
    }

    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        val item = livroList[position]
        holder.render(item)
    }


}