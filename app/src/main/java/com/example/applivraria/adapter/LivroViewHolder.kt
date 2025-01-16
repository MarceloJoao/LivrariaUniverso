package com.example.applivraria.adapter

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.applivraria.DetalhamentoLivrosActivity
import com.example.applivraria.Livro
import com.example.applivraria.databinding.ItemLivroBinding

class LivroViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val binding = ItemLivroBinding.bind(view)

    fun render(livro : Livro){
      binding.tvNomeLivro.text = livro.titulo
      binding.tveditoraLivro.text = livro.Autor
      Glide.with(binding.imageView.context).load(livro.urlImagem).into(binding.imageView)

        itemView.setOnClickListener {
            val context = binding.imageView.context // Obtendo o contexto
            val intent = Intent(context, DetalhamentoLivrosActivity::class.java).apply {
                putExtra("livro", livro) // Passando o objeto Livro
            }
            context.startActivity(intent)
        }
    }


    

}