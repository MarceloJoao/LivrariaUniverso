package com.example.applivraria.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.applivraria.ui.DetalhamentoLivrosActivity
import com.example.applivraria.model.Livro
import com.example.applivraria.databinding.ItemLivroBinding

class LivroViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val binding = ItemLivroBinding.bind(view)

    fun render(livro : Livro){
      binding.tvNomeLivro.text = livro.titulo
      binding.tveditoraLivro.text = livro.Autor
      Glide.with(binding.imageView.context).load(livro.urlImagem).into(binding.imageView)

        itemView.setOnClickListener {
            val context = binding.imageView.context //obtendo o contexto pela imageView
            val intent = Intent(context, DetalhamentoLivrosActivity::class.java).apply {
                putExtra("livro", livro) // Passando o objeto Livro
            }
            context.startActivity(intent)
        }
    }


    

}