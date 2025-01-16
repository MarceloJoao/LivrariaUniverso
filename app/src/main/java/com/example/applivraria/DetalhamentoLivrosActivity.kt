package com.example.applivraria

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.applivraria.databinding.ActivityDetalhamentoLivrosBinding

class DetalhamentoLivrosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalhamentoLivrosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetalhamentoLivrosBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val livro = intent.getSerializableExtra("livro") as Livro

        binding.textView2.text= livro.ISBN.toString()
        binding.edTituloo.text = livro.titulo
        binding.edAutorr.text = livro.Autor
        binding.edEditoraa.text = livro.Editora
        binding.edDescricaoo.text = livro.Descricao
        Glide.with(this).load(livro.urlImagem).into(binding.imageView2)

    }
}